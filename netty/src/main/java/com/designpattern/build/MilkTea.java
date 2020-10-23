package com.designpattern.build;

/**
 * @author dzl
 * 2020/10/20 15:40
 * @Description
 */
public class MilkTea {
    private String type;
    private String size;

    private MilkTea(Build build) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static class Build{
        private String type;
        private String size;


        public Build setType(String type) {
            this.type = type;
            return this;
        }

        public Build setSize(String size) {
            this.size = size;
            return this;
        }

        public MilkTea build(){
            return new MilkTea(this);
        }
    }
}
