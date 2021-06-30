import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private RuleCombiningAlgorithm ruleCombiningAlgorithm;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Target")
    private Target target;

    @XmlElement(name="Rule")
    private List<Rule> rules;

//    @XmlAttribute(name="RuleCombiningAlgorithm")
//    private String getRuleCombiningAlgorithm(){
//        return this.ruleCombiningAlgorithm.getUrn();
//    }
}

