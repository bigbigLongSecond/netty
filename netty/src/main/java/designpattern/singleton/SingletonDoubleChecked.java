package designpattern.singleton;

/**
 * @author dzl
 * 2020/7/1 9:51
 * @Description
 */
public class SingletonDoubleChecked {
    private static SingletonDoubleChecked singleTon = new SingletonDoubleChecked();

    private SingletonDoubleChecked() {
    }
    public static SingletonDoubleChecked getInstance(){
        if (singleTon == null){
            synchronized (SingletonDoubleChecked.class){
                singleTon = new SingletonDoubleChecked();
            }
        }
        return  singleTon;
    }
}
