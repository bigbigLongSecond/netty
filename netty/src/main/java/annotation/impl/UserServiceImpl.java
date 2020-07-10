package annotation.impl;

import com.btt.annotation.SelfAutowired;
import com.btt.annotation.SelfService;

@SelfService
public class UserServiceImpl {
	@SelfAutowired
	UserService service;
	@SelfAutowired
	UpdateService  updateService;
	
	public  void add() {
		service.getInfo();
		System.out.println("使用反射机制初始化对象");
	}
	public void getna() {
		updateService.getSn();
	}

}
