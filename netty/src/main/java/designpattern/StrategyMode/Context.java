package designpattern.StrategyMode;

/**
 * @author dzl
 * 2020/7/7 9:29
 * @Description
 */
public class Context {
    private IStrategy strategy ;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doSomething();
    }
}
