public enum DataType {
    FHIR_PATH("commure:xacml:1.0:data-type:fhir-path"),
    STRING("http://www.w3.org/2001/XMLSchema#string");

    private String urn;

    private DataType(String urn){
        this.urn = urn;
    }

    public String getUrn(){
        return this.urn;
    }

}
