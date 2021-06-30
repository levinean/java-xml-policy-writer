import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum DataType {
    @XmlEnumValue("commure:xacml:1.0:data-type:fhir-path")
    FHIR_PATH,
    @XmlEnumValue("http://www.w3.org/2001/XMLSchema#string")
    STRING
}
