package com.neuedu.usersys.common.view;

import com.neuedu.usersys.usermgr.domain.UserVO;
/**
 * 公有页面显示接口
 * @author hasee
 *
 */
public interface BaseFrame {

	/**
	 * 页面显示
	 */
	public void show();
     /**
      * 添加用户页面显示
      * @param type
      */
	
	public void addShow(String type);
	/**
	 * 查询
	 */
	public void searchShow();
	/**
	 * 修改
	 * @param type
	 * @param user
	 */
	public void updateShow(String type,UserVO user);
}
