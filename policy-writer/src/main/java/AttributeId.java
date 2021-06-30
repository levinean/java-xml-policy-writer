import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(String.class)
public enum AttributeId {
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:client:client-id")
    CLIENT_ID,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:subject:subject-id")
    SUBJECT_ID,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:action:action-namespace")
    ACTION_NAMESPACE,
    @XmlEnumValue("urn:oasis:names:tc:xacml:1.0:action:action-id")
    ACTION_ID,
    @XmlEnumValue("commure:xacml:1.0:attribute:fhir-resource-type")
    FHIR_RESOURCE_TYPE,
    @XmlEnumValue("commure:xacml:1.0:attribute:resource")
    FHIR_RESOURCE;
}
