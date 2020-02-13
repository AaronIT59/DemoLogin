package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.connect.ConnectDB;

public class DaoImpl extends ConnectDB implements DAO{

	public boolean checkLogin(String user, String pass) {
		
		try {
			Connection con = getSQLServerConnection();
			PreparedStatement pst = con.prepareStatement("select * from Member where UserName=? and Pass=?");
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
