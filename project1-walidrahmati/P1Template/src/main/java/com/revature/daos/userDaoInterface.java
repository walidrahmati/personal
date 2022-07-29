package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.users;

public interface userDaoInterface {
	
	boolean InsertUser(users user);
	
	ArrayList<users> getUsers();
	
	public void deleteUser(int id);
	
	public boolean updateUser_first_name(int id, String firstName);
	
	public boolean updateUser_last_name(int id, String lastName);

}
