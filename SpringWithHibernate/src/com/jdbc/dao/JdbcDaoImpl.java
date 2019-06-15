package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdbc.model.Circle;

@Component
public class JdbcDaoImpl {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	Circle circle = null;

	public Circle getCircle(int circleId) {
		Connection conn = null;

		try {

			conn = dataSource.getConnection();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM circle where id=?");

			stmt.setInt(1, circleId);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}

			rs.close();
			stmt.close();

			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle";
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public void insert(Circle circle) {

		String sql = "INSERT INTO CIRCLE " + "(id, name) VALUES (?, ?)";

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { circle.getId(), circle.getName() });

	}
	
	public List<Circle> getCircleObj() {
		String sql = "SELECT * FROM circle";

		jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Circle> circle = jdbcTemplate.query(
				  sql,
				  (rs, rowNum) -> {
					    Circle c = new Circle();
					    c.setId(rs.getInt("id"));
					    c.setName(rs.getString("name"));
					    return c;
					});
		return circle;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
