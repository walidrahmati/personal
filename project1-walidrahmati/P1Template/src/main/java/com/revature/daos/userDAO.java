package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.revature.models.roles;
import com.revature.models.users;
import com.revature.utils.ConnectionUtil;

public class userDAO implements userDaoInterface{

	@Override
	public boolean InsertUser(users user) {
try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into users (username, password, user_first_name, user_last_name, user_email, user_role_id_fk) values (?,?,?, ?, ? ,?);";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_first_name());
			ps.setString(4, user.getUser_last_name());
			ps.setString(5, user.getUser_email());
			ps.setInt(6, user.getRole_id_fk());
			System.out.println(user.getUser_name());
			ps.executeUpdate();
			
			System.out.println("User " + user.getUser_name() + " has been created");
			
			return true; 
				
			} catch (SQLException e) { 
				System.out.println("Cannot add user!"); 
				e.printStackTrace(); 
			}
			
			return false; 
	}

	@Override
	public ArrayList<users> getUsers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			

			String sql = "select * from users;";
			

			PreparedStatement s = conn.prepareStatement(sql);
			
			ResultSet rs = s.executeQuery();
			
			
			ArrayList<users> UserList = new ArrayList<>();
			
			
			while(rs.next()) { 
				
				roles r2 = new roles();
				r2.setRole_id(rs.getInt("user_role_id_fk"));
				users u = new users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getString("user_first_name"),
							rs.getString("user_last_name"),
							rs.getString("user_email"),
							rs.getInt("user_role_id_fk"),
							null
						);
						
				
				int userTypeFK = rs.getInt("user_role_id_fk");
				
				
				roleDAO rDAO = new roleDAO();
				
				
				 roles r = rDAO.getRoleById(userTypeFK);
				
				u.setRole(r);
				UserList.add(u); 
				
			} 
			
			
			return UserList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING USERS"); 
			e.printStackTrace();
		}
		
		return null; 
	}
	public users getUsersById(int id){
		try(Connection conn = ConnectionUtil.getConnection()){
			

			String sql = "select * from users where user_id=?;";
			

			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if(rs.next()) { 
				
				roles r2 = new roles();
				r2.setRole_id(rs.getInt("user_role_id_fk"));
				users u = new users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getString("user_first_name"),
							rs.getString("user_last_name"),
							rs.getString("user_email"),
							rs.getInt("user_role_id_fk"),
							null
						);
						
				
				int userTypeFK = rs.getInt("user_role_id_fk");
				
				
				roleDAO rDAO = new roleDAO();
				
				
				 roles r = rDAO.getRoleById(userTypeFK);
				
				u.setRole(r);
				 
				return u;
			} 
			
			
			
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING USERS"); 
			e.printStackTrace();
		}
		
		return null; 
	}

	@Override
	public void deleteUser(int id) {
try(Connection conn = ConnectionUtil.getConnection()){
			
			
			String sql = "delete from users where user_id = ?;";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			
			
			System.out.println("User with ID: " + id +" Deleted");
			
		} catch (SQLException e) {
			System.out.println("Error in the operation");
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean updateUser_first_name(int id, String firstName) {
		try(Connection conn = ConnectionUtil.getConnection()){
            
            String sql = "update users set user_first_name = ? where user_id = ?;";
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
    
            
            ps.setInt(2, id);
            ps.setString(1, firstName);
            
            ps.executeUpdate();
           return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update");
        }
        
        return false;
	
}
		

	@Override
	public boolean updateUser_last_name(int id, String lastName) {
		try(Connection conn = ConnectionUtil.getConnection()){
            
            String sql = "update users set user_last_name = ? where user_id = ?;";
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
    
            
            ps.setInt(2, id);
            ps.setString(1, lastName);
            
            ps.executeUpdate();
           
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update");
        }
        
        return false;
	
}
		

}
