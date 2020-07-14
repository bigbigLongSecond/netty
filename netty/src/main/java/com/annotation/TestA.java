package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Target Retention Documented Inherited
 * @author lenovo
 * Target: 表示此注解所运用的范围   ElemenetType
 * Retention： 表示在什么级别保存该注解信息     RetentionPolicy.SOURCE  注解将被编译器丢弃
 *                                         RetentionPolicy.CLASS   注解在class文件中，但会被vm丢弃
 *                                         RetentionPolicy.RUNTIME VM  将在运行期保留注释，因此可以通过反射机制读取注解的信息
 * Documented： 将此注解包含在 javadoc 中 ，它代表着此注解会被javadoc工具提取成文档。
 * Inherited： 允许子类继承父类注解
 * 
 * For example：  Override有两个注解  @Target(ElementType.METHOD)         此注解运用在普通方法上
 *                                 @Retention(RetentionPolicy.SOURCE)  在编译器时这个注解将会被丢弃
 *
 */
//   运行位置在方法上   ，  在运行时加载
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA {
	
	String  methodName();
	
	Class[] paramInfo();

}
