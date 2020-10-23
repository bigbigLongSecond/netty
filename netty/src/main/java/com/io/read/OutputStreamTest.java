package com.io.read;

import java.io.*;

/**
 * @author dzl
 * 2020/8/20 17:00
 * @Description
 */
public class OutputStreamTest {
    private  String filePath = "1.txt";
    public static void main(String[] args) throws IOException {
        OutputStreamTest test = new OutputStreamTest();
//        test.FileInputStream();
        test.buferInputOut();
    }

    /**
     * FileInputStream读取文件
     */
    public void  FileInputStream(){
        File file = new File(filePath);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            System.out.println(inputStream.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void BufferedReader(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            char[] bytes = new char[1024];
            int posit = 0;
            String string = null;
            while ((string = reader.readLine()) != null){
                System.out.println("readline");
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileOutputStream读取文件
     */
    public void  FileOutputStream() throws IOException {
        int number = 1;
        OutputStream outputStream = new FileOutputStream("1.txt");
        PrintStream pw = new PrintStream(outputStream);
        for (int i = 0; i < 10; i++) {
            String s = i+"number";
            pw.println(s);
            number++;
        }
        pw.close();
        outputStream.close();
    }
    /**
     * FileOutputStream读取文件
     */
    public void  fileOutputStream1() throws IOException {
        int number = 1;
        OutputStream outputStream = new FileOutputStream("1.txt");
        String s = "Hello World";
        outputStream.write(s.getBytes());
        outputStream.close();
    }
    public void FileInputOut(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream("3.txt");
            int i = 0;
            while ((i=fileInputStream.read()) != -1){
                fileOutputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 一次性读取内容
     */
    public void fileInputOut() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        fileInputStream = new FileInputStream(filePath);
        fileOutputStream = new FileOutputStream("3.txt");

        int size = fileInputStream.available();
        byte[] bytes = new byte[size];
        fileInputStream.read(bytes,0,size);
        fileOutputStream.write(bytes);
        fileInputStream.close();
        fileOutputStream.close();

    }

    public void buferInputOut() throws IOException{
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream("3.txt");
        BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        int b = 0;
        while ((b = inputStream.read()) != -1){
            outputStream.write(b);
        }
        outputStream.write("HelloWorld".getBytes());
        outputStream.close();
        inputStream.close();
    }

}
