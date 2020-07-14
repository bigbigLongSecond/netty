package com.spring.first;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author dzl
 * 2020/7/14 9:15
 * @Description
 */
public class SpringClient {
    public static void main(String[] args) {
        //
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.loadBeanDefinitions(resource);
        Student student = defaultListableBeanFactory.getBean("student", Student.class);
        System.out.println(student);
    }
}
