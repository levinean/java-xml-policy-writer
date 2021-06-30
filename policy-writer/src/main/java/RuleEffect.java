import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum RuleEffect {
    @XmlEnumValue("Permit")
    PERMIT,
    @XmlEnumValue("Deny")
    DENY
}
