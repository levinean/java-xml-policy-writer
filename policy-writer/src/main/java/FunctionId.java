public enum FunctionId {
    STRING_EQUALS("urn:oasis:names:tc:xacml:1.0:function:string-equal"),
    STRING_ONE_MEMBER_OF("urn:oasis:names:tc:xacml:1.0:function:string-at-least-one-member-of"),
    FHIR_PATH("commure:xacml:1.0:function:fhir-path");

    private String urn;

    private FunctionId(String urn){
        this.urn = urn;
    }

    public String getUrn(){
        return this.urn;
    }
}
