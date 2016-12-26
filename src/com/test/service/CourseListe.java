package com.test.service;

import java.util.ArrayList;

import com.test.dao.Course;

public class CourseListe {

	private ArrayList<Course> lstCourse;

	public ArrayList<Course> getLstCourse() {
		return lstCourse;
	}

	public void setLstCourse(ArrayList<Course> lstCourse) {
		this.lstCourse = lstCourse;
	}

	public CourseListe(ArrayList<Course> lstCourse) {
		super();
		this.lstCourse = lstCourse;
	}
	
}
