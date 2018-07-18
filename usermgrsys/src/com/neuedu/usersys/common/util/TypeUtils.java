package com.neuedu.usersys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.neuedu.usersys.common.exception.DateException;


public class TypeUtils {
	/**
	 * 字符串转换为日期
	 * @param str 指定的字符串
	 * @return 转换后的日期
	 */
public static Date strToDate(String str){
	Date date=null;
	//设置要格式化的日期格式
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期类型
			date=  (Date) sdf.parse(str);
		} catch (ParseException e) {
		
//			System.out.println("字符串转化为日期错误");
//			e.printStackTrace();
	throw new DateException("字符串转化为日期错误",e);
	}
		//返回转换后的值
	 return date;
}
/**
 * 日期转换成字符串
 * @param date
 * @return
 */
public static String dateToStr(Date date){
	String str=null;
	//设置要格式化的日期格式
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将日期解析成指定格式的字符串类型
			str=  sdf.format(date);
		} catch (Exception e) {
		
//			System.out.println("日期转化为字符串错误");
//			e.printStackTrace();
			throw new DateException("日期转化为字符串错误",e);
	}
		//返回转换后的值
	 return str;
}
/**
 * 验证邮箱格式
 * @param string
 * @return 格式正确返回true否则返回false
 */
public static boolean checkEmail(String string) {
    if (string == null)
        return false;
    String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    Pattern p;
    Matcher m;
    p = Pattern.compile(regEx1);
    m = p.matcher(string);
    if (m.matches())
        return true;
    else
        return false;
}

}
