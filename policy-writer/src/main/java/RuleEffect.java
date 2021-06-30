public enum RuleEffect {
    PERMIT("Permit"),
    DENY("Deny");

    private String value;

    RuleEffect(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
