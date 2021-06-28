import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class PolicyWriterMain {

    private static final String BOOKSTORE_XML = "bookstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        List < Book > bookList = new ArrayList < Book > ();

        // create books
        Book book1 = new Book();
        book1.setIsbn("978-0134685991");
        book1.setName("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setPublisher("Amazon");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-0596009205");
        book2.setName("Head First Java, 2nd Edition");
        book2.setAuthor("Kathy Sierra");
        book2.setPublisher("amazon");
        bookList.add(book2);

        // create bookstore, assigning book
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Amazon Bookstore");
        bookstore.setLocation("Newyorkt");
        bookstore.setBookList(bookList);

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
