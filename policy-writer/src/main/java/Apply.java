import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Apply {

    @XmlAttribute(name="FunctionId")
    private String functionId;

    @XmlElement(name="AttributeValue")
    private List<AttributeValue> values;

    @XmlElement(name="AttributeDesignator")
    private List<AttributeDesignator> designators;

    @XmlElement(name="Function")
    private List<FunctionArg> functions;

    @XmlElement(name="Apply")
    private List<Apply> applies;

    public Apply(Optional<FunctionId> functionId,
                 Optional<List<AttributeValue>> values,
                 Optional<List<AttributeDesignator>> designators,
                 Optional<List<Apply>> applies,
                 Optional<List<FunctionArg>> functions){
        if(functionId.isPresent()){
            this.functionId = functionId.get().getUrn();
        }
        if(values.isPresent()){
            this.values = values.get();
        }
        if(designators.isPresent()){
            this.designators = designators.get();
        }
        if(applies.isPresent()){
            this.applies = applies.get();
        }

        if(functions.isPresent()){
            this.functions = functions.get();
        }
    }

    public static Apply isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        List<AttributeValue> values = new LinkedList<AttributeValue>();
        values.add(value);
        AttributeDesignator designator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        List<AttributeDesignator> designators = new LinkedList<AttributeDesignator>();
        designators.add(designator);
        return new Apply(Optional.of(FunctionId.STRING_EQUALS),
                         Optional.of(values),
                         Optional.of(designators),
                         Optional.empty(),
                         Optional.empty());
    }

    public static Apply readOwnPersonResource(){
        FunctionId functionId = FunctionId.STRING_ONE_MEMBER_OF;
        AttributeDesignator subjectIdDesignator = new AttributeDesignator(AttributeId.SUBJECT_ID,AttributeCategory.SUBJECT,DataType.STRING);

        FunctionId fhirpathFunctionId = FunctionId.FHIR_PATH;
        String fhirpath = "identifier.value";
        AttributeValue fhirpathValue = new AttributeValue(DataType.STRING,fhirpath);
        List<AttributeValue> values = new LinkedList<AttributeValue>();
        values.add(fhirpathValue);
        AttributeDesignator resourceDesignator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        List<AttributeDesignator> resourceDesignators = new LinkedList<AttributeDesignator>();
        resourceDesignators.add(resourceDesignator);
        Apply getPersonIdentifiers = new Apply(
                Optional.of(fhirpathFunctionId),
                Optional.of(values),
                Optional.of(resourceDesignators),
                Optional.empty(),
                Optional.empty()
        );

        List<AttributeDesignator> subjectIdDesignators = new LinkedList<AttributeDesignator>();
        subjectIdDesignators.add(subjectIdDesignator);
        List<Apply> applyInputs = new LinkedList<Apply>();
        applyInputs.add(getPersonIdentifiers);
        return new Apply(Optional.of(functionId),
                Optional.empty(),
                Optional.of(subjectIdDesignators),
                Optional.of(applyInputs),
                Optional.empty());
    }

    public static Apply readResources(List<String> resources){
        FunctionId functionId = FunctionId.STRING_ONE_MEMBER_OF;
        AttributeDesignator resourceDesignator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        List<AttributeDesignator> resourceDesignators = new LinkedList<AttributeDesignator>();
        resourceDesignators.add(resourceDesignator);

        FunctionId stringBag = FunctionId.STRING_BAG;

        List<AttributeValue> resourceTypeValues = new LinkedList<AttributeValue>();
        resources.forEach((String resourceType) -> resourceTypeValues.add(new AttributeValue(DataType.STRING,resourceType)));
        Apply buildResourceTypeBag = new Apply(
                Optional.of(stringBag),
                Optional.of(resourceTypeValues),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        );

        List<Apply> applyInputs = new LinkedList<Apply>();
        applyInputs.add(buildResourceTypeBag);

        return new Apply(
                Optional.of(functionId),
                Optional.empty(),
                Optional.of(resourceDesignators),
                Optional.of(applyInputs),
                Optional.empty()
        );
    }

}
