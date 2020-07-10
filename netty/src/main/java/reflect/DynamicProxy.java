package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dzl
 * 2020/6/1 13:12
 * @Description
 */
public class DynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler = (clazz , method ,strings)->{
            System.out.println(method);
            if (method.getName().equals("morning")){
                System.out.println("good morning  " + strings[0]);
            }
            return null;
        };

        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader() ,new Class[]{Hello.class} , handler);
        hello.morning("yellow");
    }
}
