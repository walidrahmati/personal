package com.revature.models;

public class LoginDTO {


		private String user_name;
		private String user_password;
		private int user_type_id;
		
		public LoginDTO(String user_name, String user_password, int type_id) {
			super();
			this.user_name = user_name;
			this.user_password = user_password;
			this.user_type_id=type_id;
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

		public int getUser_type_id() {
			return user_type_id;
		}

		public void setUser_type_id(int user_type_id) {
			this.user_type_id = user_type_id;
		}
}
