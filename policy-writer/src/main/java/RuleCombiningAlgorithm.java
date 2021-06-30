import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum RuleCombiningAlgorithm {
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:deny-overrides")
    DENY_OVERRIDES,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:permit-overrides")
    PERMIT_OVERRIDES,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:rule-combining-algorithm:first-applicable")
    FIRST_APPLICABLE ,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:rule-combining-algorithm:only-one-applicable")
    ONLY_ONE_APPLICABLE ,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:ordered-deny-overrides")
    ORDERED_DENY_OVERRIDES ,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:ordered-permit-overrides")
    ORDERED_PERMIT_OVERRIDES ,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:deny-unless-permit")
    DENY_UNLESS_PERMIT ,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:rule-combining-algorithm:permit-unless-deny")
    PERMIT_UNLESS_DENY

}
