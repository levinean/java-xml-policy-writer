import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeDesignator {

    @XmlAttribute(name="AttributeId")
    private AttributeId attributeId;

    @XmlAttribute(name="Category")
    private AttributeCategory category;

    @XmlAttribute(name="DataType")
    private DataType dataType;

    @XmlAttribute(name="MustBePresent")
    @Builder.Default
    private String mustBePresent = "false";

    public static AttributeDesignator requestedResourceType(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.FHIR_RESOURCE_TYPE)
                .category(AttributeCategory.RESOURCE)
                .dataType(DataType.STRING)
                .build();
    }

    public static AttributeDesignator currentSubjectId(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.SUBJECT_ID)
                .category(AttributeCategory.SUBJECT)
                .dataType(DataType.STRING)
                .build();
    }

    public static AttributeDesignator currentActionNamespace(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.ACTION_NAMESPACE)
                .category(AttributeCategory.ACTION)
                .dataType(DataType.STRING)
                .build();
    }

    public static AttributeDesignator requestedActionType(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.ACTION_ID)
                .category(AttributeCategory.ACTION)
                .dataType(DataType.STRING)
                .build();

    }

    public static AttributeDesignator currentClientId(){
        return AttributeDesignator.builder()
                .attributeId(AttributeId.CLIENT_ID)
                .category(AttributeCategory.OAUTH_CLIENT)
                .dataType(DataType.STRING)
                .build();

    }

}
