import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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

    public String getEffect(){
        return this.effect;
    }

    public String getRuleId(){
        return this.ruleId;
    }

    public String getDescription(){
        return this.description;
    }

    public Target getTarget(){
        return this.target;
    }

    public Condition getCondition(){
        return this.condition;
    }

}
