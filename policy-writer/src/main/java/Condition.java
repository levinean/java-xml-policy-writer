import javax.xml.bind.annotation.XmlElement;

public class Condition {

    @XmlElement(name="Apply")
    private Apply apply;


    public Condition(Apply apply){
        this.apply = apply;
    }

}
