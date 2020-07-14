package com.annotation.impl;

import com.annotation.annotation.SelfAutowired;
import com.annotation.annotation.SelfService;

@SelfService
public class UserServiceImpl {
	@SelfAutowired
	UserService service;
	@SelfAutowired
	UpdateService  updateService;
	@SelfAutowired
	UpdateService  updateService1;
	public  void add() {
		service.getInfo();
		System.out.println("使用反射机制初始化对象");
	}
	public void getna() {
		System.out.println(updateService.getSn());
	}

	public boolean  isEqual(){
		return updateService == updateService1;
	}

}
