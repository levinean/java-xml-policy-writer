public enum AttributeCategory {
    OAUTH_CLIENT("urn:oasis:names:tc:xacml:3.0:attribute-category:oauth-client"),
    ACTION("urn:oasis:names:tc:xacml:3.0:attribute-category:action"),
    RESOURCE("urn:oasis:names:tc:xacml:3.0:attribute-category:resource"),
    SUBJECT("urn:oasis:names:tc:xacml:1.0:subject-category:access-subject");

    private String urn;

    AttributeCategory(String urn){
        this.urn = urn;
    }

    public String getUrn(){
        return this.urn;
    }
}
