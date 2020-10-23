package com.designpattern.combination;

/**
 * @author dzl
 * 2020/10/22 11:06
 * @Description
 */
public abstract class File {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public abstract void display();
}
