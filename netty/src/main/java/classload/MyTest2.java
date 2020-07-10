package classload;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 16:35
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyChild2.b);
    }
}

class MyParent2 {
    public static int a = 10;

    static {
        System.out.println("MyParent static block");
    }
}

class MyChild2 extends MyParent2 {
    public static final int b = new Integer(4);

    static {
        System.out.println("MyChild1 static block");
    }
}