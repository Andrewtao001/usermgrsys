package com.neuedu.usersys.common.business.dao;

import java.util.Date;
import java.util.List;

import com.neuedu.usersys.common.dao.BaseDao;
import com.neuedu.usersys.usermgr.domain.UserVO;

public interface UserDao extends BaseDao {

/**
 * 用户登录	
 * @param name 用户名称
 * @param password 用户密码
 * @return 用户信息
 */
	public UserVO login(String name,String password);
	
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return 数据是否插入成功，成功返回true，失败安徽false
	 */
	public boolean addUser(UserVO user);
	/**
	 * 根据id查找用户
	 * @param id
	 * @return 用户信息
	 */
//	public UserVO findById(int id);
//	/**
//	 * 根据用户名查找用户
//	 * @param name用户名称
//	 * @return 用户信息
//	 */
//	public List<UserVO> findByName(String name);
//	/**
//	 * 查询所有用户
//	 * @return 用户信息
//	 */
//	public List<UserVO> findAll();
//	/**
//	 * 更新用户
//	 * @param user 用户信息
//	 * @return 是否更新成功，成功返回true，失败安徽false
//	 */
//	public boolean updateUser(UserVO user);
//	/**
//	 * 删除用户
//	 * @param id 用户id
//	 * @return 是否删除成功，成功返回true，失败安徽false
//	 */
//	public boolean deleteUser(int id);
//	/**
//	 * 查询所有有效用户
//	 * @return 用户信息
//	 */
//	public List<UserVO> findAllValid();
//	/**
//	 * 查询指定页的用户信息
//	 * @param pageNo
//	 * @param pagesize
//	 * @return 用户信息
//	 */
//	public List<UserVO> findUsers(int pageNo,int pagesize);
//	/**
//	 * 获取记录数量
//	 * @return 记录数量
//	 */
//	public int getRecordCount();
}
