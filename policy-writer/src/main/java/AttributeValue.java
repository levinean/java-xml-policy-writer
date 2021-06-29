import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AttributeValue {
    @XmlAttribute(name="DataType")
    private String dataType;

    @XmlElement()
    private String value;

    public AttributeValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
