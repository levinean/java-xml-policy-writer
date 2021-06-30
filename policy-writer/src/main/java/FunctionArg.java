import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FunctionArg {

    @XmlAttribute(name="FunctionId")
    private String functionId;
}
