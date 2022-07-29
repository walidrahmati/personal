package com.revature.models;

public class users {
	
	private int user_id;
	private String user_name;
	private String user_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private int role_id_fk;
	private roles role;
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public users(int user_id, String user_name, String user_password, String user_first_name, String user_last_name,
			String user_email,int role_id_fk, roles role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.role_id_fk=role_id_fk;
		this.role=role;

	}
	public roles getRole() {
		return role;
	}
	public void setRole(roles role) {
		this.role = role;
	}
	public users(String user_name, String user_password, String user_first_name, String user_last_name,
			String user_email, int role_id_fk) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.role_id_fk = role_id_fk;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getRole_id_fk() {
		return role_id_fk;
	}
	public void setRole_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}
	@Override
	public String toString() {
		return "users [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name + ", user_email="
				+ user_email + ", role_id_fk=" + role_id_fk + ", role=" + role + "]";
	}


}
