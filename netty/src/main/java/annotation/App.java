package annotation;

import annotation.impl.UserServiceImpl;
import annotation.spring.ext.SelfPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) throws Exception {
		
		SelfPathXmlApplicationContext app = new SelfPathXmlApplicationContext("com.btt.service");
		UserServiceImpl userServiceImpl = (UserServiceImpl) app.getBean("userServiceImpl");
		userServiceImpl.getna();
		System.out.println("当前的bean的实例对象是: " + userServiceImpl);
	}
}
