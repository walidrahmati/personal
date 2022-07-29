package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.roles;
import com.revature.utils.ConnectionUtil;

public class roleDAO implements roleDaoInterface {

	@Override
	public roles getRoleById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from user_roles where user_role_id=?;";

			PreparedStatement s = conn.prepareStatement(sql);

			s.setInt(1, id);

			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				roles r = new roles(rs.getInt("user_role_id"), rs.getString("user_role_name"));
				return r;
			}

			

		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG!!");
			e.printStackTrace();
		}

		return null;
	}

}
