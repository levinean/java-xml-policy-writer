import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Rule {

    @XmlAttribute(name="Effect")
    private String effect;

    @XmlAttribute(name="RuleId")
    private String ruleId;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Target")
    private Target target;

    @XmlElement(name="Condition")
    private Condition condition;

    public Rule(RuleEffect effect,String ruleId,String description,Target target,Condition condition){
        this.effect = effect.getValue();
        this.ruleId=ruleId;
        this.description = description;
        this.target=target;
        this.condition=condition;
    }

    public static Rule readResourceType(String resourceType){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = String.format("permit-read-resource-%s",resourceType);
        String description = String.format("Permits read access to the following resource: %s",resourceType);
        Target target = Target.readMiddleware();
        Condition condition = new Condition(Apply.isResourceType(resourceType));
        return new Rule(effect,ruleId,description,target,condition);
    }

    public static Rule readMultipleResourceTypes(List<String> resourceTypes){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = "permit-read-resources";
        String description = String.format("Permits read access to the following resources: %s",resourceTypes.toString());
        Target target = Target.readMiddleware();
        Condition condition = new Condition(Apply.readResources(resourceTypes));
        return new Rule(effect,ruleId,description,target,condition);
    }

    public static Rule readOwnPersonResource(){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = "permit-read-user-own-person-resource";
        String description = "Permits read access to the user's own person resource";
        Target target = Target.readOwnPersonResource();
        Condition condition = new Condition(Apply.readOwnPersonResource());
        return new Rule(effect,ruleId,description,target,condition);
    }

    public static Rule defaultDeny(){
        return new Rule(RuleEffect.DENY,"default-deny",null,null,null);
    }

}
