package designpattern.singleton;

/**
 * @author dzl
 * 2020/7/1 9:46
 * @Description  懒汉式单例模式
 */
public class SingleTonLazy {
    private static SingleTonLazy singleTon;

    private SingleTonLazy() {
    }
    public static SingleTonLazy getInstance(){
        if (singleTon == null){
            singleTon = new SingleTonLazy();
        }
        return singleTon;
    }
}
