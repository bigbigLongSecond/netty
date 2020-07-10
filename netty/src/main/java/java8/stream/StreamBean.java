package java8.stream;

/**
 * @author dzl
 * 2020/7/1 16:48
 * @Description
 */

public class StreamBean {
    private DataType dataType;
    private String name;
    private int age;
    private int id;
    private boolean ss;

    public StreamBean(DataType dataType, String name, int age, int id, boolean ss) {
        this.dataType = dataType;
        this.name = name;
        this.age = age;
        this.id = id;
        this.ss = ss;
    }

    public boolean isSs() {
        return ss;
    }

    public void setSs(boolean ss) {
        this.ss = ss;
    }

    public StreamBean() {
    }

    public StreamBean(DataType dataType, String name, int age, int id) {
        this.dataType = dataType;
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StreamBean{" +
                "dataType=" + dataType +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
