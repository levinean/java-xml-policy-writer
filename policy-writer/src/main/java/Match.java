import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @XmlAttribute(name="MatchId")
    private String matchId;

    @XmlElement(name="AttributeValue")
    private AttributeValue value;

    @XmlElement(name="AttributeDesignator")
    private AttributeDesignator designator;

    public static Match isMiddleware(){
        AttributeValue value = AttributeValue.string("middleware");
        AttributeDesignator designator = AttributeDesignator.currentActionNamespace();
        return Match.stringEquals(value,designator);
    }

    public static Match isRead(){
        AttributeValue value = AttributeValue.string("read");
        AttributeDesignator designator = AttributeDesignator.requestedActionType();
        return Match.stringEquals(value,designator);
    }

    public static Match isResourceType(String resourceType){
        AttributeValue value = AttributeValue.string(resourceType);
        AttributeDesignator designator = AttributeDesignator.requestedResourceType();
        return Match.stringEquals(value,designator);
    }

    public static Match isClient(String clientId){
        AttributeValue value = AttributeValue.string(clientId);
        AttributeDesignator designator = AttributeDesignator.currentClientId();
        return Match.stringEquals(value,designator);
    }

    public static Match stringEquals(AttributeValue value,AttributeDesignator designator){
        return Match.builder()
                .matchId(FunctionId.STRING_EQUALS.getUrn())
                .value(value)
                .designator(designator)
                .build();
    }

}
