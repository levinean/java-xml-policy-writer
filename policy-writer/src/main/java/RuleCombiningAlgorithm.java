public enum RuleCombiningAlgorithm {
    DENY_OVERRIDES("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-overrides"),
    PERMIT_OVERRIDES("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides"),
    FIRST_APPLICABLE ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:first-applicable"),
    ONLY_ONE_APPLICABLE ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:only-one-applicable"),
    ORDERED_DENY_OVERRIDES ("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:ordered-deny-overrides"),
    ORDERED_PERMIT_OVERRIDES ("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:ordered-permit-overrides"),
    DENY_UNLESS_PERMIT ("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-unless-permit"),
    PERMIT_UNLESS_DENY ("urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-unless-deny");

    private String urn;

    RuleCombiningAlgorithm(String urn){
        this.urn = urn;
    }

    public String getUrn(){
        return this.urn;
    }
}
