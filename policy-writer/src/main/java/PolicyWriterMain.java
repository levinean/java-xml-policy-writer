import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class PolicyWriterMain {

    private static final String BOOKSTORE_XML = "bookstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        convertObjectToXML(bookstore);

    }

    private static void convertObjectToXML(Bookstore bookstore) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(bookstore, System.out);

        // Write to File
        m.marshal(bookstore, new File(BOOKSTORE_XML));
    }
}
