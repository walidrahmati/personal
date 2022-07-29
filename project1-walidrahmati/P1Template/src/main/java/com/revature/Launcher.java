package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;

import com.revature.controllers.AuthController;
import com.revature.controllers.UserController;
import com.revature.daos.userDAO;
import com.revature.daos.roleDAO;
import com.revature.utils.ConnectionUtil;
import com.revature.daos.reimbDAO;
import com.revature.models.reimbs;
import com.revature.models.reimbtype;
import com.revature.models.users;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		userDAO UDAO = new userDAO();
		roleDAO RDAO = new roleDAO();
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			
			System.out.println("connection failed...");
			e.printStackTrace();
		} 
			
		
		
		Javalin app = Javalin.create(
				
				
				config -> {
					config.enableCorsForAllOrigins(); 
				}
				
				).start(3000);

		UserController uc = new UserController();	

		AuthController ac = new AuthController();
		
		

		app.get("/users", uc.getUserHandler);
		
		app.post("/users", uc.insertUserHandler);
		
		app.put("/users/firstname/:user_first_name", uc.updateUser_first_name_Handler);
		app.put("/users/lastname/:user_last_name", uc.updateUser_last_name_Handler);
		
		app.delete("/delete/:id", uc.deleteUserHandler);

		app.post("/login", ac.loginHandler);
		
		app.post("/logout", ac.logoutHandler);
		
	}
		
	
	
}
