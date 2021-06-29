import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="Policy")
public class Policy {
    @XmlAttribute
    private String xmlns = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17";

    @XmlAttribute(name="xmlns:xsi")
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name="Version")
    private String version = "1.0";

    @XmlAttribute(name="PolicyId")
    private String policyId;

    @XmlAttribute(name="RuleCombiningAlgorithm")
    private String ruleCombiningAlgorithm;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Target")
    private Target target;

    @XmlElement(name="Rule")
    private List<Rule> rules;

    public Policy(String policyId, RuleCombiningAlgorithm ruleCombiningAlgorithm, String description,Target target,List<Rule> rules){
        this.policyId = policyId;
        this.ruleCombiningAlgorithm = ruleCombiningAlgorithm.getUrn();
        this.description = description;
        this.target = target;
        this.rules = rules;
    }

    public String getXmlns(){
        return this.xmlns;
    }

    public String getVersion(){
        return this.version;
    }

    public String getXsi(){
        return this.xsi;
    }

    public String getDescription(){
        return this.description;
    }

    public String getPolicyId(){
        return this.policyId;
    }

    public String getRuleCombiningAlgorithm(){
        return this.ruleCombiningAlgorithm;
    }

    public Target getTarget(){
        return this.target;
    }

    public List<Rule> getRules(){
        return this.rules;
    }

    public void addRule(Rule rule){
        this.rules.add(rule);
    }

    public void addRules(List<Rule> rules){
        this.rules.addAll(rules);
    }
}

