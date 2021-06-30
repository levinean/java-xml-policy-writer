import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllOf {
    @XmlElement(name="Match")
    private List<Match> matches = new LinkedList<>();

    public static AllOf readMiddleware(){
        List<Match> matches = new LinkedList<>();
        matches.add(Match.isMiddleware());
        matches.add(Match.isRead());
        return AllOf.builder().matches(matches).build();
    }

    public static AllOf readOwnPersonResource(){
        List<Match> matches = new LinkedList<>();
        matches.add(Match.isMiddleware());
        matches.add(Match.isRead());
        matches.add(Match.isResourceType("Person"));
        return AllOf.builder().matches(matches).build();
    }

}
