package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class AuthDAO {
	
public boolean login(String user_name, String user_password) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
		String sql = "select * from users where username = ? and password = ?;";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user_name);
		ps.setString(2, user_password);
		
		ResultSet rs = ps.executeQuery();
		
		//if anything gets returned at all, we know a user exists with that username/password pair. so we can return true
		if(rs.next()) {
			
			return true;
		}
			
		} catch (SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
		}
		
		return false;
		
	}

}
