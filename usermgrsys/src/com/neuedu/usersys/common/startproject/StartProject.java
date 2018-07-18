package com.neuedu.usersys.common.startproject;

import com.neuedu.usersys.common.view.IndexFrame;

public class StartProject {
    public static void main(String[ ] args){
    	//实例化用户登录和注册的操作界面类
    	IndexFrame frame=new IndexFrame();
    	//调用loginFrame方法，显示用户登录和注册的操作界面
    	frame.show();
    }
}
