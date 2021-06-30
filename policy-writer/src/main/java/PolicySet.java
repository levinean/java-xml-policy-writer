import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name="PolicySet")
public class PolicySet implements Xacml{
    @XmlAttribute
    @Builder.Default
    @NonNull private String xmlns = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17";

    @XmlAttribute(name="xmlns:xsi")
    @Builder.Default
    @NonNull private String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name="xsi:schemaLocation")
    @Builder.Default
    @NonNull private String schemaLocation = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17 ../xacml-core-v3-schema-wd-17.xsd";

    @XmlAttribute(name="Version")
    @Builder.Default
    @NonNull private String version = "1.0";

    @XmlAttribute(name="PolicySetId")
    @NonNull private String policySetId;

    @XmlAttribute(name="PolicyCombiningAlgorithmId")
    @NonNull private PolicyCombiningAlgorithm policyCombiningAlgorithm;

    @XmlElement(name="Description")
    @NonNull private String description;

    @XmlElement(name="Target")
    @NonNull private Target target;

    @XmlElement(name="PolicySet")
    private List<PolicySet> policySets;

    @XmlElement(name="Policy")
    private List<Policy> policies;

    @XmlElement(name="PolicySetIdReference")
    private List<PolicySetIdReference> policySetIdReferences;

    @XmlElement(name="PolicyIdReference")
    private List<PolicyIdReference> policyIdReferences;
}


