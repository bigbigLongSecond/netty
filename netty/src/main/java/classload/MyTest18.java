package classload;

/**
 * Created by [张渊]
 * 2020/3/21 10:49
 */
public class MyTest18 {
    public static void main(String[] args) {
        // bootstrap
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
