package thread;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/9 14:48
 */
public class Math {
    public static void main(String[] args) {
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
    }
}
