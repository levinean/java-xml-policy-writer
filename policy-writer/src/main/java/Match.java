import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Match {

    @XmlAttribute(name="MatchId")
    private String matchId;

    @XmlElement(name="AttributeValue")
    private AttributeValue value;

    public Match(FunctionId functionId, AttributeValue value ){
        this.matchId = functionId.getUrn();
        this.value = value;
    }
}
