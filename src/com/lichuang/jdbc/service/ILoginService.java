package com.lichuang.jdbc.service;

import com.lichuang.jdbc.bean.Manager;

/**
 * 1.登录
 * 2.注册
 * 3.修改密码
 *
 */
public interface ILoginService {
	
	public int login(String username,String password);
	
	public int regist(Manager manager);
	
	public int updatePassword(String username,String password,String repassword);
	
	

}
