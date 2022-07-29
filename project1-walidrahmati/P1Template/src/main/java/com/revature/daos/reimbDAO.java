package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.revature.models.reimbs;
import com.revature.models.reimbtype;
import com.revature.models.roles;
import com.revature.models.users;
import com.revature.utils.ConnectionUtil;

public class reimbDAO implements reimbDaoInterface{

	@Override
	public ArrayList<reimbs> getReimbs() {
		try(Connection conn = ConnectionUtil.getConnection()){
			

			String sql = "select * from reimbs;";
			

			PreparedStatement s = conn.prepareStatement(sql);
			
			ResultSet rs = s.executeQuery();
			
			
			ArrayList<reimbs> ReimbList = new ArrayList<>();
			
			
			while(rs.next()) { 

				users author = new userDAO().getUsersById(rs.getInt("reimb_author_id"));
				users resolver=new userDAO().getUsersById(rs.getInt("reimb_resolver_id_fk"));
				reimbtype reimb_type=new reimbTypeDAO().getReimbById(rs.getInt("reimb_type_id_fk"));

				reimbs r = new reimbs(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getString("reimb_receipt_url"),
						rs.getBoolean("reimb_is_approved"),
						reimb_type,
						author.getUser_id(),
						resolver.getUser_id()
						);
				

				ReimbList.add(r);
				
			} 
			
			
			return ReimbList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMNETS"); 
			e.printStackTrace();
		}
		
		return null; 
		
	}
	
	public ArrayList<reimbs> getReimbs(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			

			String sql = "select * from reimbs where reimb_author_id_fk=?;";
			

			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			
			
			ArrayList<reimbs> ReimbList = new ArrayList<>();
			
			
			while(rs.next()) { 

				users author = new userDAO().getUsersById(rs.getInt("reimb_author_id"));
				users resolver=new userDAO().getUsersById(rs.getInt("reimb_resolver_id_fk"));
				reimbtype reimb_type=new reimbTypeDAO().getReimbById(rs.getInt("reimb_type_id_fk"));

				reimbs r = new reimbs(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getString("reimb_receipt_url"),
						rs.getBoolean("reimb_is_approved"),
						reimb_type,
						author.getUser_id(),
						resolver.getUser_id()
						);
				

				ReimbList.add(r);
				
			} 
			
			
			return ReimbList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMNETS"); 
			e.printStackTrace();
		}
		
		return null; 
		
	}

	@Override
	public boolean approveReimb(int id, int re_id) {
try(Connection conn = ConnectionUtil.getConnection()){
            
            String sql = "update reimbs set reimb_resolved=now(), reimb_is_approved=true, reimb_resolver_id=? where reimb_id = ?;";
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
    
            
            ps.setInt(1, id);
            ps.setInt(2, re_id);
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update");
        }
        
return false;
    	
	
}
	@Override
	public boolean denyReimb(int id, int re_id) {
try(Connection conn = ConnectionUtil.getConnection()){
            
            String sql = "update reimbs set reimb_resolved=now(), reimb_is_approved=false, reimb_resolver_id=? where reimb_id = ?;";
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
    
            
            ps.setInt(1, id);
            ps.setInt(2, re_id);
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update");
        }
        
return false;
	}

	@Override
	public void deleteReimb(int id) {
try(Connection conn = ConnectionUtil.getConnection()){
			
			
			String sql = "delete from reimbs where reimb_id = ?;";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
			System.out.println("Reimbursement with ID: " + id +" Deleted");
			
		} catch (SQLException e) {
			System.out.println("Error in the operation");
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean insertReimb(reimbs reimb) {
		{
			try(Connection conn = ConnectionUtil.getConnection()){
						
						String sql = "insert into reimbs (reimb_amount, reimb_submitted, reimb_resolved, reimb_receipt_url, "
								+ "reimb_is_approved, reimb_type_id_fk, reimb_author_id_fk, reimb_resolver_id_fk) values ("
								+ "?, now(), null ,?, false, ?, ?, ?);";
						
					    
						
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, reimb.getReimb_amount());
						ps.setString(2, reimb.getReimb_receipt_url());
						ps.setInt(3, reimb.getReimb_type_id_fk().getReimb_id());
						ps.setInt(4, reimb.getReimb_author_id_fk());
						ps.setInt(5, reimb.getReimb_resolver_id_fk());
						System.out.println(ps.toString());
						
						ps.executeUpdate();
						
						System.out.println("Reimbursement for " + reimb.getReimb_description()+ " has been created");
						
						return true; 
							
						} catch (SQLException e) { 
							System.out.println("Cannot add new Reimbursement!"); 
							e.printStackTrace(); 
						}
						
						return false;

				}

	}


}
