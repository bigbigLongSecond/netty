package classload;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 16:43
 */
public class MyTest4 {
    public static void main(String[] args) {
        System.out.println(MyChild4.b);
    }
}

interface  MyParent4{
    int b =  new Integer(4);
}

interface  MyChild4 extends MyParent4 {
    int a = new Integer(4);
}
