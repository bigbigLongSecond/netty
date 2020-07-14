package com.annotation.impl;

import com.annotation.annotation.SelfService;

/**
 * @author lenovo
 */
@SelfService
public class UpdateService {

	private String  serviceName;

	public UpdateService() {
		serviceName= "serviceName --->   通过构造器初始化serviceName...";
	}
	public String getSn() {
		return serviceName;
	}
}
