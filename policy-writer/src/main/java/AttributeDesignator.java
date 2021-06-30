import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeDesignator {

    @XmlAttribute(name="AttributeId")
    private String attributeId;

    @XmlAttribute(name="Category")
    private String category;

    @XmlAttribute(name="DataType")
    private String dataType;

    @XmlAttribute(name="MustBePresent")
    private String mustBePresent = "false";

    public static AttributeDesignator requestedResourceType(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.FHIR_RESOURCE_TYPE.getUrn())
                .category(AttributeCategory.RESOURCE.getUrn())
                .dataType(DataType.STRING.getUrn())
                .build();
    }

    public static AttributeDesignator currentSubjectId(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.SUBJECT_ID.getUrn())
                .category(AttributeCategory.SUBJECT.getUrn())
                .dataType(DataType.STRING.getUrn())
                .build();
    }

    public static AttributeDesignator currentActionNamespace(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.ACTION_NAMESPACE.getUrn())
                .category(AttributeCategory.ACTION.getUrn())
                .dataType(DataType.STRING.getUrn())
                .build();
    }

    public static AttributeDesignator requestedActionType(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.ACTION_ID.getUrn())
                .category(AttributeCategory.ACTION.getUrn())
                .dataType(DataType.STRING.getUrn())
                .build();

    }

    public static AttributeDesignator currentClientId(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.CLIENT_ID.getUrn())
                .category(AttributeCategory.OAUTH_CLIENT.getUrn())
                .dataType(DataType.STRING.getUrn())
                .build();

    }

}
