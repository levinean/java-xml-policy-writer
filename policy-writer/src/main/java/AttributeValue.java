import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeValue {
    @XmlAttribute(name="DataType")
    private DataType dataType;

    @XmlValue
    private String value;

    public static AttributeValue string(String value){
        return AttributeValue.builder().dataType(DataType.STRING).value(value).build();
    }

    public static AttributeValue fhirpath(String value){
        return AttributeValue.builder().dataType(DataType.FHIR_PATH).value(value).build();
    }
}
