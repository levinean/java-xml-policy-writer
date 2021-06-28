import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="Policy")
public class Policy {
    @XmlAttribute
    private String xmlns = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17";

    @XmlAttribute
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name="PolicyId")
    private String policyId;

    @XmlAttribute(name="RuleCombiningAlgorithm")
    private RuleCombiningAlgorithm ruleCombiningAlgorithm;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Target")
    private Target target;

    @XmlElement(name="Rule")
    private List<Rule> rules;


}

