package classload;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 16:39
 */
public class MyTest3 {
    public static void main(String[] args) {
        MyParent1[]  array = new MyParent1[3];
        System.out.println(array.getClass());
        int[]  a = new int[3];
        System.out.println(a.getClass());

    }
}

class MyParent3{
    public static int a = 10;

    static {
        System.out.println("hello");
    }
}
