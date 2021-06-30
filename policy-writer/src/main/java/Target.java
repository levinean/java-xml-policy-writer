import com.sun.xml.bind.v2.schemagen.xmlschema.Any;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Target {

    @XmlElement(name="AnyOf")
    private AnyOf anyOf;

    public static Target readMiddleware(){
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(AllOf.readMiddleware());
        AnyOf anyOf = AnyOf.builder().allOfs(allOfs).build();
        return Target.builder().anyOf(anyOf).build();
    }

    public static Target isClient(String clientId){
        List<Match> matches = new LinkedList<Match>();
        matches.add(Match.isClient(clientId));
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(new AllOf(matches));
        AnyOf anyOf = new AnyOf(allOfs);
        return Target.builder().anyOf(anyOf).build();
    }

    public static Target readOwnPersonResource(){
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(AllOf.readOwnPersonResource());
        AnyOf anyOf = AnyOf.builder().allOfs(allOfs).build();
        return Target.builder().anyOf(anyOf).build();
    }

}
