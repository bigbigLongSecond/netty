package designpattern.singleton;

/**
 * @author dzl
 * 2020/7/1 9:53
 * @Description
 */
public class Singleton {
    private static class SingletonHold{
        private static Singleton singleton = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHold.singleton;
    }

}
