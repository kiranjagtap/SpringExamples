package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.model.Circle;

public class JdbcdDaoImpl {

	Connection conn = null;

	Circle circle = null;

	public Circle getCircle(int circleId) {

		String connString = "jdbc:derby://localhost:1527/db";

		String driver = "org.apache.derby.jdbc.ClientDriver";

		try {
			Class.forName(driver).newInstance();

			conn = DriverManager.getConnection(connString);

			String sql = "SELECT * FROM circle WHERE id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, circleId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}

			return circle;

		} catch (Exception e) {

			throw new RuntimeException(e);

		} finally {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
