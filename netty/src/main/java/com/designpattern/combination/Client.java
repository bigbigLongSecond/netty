package com.designpattern.combination;

/**
 * @author dzl
 * 2020/10/22 10:31
 * @Description  组合模式----> 组合：像人的思想和身体一样，对人来说，这两个是缺一不可的。
 * 组合模式用于整体与部分的结构，当整体与部分有相似的结构，在操作时可以被一致对待时，就可以用组合模式。
 *
 * sample：文件夹和子文件夹的关系：文件夹中可以存放文件，也可以新建文件夹，子文件夹也一样
 *
 *
 */
public class Client {
    public static void main(String[] args) {
        TextField textField1 = new TextField("      天龙八部1");
        TextField textField2 = new TextField("      天龙八部2");
        TextField textField3 = new TextField("      天龙八部3");
        TextField textField4 = new TextField("      天龙八部4");
        Folder folder1 = new Folder("   天龙八部");
        folder1.addFiles(textField1);
        folder1.addFiles(textField2);
        folder1.addFiles(textField3);
        folder1.addFiles(textField4);

        TextField textField5 = new TextField("      红楼梦1");
        TextField textField6 = new TextField("      红楼梦2");
        TextField textField7 = new TextField("      红楼梦3");
        TextField textField8 = new TextField("      红楼梦4");
        Folder folder2 = new Folder("   红楼梦");
        folder2.addFiles(textField5);
        folder2.addFiles(textField6);
        folder2.addFiles(textField7);
        folder2.addFiles(textField8);
        Folder folder = new Folder("文学作品");
        folder.addFiles(folder1);
        folder.addFiles(folder2);
        folder.display();


    }
}
