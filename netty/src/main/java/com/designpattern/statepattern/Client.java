package com.designpattern.statepattern;

/**
 * @author dzl
 * 2020/10/26 15:14
 * @Description  状态模式 : 当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
 * 如果一个对象有多种状态，并且每种状态下的行为不同，一般的做法是用if/else 或者switch 添加判断。但更好的做法是给每种状态创建一个
 * 状态对象，使用状态对象来替换掉这些条件判断语句。使得状态控制控制的更加灵活，扩展性也更好
 * 场景：LeetCode网站会员可以进行模拟面试，而普通用户不可以进行。
 * 1.首先需要一个用户类，用户可以点击面试，当用户是会员时可以进行面试。
 * 2.用户也可以切换会员状态。
 */
public class Client {

    public static void main(String[] args) {
        User iUser = new User();
        iUser.mockInterview();
        iUser.buy();
        iUser.mockInterview();

    }
}
