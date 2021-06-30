import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum PolicyCombiningAlgorithm {
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-overrides")
    DENY_OVERRIDES,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides")
    PERMIT_OVERRIDES,
}
