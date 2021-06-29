import com.sun.xml.bind.v2.schemagen.xmlschema.Any;

import javax.xml.bind.annotation.XmlElement;

public class Target {

    @XmlElement(name="AnyOf")
    private AnyOf anyOf;

    public Target(AnyOf anyOf){
        this.anyOf = anyOf;
    }

    public AnyOf getAnyOf(){
        return this.anyOf;
    }

    public void setAnyOf(AnyOf anyOf){
        this.anyOf = anyOf;
    }
}
