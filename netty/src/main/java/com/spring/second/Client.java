package com.spring.second;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author dzl
 * 2020/11/18 9:20
 * @Description
 * AOP 面向切面编程
 * 横切关注点：对哪个方法进行拦截，拦截后怎么处理，这些关注点称为横切关注点
 * Aspect（切面）：通常是一个类，里面可以定义切入点和通知
 * JointPoint（连接点）：程序执行过程中明确的点，一般是方法的调用，被拦截到的点，因为Spring只支持方法类型的连接点
 *                     所以在spring指的就是被拦截到的方法。
 *Advise（通知）：AOP在特定连接点上执行的增强。
 * pointCut（切入点）：带有通知的切入点
 * weave（织入）：将切面应用到目标对象并导致代理对象创建的过程
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld proxy1 = (HelloWorld) applicationContext.getBean("proxy");
        proxy1.doPrint();
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        HelloWorld proxy = (HelloWorld) beanFactory.getBean("proxy");
        proxy.doPrint();
    }
}
