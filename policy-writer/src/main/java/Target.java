import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Target {

    @XmlElement(name="AnyOf")
    private AnyOf anyOf;

    public static Target readMiddleware(){
        List<AllOf> allOfs = Collections.singletonList(AllOf.readMiddleware());
        return buildTargetFromListOfAllOfs((allOfs));
    }

    public static Target isClient(String clientId){
        List<Match> matches = Collections.singletonList(Match.isClient(clientId));
        return buildTargetFromListOfMatches(matches);
    }

    public static Target readOwnPersonResource(){
        List<AllOf> allOfs = Collections.singletonList(AllOf.readOwnPersonResource());
        return buildTargetFromListOfAllOfs((allOfs));
    }

    private static Target buildTargetFromListOfMatches(List<Match> matches){
        List<AllOf> allOfs = Collections.singletonList(AllOf.builder().matches(matches).build());
        return buildTargetFromListOfAllOfs((allOfs));
    }

    private static Target buildTargetFromListOfAllOfs(List<AllOf> allOfs){
        AnyOf anyOf = AnyOf.builder().allOfs(allOfs).build();
        return Target.builder().anyOf(anyOf).build();
    }

}
