import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Rule {

    @XmlAttribute(name="Effect")
    @NonNull private String effect;

    @XmlAttribute(name="RuleId")
    @NonNull private String ruleId;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Target")
    private Target target;

    @XmlElement(name="Condition")
    private Condition condition;


    public static Rule readResourceType(String resourceType){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = String.format("permit-read-resource-%s",resourceType);
        String description = String.format("Permits read access to the following resource: %s",resourceType);
        Target target = Target.readMiddleware();
        Condition condition = Condition.builder().apply(Apply.isResourceType(resourceType)).build();
        return Rule.builder()
                .effect(effect.getValue())
                .ruleId(ruleId)
                .description(description)
                .target(target)
                .condition(condition)
                .build();
    }

    public static Rule readMultipleResourceTypes(List<String> resourceTypes){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = "permit-read-resources";
        String description = String.format("Permits read access to the following resources: %s",resourceTypes.toString());
        Target target = Target.readMiddleware();
        Condition condition = new Condition(Apply.readResources(resourceTypes));
        return Rule.builder()
                .effect(effect.getValue())
                .ruleId(ruleId)
                .description(description)
                .target(target)
                .condition(condition)
                .build();
    }

    public static Rule readOwnPersonResource(){
        RuleEffect effect = RuleEffect.PERMIT;
        String ruleId = "permit-read-user-own-person-resource";
        String description = "Permits read access to the user's own person resource";
        Target target = Target.readOwnPersonResource();
        Condition condition = new Condition(Apply.readOwnPersonResource());
        return Rule.builder()
                .effect(effect.getValue())
                .ruleId(ruleId)
                .description(description)
                .target(target)
                .condition(condition)
                .build();
    }

    public static Rule defaultDeny(){
        return Rule.builder()
                .effect(RuleEffect.DENY.getValue())
                .ruleId("default-deny")
                .build();
    }

}
