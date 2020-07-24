package com.spring.first;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author dzl
 * 2020/7/14 9:15
 * @Description   DefaultListableBeanFactory   IOC容器之祖    beanfactory  IOC太上皇
 * 什么是bean？
 * 在Spring中，构成应用程序主干并由Spring IOC容器管理的对象称为bean。bean是由Spring IOC 容器实例化、组装和管理的对象
 * 1.bean在Java中是一个对象
 * 2.bean的生命周期由IOC管理
 * ---> 意味着一个java对象我们不需要过多的去关注它的创建和销毁，而是只要会用这个组件就可以了。bean的维护工作交给了IOC去做。
 *
 * 1.编写xml文件
 * 2.resource将xml配置文件实例化一个对象
 * 3.创建一个BeanFactory工厂   DefaultListableBeanFactory
 * 4.创建一个reader读取器，关联刚刚创建的BeanFactory工厂
 * 5.read读取Resource对象。
 * 6.将读取到的对象转化为一个document
 * 7.将读取到的对象委托给BeanDefinitionParserDelegate进行解析
 * 8.BeanDefinitionParserDelegate 将document对象的元素解析
 * 9.解析好的对象封装成一个AbstractBeanDefinition,并将其权限给BeanDefinitionHolder（beanName+BeanDefinition）
 * 10.将其放入集合中
 * 11.观察者监听该实例
 * 整个过程的一些难点:
 *        1.xml文件对应成resource
 *        2.解析Resource文件，将里边的各个元素都对应成各个具体的类型
 *        3.整个定义的封装
 * 假设让我去写一个xml对应解析类？
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class SpringClient {
    public static void main(String[] args) {
        //
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 1.依赖注入的父接口  2.提供bean的创建、属性注值 绑定 和 初始化  3.枚举所有的实例  4.序列化
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.loadBeanDefinitions(resource);
        Student student = defaultListableBeanFactory.getBean("student", Student.class);
        System.out.println(student);
    }
}
