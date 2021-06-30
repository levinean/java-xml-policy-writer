import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum AttributeCategory {
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:attribute-category:oauth-client")
    OAUTH_CLIENT,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:attribute-category:action")
    ACTION,
    @XmlEnumValue("urn:oasis:names:tc:xacml:3.0:attribute-category:resource")
    RESOURCE,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:subject-category:access-subject")
    SUBJECT;
}
