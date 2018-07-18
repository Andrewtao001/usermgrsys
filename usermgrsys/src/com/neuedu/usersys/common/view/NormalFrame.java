package com.neuedu.usersys.common.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.neuedu.usersys.usermgr.domain.UserVO;

public class NormalFrame extends IndexFrame {
//用户对象
	UserVO user=null;
	/**
	 * 用于用户管理：权限分为普通权限和管理员
	 * @param user
	 */

	public NormalFrame(UserVO user) {
               this.user=user;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 普通员工登录成功
	 */
	public void show(){
		// 声明缓冲处理流对象，用于接受控制台输入的数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			//显示普通用户登录成功后的界面
			System.out.println("1.修改自己的信息");
			System.out.println("2.查询自己的信息");
			System.out.println("3.程序退出");
			//声明变量，用于接收从控制台输入的操作选项数字
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
			 * 判断用户输入值，1进行修改自己操作，2进行查询自己操作，3退出系统
			 */
			switch(i){
			case 1:
				 
				 break;
			case 2:
				
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

}
