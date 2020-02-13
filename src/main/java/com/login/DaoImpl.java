package com.login;

public class DaoImpl implements DAO{

	public boolean checkLogin(String user, String pass) {
		if(user.equals("aaa")&&pass.equals("123")) return true;
		else return false;
	}
	
}
