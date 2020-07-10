package java8.stream;

/**
 * @author dzl
 * 2020/7/1 16:46
 * @Description
 */
public enum DataType {
    OPEN(1),
    CLOSS(2);
    public int index;

    DataType(int index) {
        this.index = index;
    }
}
