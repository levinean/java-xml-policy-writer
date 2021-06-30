import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Apply {

    @XmlAttribute(name="FunctionId")
    @NonNull private String functionId;

    @XmlElement(name="AttributeValue")
    private List<AttributeValue> values;

    @XmlElement(name="AttributeDesignator")
    private List<AttributeDesignator> designators;

    @XmlElement(name="Function")
    private List<FunctionArg> functions;

    @XmlElement(name="Apply")
    private List<Apply> applies;


    public static Apply isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        List<AttributeValue> values = new LinkedList<AttributeValue>();
        values.add(value);
        AttributeDesignator designator = AttributeDesignator.requestedResourceType();
        List<AttributeDesignator> designators = new LinkedList<AttributeDesignator>();
        designators.add(designator);
        return Apply.builder()
                    .functionId(FunctionId.STRING_EQUALS.getUrn())
                    .values(values)
                    .designators(designators)
                    .build();
    }

    public static Apply readOwnPersonResource(){
        FunctionId functionId = FunctionId.STRING_ONE_MEMBER_OF;
        AttributeDesignator subjectIdDesignator = AttributeDesignator.currentSubjectId();

        FunctionId fhirpathFunctionId = FunctionId.FHIR_PATH;
        String fhirpath = "identifier.value";
        AttributeValue fhirpathValue = new AttributeValue(DataType.STRING,fhirpath);
        List<AttributeValue> values = new LinkedList<AttributeValue>();
        values.add(fhirpathValue);
        AttributeDesignator resourceDesignator = AttributeDesignator.requestedResourceType();
        List<AttributeDesignator> resourceDesignators = new LinkedList<AttributeDesignator>();
        resourceDesignators.add(resourceDesignator);
        Apply getPersonIdentifiers = Apply.builder()
                .functionId(fhirpathFunctionId.getUrn())
                .values(values)
                .designators(resourceDesignators)
                .build();

        List<AttributeDesignator> subjectIdDesignators = new LinkedList<AttributeDesignator>();
        subjectIdDesignators.add(subjectIdDesignator);
        List<Apply> applyInputs = new LinkedList<Apply>();
        applyInputs.add(getPersonIdentifiers);
        return Apply.builder()
                .functionId(functionId.getUrn())
                .designators(subjectIdDesignators)
                .applies(applyInputs)
                .build();
    }

    public static Apply readResources(List<String> resources){
        FunctionId functionId = FunctionId.STRING_ONE_MEMBER_OF;
        AttributeDesignator resourceDesignator = AttributeDesignator.requestedResourceType();
        List<AttributeDesignator> resourceDesignators = new LinkedList<AttributeDesignator>();
        resourceDesignators.add(resourceDesignator);

        FunctionId stringBagFunctionId = FunctionId.STRING_BAG;

        List<AttributeValue> resourceTypeValues = new LinkedList<AttributeValue>();
        resources.forEach((String resourceType) -> resourceTypeValues.add(new AttributeValue(DataType.STRING,resourceType)));
        Apply buildResourceTypeBag = Apply.builder()
                .functionId(stringBagFunctionId.getUrn())
                .values(resourceTypeValues)
                .build();

        List<Apply> applyInputs = new LinkedList<Apply>();
        applyInputs.add(buildResourceTypeBag);

        return Apply.builder()
                .functionId(functionId.getUrn())
                .designators(resourceDesignators)
                .applies(applyInputs)
                .build();
    }

}
