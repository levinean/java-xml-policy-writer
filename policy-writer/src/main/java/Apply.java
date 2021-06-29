import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Apply {

    @XmlAttribute(name="FunctionId")
    private String functionId;

    @XmlElement(name="AttributeValue")
    private AttributeValue value;

    @XmlElement(name="AttributeDesignator")
    private AttributeDesignator designator;

    public Apply(FunctionId functionId, AttributeValue value, AttributeDesignator designator ){
        this.functionId = functionId.getUrn();
        this.value = value;
        this.designator = designator;
    }

    public static Apply isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        AttributeDesignator designator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        return new Apply(FunctionId.STRING_EQUALS,value,designator);
    }

}
