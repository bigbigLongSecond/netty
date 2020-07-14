package com.designpattern.behaviorPattern;

/**
 * @author dzl
 * 2020/7/7 11:13
 * @Description
 */
public class DogCallBehavior implements CallBehavior {
    @Override
    public void call() {
        System.out.println("dog call behavior");
    }
}
