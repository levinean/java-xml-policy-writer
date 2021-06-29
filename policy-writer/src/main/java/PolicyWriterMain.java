import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PolicyWriterMain {

    private static final String EXAMPLE_XML = "policy-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        String policyId = "Test-policy-id";
        String description = "Test description";
        RuleCombiningAlgorithm alg = RuleCombiningAlgorithm.PERMIT_OVERRIDES;
        Target target = Target.isClient("admin-controls");

        List<Rule> rules = new LinkedList<Rule>();
        rules.add(Rule.readResourceType("Subscription"));

        List<String> resourceTypes = new LinkedList<String>();
        resourceTypes.add("Organization");
        resourceTypes.add("Patient");
        resourceTypes.add("Practitioner");
        rules.add(Rule.readMultipleResourceTypes(resourceTypes));

        rules.add(Rule.readOwnPersonResource());
        Policy policy = new Policy(
                policyId,
                alg,
                description,
                target,
                rules
        );
        convertObjectToXML(policy);

    }

    private static void convertObjectToXML(Policy policy) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Policy.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(policy, System.out);

        // Write to File
        m.marshal(policy, new File(EXAMPLE_XML));
    }
}
