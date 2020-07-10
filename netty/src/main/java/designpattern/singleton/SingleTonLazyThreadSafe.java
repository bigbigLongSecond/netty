package designpattern.singleton;

/**
 * @author dzl
 * 2020/7/1 9:46
 * @Description  懒汉式单例模式
 */
public class SingleTonLazyThreadSafe {
    private static SingleTonLazyThreadSafe singleTon;

    private SingleTonLazyThreadSafe() {
    }
    public static synchronized SingleTonLazyThreadSafe getInstance(){
        if (singleTon == null){
            singleTon = new SingleTonLazyThreadSafe();
        }
        return singleTon;
    }
}
