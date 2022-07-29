package com.revature.models;

public class reimbtype {
	private int reimb_id_fk;
	private String reimb_name;
	public reimbtype() {
		super();
		// TODO Auto-generated constructor stub
	}
	public reimbtype(int reimb_id, String reimb_name) {
		super();
		this.reimb_id_fk = reimb_id;
		this.reimb_name = reimb_name;
	}
	public reimbtype(String reimb_name) {
		super();
		this.reimb_name = reimb_name;
	}
	public int getReimb_id() {
		return reimb_id_fk;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id_fk = reimb_id;
	}
	public String getReimb_name() {
		return reimb_name;
	}
	public void setReimb_name(String reimb_name) {
		this.reimb_name = reimb_name;
	}
	@Override
	public String toString() {
		return "reimbtype [reimb_id_fk=" + reimb_id_fk + ", reimb_name=" + reimb_name + "]";
	}

	
	
}
