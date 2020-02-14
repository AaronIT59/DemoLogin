package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connect.ConnectDB;

public class DaoImpl implements DAO{

	public boolean checkLogin(String user, String pass) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {	
			con = ConnectDB.open();
			pst = con.prepareStatement("select * from Member where UserName=? and Pass =?");
			pst.setString(1, user);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		
	    } catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
	    }finally {
	    	ConnectDB.closeAll(con, pst, rs);
	    }
		
		
		return false;
	}
	
}	
	
