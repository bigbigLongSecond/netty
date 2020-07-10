package designpattern.StrategyMode;

/**
 * @author dzl
 * 2020/7/7 9:28
 * @Description
 */
public class Strategy2 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("strategy2  正在运行");
    }
}
