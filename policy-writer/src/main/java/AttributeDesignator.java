import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.crypto.Data;

public class AttributeDesignator {

    @XmlAttribute(name="AttributeId")
    private String attributeId;

    @XmlAttribute(name="Category")
    private String category;

    @XmlAttribute(name="DataType")
    private String dataType;

    @XmlAttribute(name="MustBePresent")
    private String mustBePresent = "false";

    public AttributeDesignator(AttributeId id, AttributeCategory category, DataType dataType){
        this.attributeId = id.getUrn();
        this.category = category.getUrn();
        this.dataType = dataType.getUrn();
    }

    public String getAttributeId(){
        return this.attributeId;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDataType(){
        return this.dataType;
    }
}
