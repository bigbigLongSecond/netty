package classload;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 17:01
 */
public class MyTest6 {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.SingleTon();
        System.out.println("count1:" + SingleTon.counter1);
        System.out.println("count2:" + SingleTon.counter2);
    }
}

class SingleTon {
    public static int counter1;
    public static int counter2 = 0;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        counter1++;
        counter2++;
    }

    public static SingleTon SingleTon(){
        return singleTon;
    }
}