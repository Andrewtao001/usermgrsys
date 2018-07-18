package com.neuedu.usersys.common.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import com.neuedu.usersys.common.control.UserController;
import com.neuedu.usersys.usermgr.domain.UserVO;
import com.neuedu.usersys.common.util.TypeUtils;
public class IndexFrame implements BaseFrame {

	@Override
	public void show() {
		// 声明缓冲处理流对象，用于接受控制台输入的数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	//循环操作
		while(true){
			//用户登录和注册界面
			System.out.println("欢迎使用用户管理系统");
			System.out.println("=============");
			System.out.println("1.用户登录");
			System.out.println("2.用户注册");
			System.out.println("3.退出程序");
			int i=-1;
			//读取用户控制台输入，如果输入值正确，中断循环否则提示错误信息，再重新输入
			while(true){
				try{
					//读取用户输入操作选项的数字，并转化为int型
					i=Integer.parseInt(br.readLine());
					break;
				}catch(Exception e){
					System.out.println("输入错误，只能输入1-3的数字");
					System.out.println("请您重新输入");
				}
			}
			/**
			 * 判断用户输入值，1进行用户登录操作，2进行用户注册操作，3退出系统
			 */
			switch(i){
			case 1:
				 this.loginShow();
				 break;
			case 2:
				this.addUserShow();
				break;
			case 3:
				System.out.println("感谢使用");
				//退出当前界面
				System.exit(0);
				default:
					System.out.println("您输入的操作不正确，请重新输入。");
				
			}
		}

	}
	/**
	 * 用户登录
	 */
	public void loginShow() {
		// 声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户登录界面");
		System.out.println("======================");
		System.out.println("请输入您的用户名：");
		try{
			//以行为单位，读取输入的值，赋值给对象各个属性
			String name=br.readLine();
			System.out.println("请输入您的密码");
			String password=br.readLine();
			//调用控制器中的doLogin方法，进行用户登录操作
			UserController uc=new UserController();
			UserVO user=uc.dologin(name, password);
			if(user!=null){
				System.out.println("登录成功");
				System.out.println("===============");
				//调用主页面
				AdminFrame m=new AdminFrame(user);
				m.loginSuccShow();
				//System.exit(0);
			}
			else{
				System.out.println("登录失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void addShow(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchShow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShow(String type, UserVO user) {
		// TODO Auto-generated method stub
		
	}
	public void addUserShow() {
		// 声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TypeUtils u=new TypeUtils();
		UserVO user=new UserVO();
		System.out.println("用户注册界面");
		System.out.println("======================");
		try{
			//以行为单位，读取输入的值，赋值给对象各个属性
			System.out.println("请输入您的id号");
			String userid=br.readLine();
			System.out.println("请输入您的名称");
			String name=br.readLine();
			System.out.println("请输入您的密码");
			String password=br.readLine();
			System.out.println("请输入您的邮箱");
			String mail=br.readLine();
			if(u.checkEmail(mail)==false){	
				
				System.out.println("你输入的邮箱有问题请重新输入");
				mail=br.readLine();
			}
			
			System.out.println("请输入您的出生日期");
			String birth=br.readLine();
			Date date=u.strToDate(birth);
			//调用控制器中的doaddUser方法，进行用户注册操作
			user.setUserId(userid);
               user.setName(name);
               user.setPass(password);
               user.setMail(mail);
               user.setBirth(date);
			UserController uc=new UserController();
			
		  boolean aaa=uc.doaddUser(user);
				
			if(aaa=true){
			System.out.println("注册成功");
				System.out.println("===============");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("注册失败");
			
		}

}
}

