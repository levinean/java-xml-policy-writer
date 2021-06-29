import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllOf {
    @XmlElement(name="Match")
    private List<Match> matches = new LinkedList<>();

    public AllOf(List<Match> matches){
        this.matches = matches;
    }

    public static AllOf readMiddleware(){
        List<Match> matches = new LinkedList<>();
        matches.add(Match.isMiddleware());
        matches.add(Match.isRead());
        return new AllOf(matches);
    }

    public static AllOf readOwnPersonResource(){
        List<Match> matches = new LinkedList<>();
        matches.add(Match.isMiddleware());
        matches.add(Match.isRead());
        matches.add(Match.isResourceType("Person"));
        return new AllOf(matches);
    }

}
