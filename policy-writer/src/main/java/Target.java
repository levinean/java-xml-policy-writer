import com.sun.xml.bind.v2.schemagen.xmlschema.Any;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

public class Target {

    @XmlElement(name="AnyOf")
    private AnyOf anyOf;

    public Target(AnyOf anyOf){
        this.anyOf = anyOf;
    }

    public static Target readMiddleware(){
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(AllOf.readMiddleware());
        AnyOf anyOf = new AnyOf(allOfs);
        return new Target(anyOf);
    }

    public static Target isClient(String clientId){
        List<Match> matches = new LinkedList<Match>();
        matches.add(Match.isClient(clientId));
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(new AllOf(matches));
        AnyOf anyOf = new AnyOf(allOfs);
        return new Target(anyOf);
    }

    public static Target readOwnPersonResource(){
        List<AllOf> allOfs = new LinkedList<AllOf>();
        allOfs.add(AllOf.readOwnPersonResource());
        AnyOf anyOf = new AnyOf(allOfs);
        return new Target(anyOf);
    }

}
