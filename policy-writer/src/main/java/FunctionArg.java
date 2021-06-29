import javax.xml.bind.annotation.XmlAttribute;

public class FunctionArg {

    @XmlAttribute(name="FunctionId")
    private String functionId;

    public FunctionArg(FunctionId functionId){
        this.functionId = functionId.getUrn();
    }
}
