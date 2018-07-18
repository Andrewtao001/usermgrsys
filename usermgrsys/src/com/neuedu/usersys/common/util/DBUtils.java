package com.neuedu.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.usersys.common.exception.DaoException;
/**
 * 工具类
 * @author hasee
 *
 */
public class DBUtils {

	
	/**
	 * 创建连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//注册驱动程序
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "scott";
			String password = "123123";
			//获取数据库连接
			conn = DriverManager.getConnection(url, user, password);			
		} catch (ClassNotFoundException e) {
			//System.out.println("数据库jar包加载失败...");
			//e.printStackTrace();
			throw new DaoException("数据库jar包加载失败...",e);
		} catch (SQLException e) {
//			System.out.println("数据库连接获取失败...");
//			e.printStackTrace();
			throw new DaoException("数据库连接获取失败...",e);
		}
		System.out.println("数据库连接获取成功...");
		//返回的连接对象
		return conn;
	}
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		try{
			//将事务自动提交设为假
			conn.setAutoCommit (false);
		}catch(SQLException e){
			//将异常封装成自定义异常
//			System.out.println("事务开启失败");
//			e.printStackTrace();
			throw new DaoException("事务开启失败",e);
		}
	}
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commit(Connection conn){
		try{
			//提交事务
			conn.commit();
			//将事务的自动提交设置.setAutoCommit为真
			conn.setAutoCommit(true);
		}catch(SQLException e){
			//将异常封装成自定义异常
//			System.out.println("事务提交失败");
//			e.printStackTrace();
			throw new DaoException("事务提交失败",e);
		}
	}
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try{
			//回滚事务
			conn.rollback();
			//将事务的自动提交设为真
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			//将异常封装成自定义异常
//			System.out.println("事务回滚失败");
//			e.printStackTrace();
			throw new DaoException("事务回滚失败",e);
		}
	}
	/**
	 * 关闭PreparedStatement
	 * @param prep
	 * @param rs
	 */
	public static void closePrepardStatement(PreparedStatement prep,ResultSet rs){
		try{
			if(prep != null){
		        prep.close();
		        prep = null;
		}
			if(rs != null){ //注意一下rs与conn的次序,先开后关
		        rs.close();
		        rs = null;
			}} catch (SQLException e) {
//			System.out.println("关闭数据库连接,语句及结果集时出现错误！");
//			e.printStackTrace();
			throw new DaoException("关闭数据库连接,语句及结果集时出现错误！",e);
		}
	}
	/**
	 * 关闭Statement
	 * @param stat
	 * @param rs
	 */
	public static void closeStatement(Statement stat,ResultSet rs){
		try{
			if(stat != null){
		        stat.close();
		        stat = null;
		}
			if(rs != null){ //注意一下rs与conn的次序,先开后关
		        rs.close();
		        rs = null;
			}} catch (SQLException e) {
//			System.out.println("关闭数据库连接,语句及结果集时出现错误！");
//			e.printStackTrace();
			throw new DaoException("现关闭数据库连接,语句及结果集时出现错误！",e);
		}
	}
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
		        conn.close();
		        conn = null;
			}
		} catch (SQLException e) {
//			System.out.println("关闭数据库连接,语句及结果集时出现错误！");
//			e.printStackTrace();
			throw new DaoException("关闭数据库连接,语句及结果集时出现错误！",e);
		}
		
	}
}
