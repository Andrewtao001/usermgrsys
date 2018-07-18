package com.neuedu.usersys.common.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.neuedu.usersys.common.util.DBUtils;
import com.neuedu.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		UserDaoImpl s=new UserDaoImpl(DBUtils.getConnection());
		UserVO	user=s.login("张三","123");	
		System.out.println(user.getName());
	}



}
