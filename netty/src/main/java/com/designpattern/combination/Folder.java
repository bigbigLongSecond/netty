package com.designpattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/10/22 11:08
 * @Description
 */
public class Folder extends File {
    private List<File> files = new ArrayList<>();

    public Folder(String fileName) {
        super(fileName);
    }
    public void addFiles(File file){
        files.add(file);
    }

    @Override
    public void display() {
        System.out.println(getFileName() );
        files.forEach(info->{
            info.display();
        });

    }
}
