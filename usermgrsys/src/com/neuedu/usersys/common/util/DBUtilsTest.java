package com.neuedu.usersys.common.util;


import java.sql.Connection;

import org.junit.Test;

public class DBUtilsTest {

	@Test
	public void testGetConnection() {
		Connection connection=DBUtils.getConnection();
		System.out.print(connection);
	}

}
