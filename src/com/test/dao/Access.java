package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class Access {

	public ArrayList<Course> getCourses(Connection con) throws SQLException
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM cours");
		ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
		Course courseObj = new Course();
		courseObj.setId(rs.getInt("id"));
		courseObj.setName(rs.getString("name"));
		courseObj.setDuration(rs.getString("duration"));
		courseObj.setFee(rs.getDouble("fee"));
		courseList.add(courseObj);
	}
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
	return courseList;
	 
	}

	public void addCourse(Connection con, Course p) throws SQLException {
		// TODO Auto-generated method stub
		String insertTableSQL = "INSERT INTO cours"
				+ "(name, duration, fee) VALUES"
				+ "(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, p.getName().toString());
		preparedStatement.setString(2, p.getDuration().toString());
		preparedStatement.setDouble(3,  p.getFee());

		// execute insert SQL stetement
		preparedStatement .executeUpdate();
	}

	public void updateCourse(Connection con, Course p) throws SQLException {
		// TODO Auto-generated method stub
		
		String insertTableSQL = "UPDATE cours SET name = ?, duration = ? , fee= ? WHERE id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, p.getName().toString());
		preparedStatement.setString(2, p.getDuration().toString());
		preparedStatement.setLong(3, (long) p.getFee());
		preparedStatement.setLong(4, p.getId());
		preparedStatement .executeUpdate();

	}

	public void deleteCourse(Connection con, int id) throws SQLException {
		// TODO Auto-generated method stub
		String insertTableSQL = "DELETE from cours WHERE id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setLong(1, id);
		preparedStatement .executeUpdate();

	}
}
