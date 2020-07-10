package designpattern.behaviorPattern;

/**
 * @author dzl
 * 2020/7/7 11:13
 * @Description
 */
public class CatCallBehavior implements CallBehavior {
    @Override
    public void call() {
        System.out.println("cat call behavior");
    }
}
