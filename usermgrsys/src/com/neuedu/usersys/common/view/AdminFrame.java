package com.neuedu.usersys.common.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.neuedu.usersys.usermgr.domain.UserVO;

public class AdminFrame extends NormalFrame {
  
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user
	 */
	
	public AdminFrame(UserVO user){
		super(user);
	}
	/**
	 * 登录权限判断
	 */
	public void loginSuccShow(){
		System.out.println("欢迎登录主窗体");
		System.out.println(user.getName()+"您好"+"您的权限是："+user.getPower());
		System.out.println("========================");
		//管理员权限
		if(user.getPower().equals("管理员")){
			this.show();
		}else {
			new NormalFrame(user).show();
		}
	}
	/**
	 * 更利于登录成功
	 */
	public void show(){
	//声明缓冲流的对象，用于接收控制台输入的数据、
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	while(true){
		//显示登录后的操作
		System.out.println("1.添加用户");
		System.out.println("2.删除用户");
		System.out.println("3.修改用户");
		System.out.println("4.查询用户");
		System.out.println("5.程序退出");
		int i=-1;
		//循环操作
					while(true){
						try{
							//读取用户输入操作选项的数字，并转化为int型
							i=Integer.parseInt(br.readLine());
							break;
						}catch(Exception e){
							System.out.println("输入错误，只能输入1-5的数字");
							System.out.println("请您重新输入");
						}
					}
					/**
					 * 判断用户输入值，1进行用户登录操作，2进行用户注册操作，3退出系统
					 */
					switch(i){
					case 1:
						 
						 break;
					case 2:
					
						break;
					case 3:
						break;
					case 4:
				break;
					case 5:
						System.out.println("程序退出成功");
						//退出当前界面
						System.exit(0);
						default:
							System.out.println("您输入的操作不正确，请重新输入。");
						
					}
				}
	}
	
}