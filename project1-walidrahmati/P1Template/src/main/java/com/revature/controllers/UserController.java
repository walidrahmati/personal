package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.userDAO;
import com.revature.models.users;

import io.javalin.http.Handler;

public class UserController {


	userDAO uDAO = new userDAO();
	
	
	public Handler getUserHandler = (ctx) -> {
	
		if(AuthController.ses != null) { 
		ArrayList<users> user = uDAO.getUsers();	
		Gson gson = new Gson();	
		String JSONuser = gson.toJson(user);	
		ctx.result(JSONuser); 	
		ctx.status(200);
		} else { 
			ctx.result("Please log in and try again");
			ctx.status(401); 
		}
		
	}; 
	

	public Handler insertUserHandler = (ctx) -> {
		
		String body = ctx.body();
	
		Gson gson = new Gson();
		
		if(AuthController.ses != null) { 
		users newUser = gson.fromJson(body, users.class);
		System.out.println("Reached");
		if(uDAO.InsertUser(newUser)) {
			
			ctx.status(202); 
		} else {
			ctx.status(406);
		}
		}
		else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler deleteUserHandler = (ctx) -> {
		
		int youreFired = Integer.valueOf(ctx.pathParam("id"));
		if(AuthController.ses!=null) {
		uDAO.deleteUser(youreFired);
		ctx.result("User " + youreFired + " Deleted");
		ctx.status(200);
		}
		else {
			ctx.result("You are not loggin in");
			ctx.status(401);
		}
		
		
	};

	public Handler updateUser_first_name_Handler = (ctx) -> {
		if(AuthController.ses != null){
			
				int user_id = Integer.parseInt(ctx.body());
				String user_name=ctx.pathParam("user_first_name");
				
			if(uDAO.updateUser_first_name(user_id, user_name)) {
				
			}
		}
		else {
			ctx.result("You are not loggin in");
			ctx.status(401);
		}
	};

	public Handler updateUser_last_name_Handler = (ctx) -> {
		if(AuthController.ses != null){
			
				int user_id = Integer.parseInt(ctx.body());
				String user_name=ctx.pathParam("user_last_name");
				
			if(uDAO.updateUser_last_name(user_id, user_name)) {
				
			}
		}
		else {
			ctx.result("You are not loggin in");
			ctx.status(401);
		}
	};

}
