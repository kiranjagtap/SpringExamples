package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.model.Circle;

public class JdbcDaoImpl {

	Circle circle=null;
	public Circle getCircle(int circleId) {
		Connection conn = null;
		String driver = "org.apache.derby.jdbc.ClientDriver";
		
		try {
		Class.forName(driver).newInstance();
		
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM circle where id=?");
		
		stmt.setInt(1, circleId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			circle = new Circle(circleId, rs.getString("name"));
		}
				
		rs.close();
		stmt.close();
		
		return circle;
		}catch(Exception e) {
			 throw new RuntimeException(e); 
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
