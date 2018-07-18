package com.neuedu.usersys.business.service;

import java.sql.Connection;
import java.util.Date;

import com.neuedu.usersys.common.business.dao.UserDao;
import com.neuedu.usersys.common.constant.EnumType;
import com.neuedu.usersys.common.dao.DaoFactory;
import com.neuedu.usersys.common.exception.DaoException;
import com.neuedu.usersys.common.exception.ServiceException;
import com.neuedu.usersys.common.util.DBUtils;
import com.neuedu.usersys.usermgr.domain.UserVO;



public  class UserServiceImpl implements UserService {
	/**
	 * 用户实例
	 */
	private static UserService userService =new UserServiceImpl();
	/**
	 * 构造方法
	 */
	private UserServiceImpl(){
		
	}
	/**
	 * 取得用户service实例
	 * @return
	 */
	public static UserService getInstance(){
		 return userService;
	}
	
   /**
    * 用户登录
    * @param name 用户名称
    * @param password 用户密码
    * @return 用户信息
    */
	public UserVO login(String name, String password) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVO user=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
			user=userMgrDao.login(name, password);
			
		}catch(DaoException e){
			throw e;
		}catch (Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("用户登录错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}
	public boolean addUser(UserVO user){
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn=null;
				boolean a=false;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给连接对象变量
					conn=DBUtils.getConnection();
					//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
					UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
					//调用数据库工具类的beginTransaction方法，开启事务
					DBUtils.beginTransaction(conn);
					//调用dao中的addUser方法，进行登录操作，结果赋值给登录结果变量
					userMgrDao.addUser(user);
					//调用工具类的commit方法，提交事务
					DBUtils.commit(conn);
					a=true;
				}catch(DaoException e){
					throw e;
				}catch (Exception e){
					DBUtils.rollback(conn);
					throw new ServiceException("用户注册失败",e);
				}finally{
					DBUtils.closeConnection(conn);
				}
				//返回用户登录结果
				return a;
			}
	}
