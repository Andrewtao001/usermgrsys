package com.neuedu.usersys.common.exception;
/**
 * DateException异常类
 * @author hasee
 *
 */
@SuppressWarnings("serial")
public class DateException extends ServiceException {
	/**
	 * 默认构造方法
	 */
	public DateException(){
		
	}
	/**
	 * 构造方法
	 * @param arg0 异常详细信息
	 */
	public DateException(String arg0){
		super(arg0);
	}
	/**
	 * 构造方法
	 * @param arg0 异常产生的原因
	 */
	public DateException(Throwable arg0){
		super(arg0);
	}
	/**
	 * 构造方法
	 * @param arg0 异常详细信息
	 * @param arg1 异常产生的原因
	 */
	public DateException(String arg0,Throwable arg1){
		super(arg0,arg1);
	}

}
