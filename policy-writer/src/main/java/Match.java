import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Match {

    @XmlAttribute(name="MatchId")
    private String matchId;

    @XmlElement(name="AttributeValue")
    private AttributeValue value;

    @XmlElement(name="AttributeDesignator")
    private AttributeDesignator designator;

    public Match(FunctionId functionId, AttributeValue value, AttributeDesignator designator ){
        this.matchId = functionId.getUrn();
        this.value = value;
        this.designator = designator;
    }

    public AttributeValue getValue(){
        return this.value;
    }

    public AttributeDesignator getDesignator(){
        return this.designator;
    }

    public String getFunctionId(){
        return this.matchId;
    }
}