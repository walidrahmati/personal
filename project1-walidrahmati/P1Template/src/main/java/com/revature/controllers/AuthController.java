package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	AuthService as = new AuthService();
	

	public static HttpSession ses;
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		String loginUsername = as.login(lDTO.getUser_name(), lDTO.getUser_password()); 
		
		if(loginUsername != null) { 
			
			ses = ctx.req.getSession(); 
		
			ctx.result("welcome " + loginUsername);
			ctx.status(202); 
			
		} else {
			ctx.status(401);
			System.out.println("Error");
			ctx.result("Error Please check user name and password");
		}
		
	};


	public Handler logoutHandler = (ctx) ->{
		if(ses!=null) {
		ses=null;
		System.out.println("You are logged out.");
		ctx.result("You Are logged out");
		ctx.status(200);
		}
		else {
			System.out.println("You are not logged in.");
			ctx.result("Not logged in.");
			ctx.status(400);
			}
			
	};
}
