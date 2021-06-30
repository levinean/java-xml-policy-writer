import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Apply {

    @XmlAttribute(name="FunctionId")
    @NonNull private FunctionId functionId;

    @XmlElement(name="AttributeValue")
    private List<AttributeValue> values;

    @XmlElement(name="AttributeDesignator")
    private List<AttributeDesignator> designators;

    @XmlElement(name="Function")
    private List<FunctionArg> functions;

    @XmlElement(name="Apply")
    private List<Apply> applies;


    public static Apply isResourceType(String resourceType){
        AttributeValue value = AttributeValue.string(resourceType);
        AttributeDesignator designator = AttributeDesignator.requestedResourceType();
        return Apply.builder()
                    .functionId(FunctionId.STRING_EQUALS)
                    .values(Collections.singletonList(value))
                    .designators(Collections.singletonList(designator))
                    .build();
    }

    public static Apply readOwnPersonResource(){

        List<AttributeValue> values = Collections.singletonList(AttributeValue.fhirpath("identifier.value"));
        List<AttributeDesignator> resourceDesignators = Collections.singletonList(AttributeDesignator.requestedResourceType());
        Apply getPersonIdentifiers = Apply.builder()
                .functionId(FunctionId.FHIR_PATH)
                .values(values)
                .designators(resourceDesignators)
                .build();

        List<AttributeDesignator> subjectIdDesignators = Collections.singletonList(AttributeDesignator.currentSubjectId());
        List<Apply> applyInputs = Collections.singletonList(getPersonIdentifiers);
        return Apply.builder()
                .functionId(FunctionId.STRING_ONE_MEMBER_OF)
                .designators(subjectIdDesignators)
                .applies(applyInputs)
                .build();
    }

    public static Apply readResources(List<String> resources){

        List<AttributeValue> resourceTypeValues = resources.stream()
                .map(type -> AttributeValue.string(type))
                .collect(Collectors.toList());
        Apply buildResourceTypeBag = Apply.builder()
                .functionId(FunctionId.STRING_BAG)
                .values(resourceTypeValues)
                .build();

        List<Apply> applyInputs = Collections.singletonList(buildResourceTypeBag);
        List<AttributeDesignator> resourceDesignators = Collections.singletonList(AttributeDesignator.requestedResourceType());

        return Apply.builder()
                .functionId(FunctionId.STRING_ONE_MEMBER_OF)
                .designators(resourceDesignators)
                .applies(applyInputs)
                .build();
    }

}
