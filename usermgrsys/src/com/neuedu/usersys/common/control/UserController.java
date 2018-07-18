package com.neuedu.usersys.common.control;

import java.util.Date;

import com.neuedu.usersys.business.service.UserService;
import com.neuedu.usersys.business.service.UserServiceImpl;
import com.neuedu.usersys.usermgr.domain.UserVO;

public class UserController {
	//声明用户service接口对象，用于业务处理
UserService userMgrService=UserServiceImpl.getInstance();
/**
 * 用户登录
 * @param name 用户 名称
 * @param password 密码
 * @return 用户信息
 */
public UserVO dologin(String name,String password){
	UserVO user=null;
	try{
		//调用用户接口中的login方法，进行用户登录操作
		user=userMgrService.login(name,password);
	}catch(Exception e){
		//显示异常信息
		System.out.println("用户登录时候出错"+e.getMessage());
	}
	return user;
}
public boolean doaddUser(UserVO user){
	boolean aaa=false;
	try{
		//调用用户接口中的addUser方法，进行用户注册操作
		 aaa=userMgrService.addUser(user);
		
	}catch(Exception e){
		//显示异常信息
		System.out.println("用户注册时候出错:"+e.getMessage());
	}
return aaa;
}
}
