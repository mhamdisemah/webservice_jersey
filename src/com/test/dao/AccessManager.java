package com.test.dao;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class AccessManager {

	Access access = new Access();
	public ArrayList<Course> getCourses() throws Exception
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		Database db = new Database();
		Connection con = db.getConnection();
		courseList = access.getCourses(con);
		return courseList;
	}

	public void ajouterCourse(Course p) throws Exception {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection con = db.getConnection();
		access.addCourse(con,p);
	}

	public void modifierCourse(Course p) throws Exception {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection con = db.getConnection();
		access.updateCourse(con,p);
	}

	public void suppCourse(int id) throws Exception {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection con = db.getConnection();
		access.deleteCourse(con,id);
	}
}
