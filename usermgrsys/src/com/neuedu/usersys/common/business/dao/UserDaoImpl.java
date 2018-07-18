package com.neuedu.usersys.common.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.neuedu.usersys.common.exception.DaoException;
import com.neuedu.usersys.common.util.DBUtils;
import com.neuedu.usersys.usermgr.domain.UserVO;

public class UserDaoImpl implements UserDao{
	/**
	 * 数据库连接
	 */
   private Connection conn;
   /**
    * 构造方法
    * @param conn 数据库连接
    */
   public UserDaoImpl(Connection conn){
	   this.conn=conn;
   }
   /**
    * 用户登录
    */
   public UserVO login(String name,String password){
	   //声明结果集对象变量，用于保存数据库查询结果集
	   ResultSet rs=null;
	   //声明预编译的声明对象变量,用于进行数据库操作的载体；
	   PreparedStatement pstam=null;
	   //声明用户对象变量，用于保存从结果集中取得的数据；
	   UserVO user=null;
	   try{
		   //调用连接对象的prepareStatement方法，得到编译对象，赋值给编译对象
		   pstam=conn.prepareStatement("select * from t_user where NAME=? and PASS=? and STATUS=0");
		  //调用预编译对象的setxxx方法给？赋值
		   pstam.setString(1, name);
		   pstam.setString(2,password);
		   //调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		   rs=pstam.executeQuery();
		  //如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象中各个属性
		   if(rs.next()){
			   //创建一个新用户对象，赋值给用户对象变量
			   user =new UserVO();
			   /**
			    * 调用结果集对象的getxxx方法，取出各个字段的值
			    * 然后在调用用户对象的setxxx方法，给属性赋值
			    * 最后新创建的对象中包含了查询结果的所有字段
			    */
			   user.setId(rs.getInt("id"));
			   user.setUserId(rs.getString("userid"));
			   user.setName(rs.getString("name"));
			   user.setPass(rs.getString("pass"));
			   user.setMail(rs.getString("mail"));
			   user.setPower(rs.getString("power"));
			   user.setBirth(rs.getDate("birth"));
		   }
	   }catch(SQLException e){
		   System.out.println("在插入用户时候出错了错误信息是："+e.getMessage());
		//   throw new DaoException("登录时查询数据出错",e);
	   }finally{
		  
		   DBUtils.closePrepardStatement(pstam, rs);
	   }
	   return user;
   }
   /**
    * 注册
    */
   public boolean addUser(UserVO user){
	   //声明结果集对象变量，用于保存数据库查询结果集
	   ResultSet rs=null;
	   //声明预编译的声明对象变量,用于进行数据库操作的载体；
	   PreparedStatement pstam=null;
	   //声明用户对象变量，用于保存从结果集中取得的数据；
	   DBUtils s=new DBUtils();
	   boolean a=false;
	 //设置事务属性  
	   try{
		   //调用连接对象的prepareStatement方法，得到编译对象，赋值给编译对象
		   pstam=conn.prepareStatement("insert into t_user(ID,USERID,NAME,PASS,MAIL,POWER,BIRTH,STATUS) values( t_id.nextval,?,?,?,?,?,?,?)");
		  //调用预编译对象的setxxx方法给？赋值
		   pstam.setString(1,user.getUserId());
		   pstam.setString(2,user.getName());
		   pstam.setString(3,user.getPass());
		   pstam.setString(4,user.getMail());
		   pstam.setString(5,"用户");
		 //进行数据库SQL操作的时候要将原本存储格式为java.util.Date的时间
			//转换为java.sql.Date格式的时间才可以进行数据库的操作
		   pstam.setDate(6,new java.sql.Date(user.getBirth().getTime()));
		   pstam.setString(7,"0");
		   a=true;
		   //调用预编译对象的executeUpdate方法，执行更新操作
		   pstam.executeUpdate();  
	   }catch(SQLException e){
		   System.out.println("在插入用户时候出错了错误信息是："+e.getMessage());
		//   throw new DaoException("登录时查询数据出错",e);
	   }finally{
		  
		   DBUtils.closePrepardStatement(pstam, rs);
				
		   
	   }
	   return a;
   }
}
