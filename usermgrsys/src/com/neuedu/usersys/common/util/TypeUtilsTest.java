package com.neuedu.usersys.common.util;


import java.util.Date;

import org.junit.Test;
/**
 * 邮箱格式和字符串与日期互换测试类
 * @author hasee
 *
 */

public class TypeUtilsTest {

	/**
	 * 测试把字符串转换为日期
	 */
	@Test
	public void testStrToDate() {
		String k="2016-05-18";
				Date date=TypeUtils.strToDate(k);
				System.out.println(date);
	}

	/**
	 * 测试把日期转换为字符串
	 */
	@Test
	public void testDateToStr() {
		Date data= new Date();
		String f=TypeUtils.dateToStr(data);
		System.out.println(f);
	}

	/**
	 * 测试验证邮箱
	 */
	@Test
	public void testCheckEmail() {
		String aaa="1234@qq.com";
		boolean email=TypeUtils.checkEmail(aaa);
		System.out.println(email);
	}

}