package test;

/**
 * @author dzl
 * 2020/7/9 10:06
 * @Description
 */
public class CloneTest implements Cloneable {
    public String  name ;

    public CloneTest(String name) {
        this.name = name;
    }


    @Override
    protected CloneTest clone()  {
        CloneTest clone = null;
        try {
            clone = (CloneTest) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
