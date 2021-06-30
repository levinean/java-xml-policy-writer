import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlValue;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyIdReference {
    @XmlValue
    private String reference;
}
