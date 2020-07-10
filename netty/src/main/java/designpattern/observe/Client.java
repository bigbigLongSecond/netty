package designpattern.observe;

import java.util.Observer;

/**
 * @author dzl
 * 2020/7/3 14:09
 * @Description
 */
public class Client {
    public static void main(String[] args){
        Subject sub = new ConcreteSubject();
        sub.addObserver(new ConcreteObserver1()); //添加观察者1
        sub.addObserver(new ConcreteObserver2()); //添加观察者2
        sub.doSomething();
    }
}
