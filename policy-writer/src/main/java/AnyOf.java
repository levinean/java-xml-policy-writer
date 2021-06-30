import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnyOf {
    @XmlElement(name="AllOf")
    private List<AllOf> allOfs = new ArrayList<AllOf>();

}
