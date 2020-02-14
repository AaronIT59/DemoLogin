package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection open(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:49685;databaseName=demologin";
            String user = "sa";
            String pass="1234$";
            
            con = DriverManager.getConnection(url, user, pass);
        }catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
        return con;
    }
    
    
    public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs){
        if(con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(pstmt!=null)
            try {
                pstmt.close();
        } catch (SQLException ex) {
        	 ex.printStackTrace();
        }
        if(rs!=null)
            try {
                rs.close();
        } catch (SQLException ex) {
        	 ex.printStackTrace();
        }
    }
			
}
