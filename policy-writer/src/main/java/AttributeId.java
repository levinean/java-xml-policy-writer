public enum AttributeId {
    CLIENT_ID("urn:oasis:names:tc:xacml:1.0:client:client-id"),
    SUBJECT_ID("urn:oasis:names:tc:xacml:1.0:subject:subject-id"),
    ACTION_NAMESPACE("urn:oasis:names:tc:xacml:1.0:action:action-namespace"),
    ACTION_ID("urn:oasis:names:tc:xacml:1.0:action:action-id"),
    FHIR_RESOURCE_TYPE("commure:xacml:1.0:attribute:fhir-resource-type"),
    FHIR_RESOURCE("commure:xacml:1.0:attribute:resource");


    private String urn;

    private AttributeId(String urn){
        this.urn = urn;
    }

    public String getUrn(){
        return this.urn;
    }
}
