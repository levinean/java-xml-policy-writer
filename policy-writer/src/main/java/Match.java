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
        AttributeDesignator designator = new AttributeDesignator(AttributeId.ACTION_NAMESPACE,AttributeCategory.ACTION,DataType.STRING);
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isRead(){
        AttributeValue value = new AttributeValue(DataType.STRING,"read");
        AttributeDesignator designator = new AttributeDesignator(AttributeId.ACTION_ID,AttributeCategory.ACTION,DataType.STRING);
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isResourceType(String resourceType){
        AttributeValue value = new AttributeValue(DataType.STRING,resourceType);
        AttributeDesignator designator = new AttributeDesignator(AttributeId.FHIR_RESOURCE_TYPE,AttributeCategory.RESOURCE,DataType.STRING);
        return new Match(FunctionId.STRING_EQUALS,value,designator);
    }

    public static Match isClient(String clientId){
        AttributeValue value = new AttributeValue(DataType.STRING,clientId);
        AttributeDesignator designator = new AttributeDesignator(AttributeId.CLIENT_ID,AttributeCategory.OAUTH_CLIENT,DataType.STRING);
        return new Match(FunctionId.STRING_EQUALS,value,designator);
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
