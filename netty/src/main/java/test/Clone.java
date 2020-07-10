package test;

/**
 * @author dzl
 * 2020/7/9 10:08
 * @Description   1.创建类模式   2.结构类   3.行为类
 *
 */
public class Clone {
    public static void main(String[] args) {
        CloneTest test = new CloneTest("hell");
        CloneTest clone = test.clone();
        System.out.println(clone.name);
    }
}
