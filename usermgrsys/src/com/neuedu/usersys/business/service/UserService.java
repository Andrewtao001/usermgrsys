package com.neuedu.usersys.business.service;

import java.util.Date;

import com.neuedu.usersys.usermgr.domain.UserVO;

public interface UserService {
	/**
	 * 用户登录
	 * @param name 用户姓名	
	 * @param password 用户密码
	 * @return 用户信息
	 */
	
	public UserVO login(String name,String password);
	public boolean addUser(UserVO user);
}
