import javax.xml.bind.annotation.XmlElement;
import java.util.*;

public class AnyOf {
    @XmlElement(name="AllOf")
    private List<AllOf> allOfs = new ArrayList<AllOf>();

    public AnyOf(List<AllOf> allOfs){
        this.allOfs = allOfs;
    }

    public void addAllOf(AllOf allOf){
        this.allOfs.add(allOf);
    }

    public void addAllOfs(List<AllOf> allOfs){
        this.allOfs.addAll(allOfs);
    }

    public List<AllOf> getAllOfs() {
        return this.allOfs;
    }
}
