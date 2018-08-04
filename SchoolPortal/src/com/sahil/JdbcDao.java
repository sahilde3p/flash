package com.sahil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;


public class JdbcDao {
	static Connection con=null;
	static PreparedStatement pst=null;
	
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://sahildb.cswnkb4qnsg1.us-east-2.rds.amazonaws.com:3306/collegedb", "sahilde3p", "Sahil7172");
			  
			  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static boolean registerationSuccess(String userId,String pass,String firstName, String lastName,String course,String email) {
		connect();
        try {
        	
        		pst = con.prepareStatement("insert into regforum values (?,?,?,?,?,?)");
            	pst.setString(1, userId);
    			pst.setString(2, pass);
    			pst.setString(3, firstName);
    	        pst.setString(4, lastName);
    	        pst.setString(5, course);
    	        pst.setString(6, email);
    			int r = pst.executeUpdate();
    			if(r>0) {
    				return true;
    			}
    			else {
    				return false;
    			}
        	
        	
        	
        
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        finally {
			 try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
        return false;
	}
	public static boolean authenticate(String userName,String pass,HttpServletRequest req) {
		connect();
		try {
			pst = con.prepareStatement("select * from regforum where userid=? and BINARY password=?");
			pst.setString(1, userName);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Handler handle = new Handler();
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String course = rs.getString("courses");
				handle.setup(firstName, lastName, email, course,req);
				
				
				
				return true;
				
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			 try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		return false;
	}
	public static boolean checkExistingUserId(String userid) {
		connect();
		try {
			pst = con.prepareStatement("select * from regforum where userid=?");
			pst.setString(1, userid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			 try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
				
		return false;
	}
	public static boolean checkExistingEmail(String email) {
		connect();
		try {
			pst = con.prepareStatement("select * from regforum where email=?");
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			 try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
				
		return false;
	}
	public static String getUserId(String email) {
		connect();
		try {
			pst = con.prepareStatement("select userid from regforum where email = ?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}else
			{
				return "";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			 try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		return "";
	
	}
	
}
