import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class AttributeValue {
    @XmlAttribute(name="DataType")
    private String dataType;

    @XmlValue
    private String value;

    public AttributeValue(DataType dataType, String value){
        this.value = value;
        this.dataType = dataType.getUrn();
    }
}
