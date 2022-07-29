package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.reimbs;

public interface reimbDaoInterface {
		
	ArrayList<reimbs> getReimbs();
	
	public boolean approveReimb(int id, int re_id);
	
	public boolean denyReimb(int id, int re_id);
	
	public void deleteReimb(int id);
	
	boolean insertReimb(reimbs reimb);
	
}
