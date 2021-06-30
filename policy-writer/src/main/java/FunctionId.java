import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum FunctionId {
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:function:string-bag")
    STRING_BAG,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:function:string-equal")
    STRING_EQUALS,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:function:string-at-least-one-member-of")
    STRING_ONE_MEMBER_OF,
    @XmlEnumValue("commure:xacml:1.0:function:fhir-path")
    FHIR_PATH
}
