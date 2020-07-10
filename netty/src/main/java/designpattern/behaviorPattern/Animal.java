package designpattern.behaviorPattern;

/**
 * @author dzl
 * 2020/7/7 11:14
 * @Description
 */
public class Animal {
    private CallBehavior callBehavior;

    public Animal(CallBehavior callBehavior) {
        this.callBehavior = callBehavior;
    }
    public void call(){
        callBehavior.call();
    }
}
