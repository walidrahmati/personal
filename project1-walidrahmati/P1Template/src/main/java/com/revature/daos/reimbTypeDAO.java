package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.reimbtype;
import com.revature.utils.ConnectionUtil;

public class reimbTypeDAO implements reimbTypeDaoInterface{

	@Override
	public reimbtype getReimbById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from reimb_types where reimb_type_id=?;";

			PreparedStatement s = conn.prepareStatement(sql);

			s.setInt(1, id);

			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				reimbtype r = new reimbtype(rs.getInt("reimb_type_id"), rs.getString("reimb_type_name"));
				return r;
			}

			

		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG!!");
			e.printStackTrace();
		}
		return null;
	}

}
