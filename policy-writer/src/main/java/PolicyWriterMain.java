import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PolicyWriterMain {

    private static final String EXAMPLE_XML_POLICY = "policy.xml";
    private static final String EXAMPLE_XML_POLICYSET = "policy_set.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        List<Rule> rules = new LinkedList<Rule>();
        rules.add(Rule.readResourceType("Subscription"));
        rules.add(Rule.readMultipleResourceTypes(Arrays.asList("Organization","Patient","Practitioner")));
        rules.add(Rule.readOwnPersonResource());
        rules.add(Rule.defaultDeny());

        Policy policy = Policy.builder()
                .policyId("Test-policy-id")
                .ruleCombiningAlgorithm(RuleCombiningAlgorithm.PERMIT_OVERRIDES)
                .description("Test description")
                .target(Target.isClient("admin-controls"))
                .rules(rules)
                .build();
        convertObjectToXML(policy,EXAMPLE_XML_POLICY);

    }

    private static void convertObjectToXML(Xacml policy,String fileName) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Policy.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(policy, System.out);

        // Write to File
        m.marshal(policy, new File(fileName));
    }
}
