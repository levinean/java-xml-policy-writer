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
    private AttributeDesignator designator;

    @XmlElement(name="Apply")
    private Apply apply;

    public Apply(Optional<FunctionId> functionId,
                 Optional<List<AttributeValue>> values,
                 Optional<AttributeDesignator> designator,
                 Optional<Apply> apply){
        if(functionId.isPresent()){
            this.functionId = functionId.get().getUrn();
        }
        if(values.isPresent()){
            this.values = values.get();
        }
        if(designator.isPresent()){
            this.designator = designator.get();
        }
        if(apply.isPresent()){
            this.apply = apply.get();
        }
    }

    public static Apply isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        List<AttributeValue> values = new LinkedList<AttributeValue>();
        values.add(value);
        AttributeDesignator designator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        return new Apply(Optional.of(FunctionId.STRING_EQUALS),
                         Optional.of(values),
                         Optional.of(designator),
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
        Apply getPersonIdentifiers = new Apply(
                Optional.of(fhirpathFunctionId),
                Optional.of(values),
                Optional.of(resourceDesignator),
                Optional.empty()
        );

        return new Apply(Optional.of(functionId),
                Optional.empty(),
                Optional.of(subjectIdDesignator),
                Optional.of(getPersonIdentifiers));
    }

}
