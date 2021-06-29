import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AttributeValue {
    @XmlAttribute(name="DataType")
    private String dataType;

    @XmlElement()
    private String value;

    public AttributeValue(DataType dataType, String value){
        this.value = value;
        this.dataType = dataType.getUrn();
    }
}
