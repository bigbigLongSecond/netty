package com.designpattern.review.easyfactory;

/**
 * @author dzl
 * 2020/10/21 9:46
 * @Description
 */
public class StationaryFactory {
    public Stationary create(String type){
        Stationary stationary = null;
        switch (type){
            case "pencil":
                stationary = new Pencil();
                break;
            case "brush":
                stationary = new Brush();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return stationary;
    }
}
