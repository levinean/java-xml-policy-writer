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

    public AttributeValue getValue(){
        return this.value;
    }

    public AttributeDesignator getDesignator(){
        return this.designator;
    }

    public String getFunctionId(){
        return this.functionId;
    }
}
