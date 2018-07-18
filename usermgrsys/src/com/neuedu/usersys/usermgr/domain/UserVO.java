package com.neuedu.usersys.usermgr.domain;

import java.util.Date;
/**
 * 用户信息类
 * @author hasee
 *
 */
public class UserVO {
private int id;//主键
private String name;//用户名
private String pass;//密码
private String mail;//邮箱
private String power;//权限
private Date birth;//出生日期
private String userId;//用户编号
private String Status;
/**
 * 获取id
 * @return
 */
public int getId() {
	return id;
}
/**
 * 存储id
 * @param id
 */
public void setId(int id) {
	this.id = id;
}
/**
 * 获取name
 * @return
 */
public String getName() {
	return name;
}
/**
 * 存储name
 * @param name
 */
public void setName(String name) {
	this.name = name;
}
/**
 * 获取pass
 * @return
 */
public String getPass() {
	return pass;
}
/**
 * 存储pass
 * @param pass
 */
public void setPass(String pass) {
	this.pass = pass;
}
/**
 * 获取mail
 * @return
 */
public String getMail() {
	return mail;
}
/**
 * 存储mail
 * @param mail
 */
public void setMail(String mail) {
	this.mail = mail;
}
/**
 * 获取power
 * @return
 */
public String getPower() {
	return power;
}
/**
 * 存储power
 * @param power
 */
public void setPower(String power) {
	this.power = power;
}
/**
 * 获取birthday
 * @return
 */
public Date getBirth() {
	return birth;
}
/**
 * 存储birthday
 * @param birthday
 */
public void setBirth(Date birth) {
	this.birth = birth;
}
/**
 * 获取userId
 * @return
 */
public String getUserId() {
	return userId;
}
/**
 * 存储userId
 * @param birthday
 */
public void setUserId(String userId) {
	this.userId = userId;
}
/**
 * 获取status
 * @return
 */
public String getStatus() {
	return Status;
}
/**
 * 存储status
 * @param birthday
 */
public void setStatus(String status) {
	Status = status;
}

}
