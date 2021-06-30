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

    public static Match isMiddleware(){
        AttributeValue value = new AttributeValue(DataType.STRING,"middleware");
        AttributeDesignator designator = AttributeDesignator.currentActionNamespace();
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isRead(){
        AttributeValue value = new AttributeValue(DataType.STRING,"read");
        AttributeDesignator designator = AttributeDesignator.requestedActionType();
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        AttributeDesignator designator = AttributeDesignator.requestedResourceType();
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isClient(String clientId){
        AttributeValue value = new AttributeValue(DataType.STRING,clientId);
        AttributeDesignator designator = AttributeDesignator.currentClientId();
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

}
