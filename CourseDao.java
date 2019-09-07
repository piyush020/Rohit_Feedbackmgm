package com.cg.fms.dao;

import java.util.ArrayList;

import com.cg.fms.dto.Course;
import com.cg.fms.exception.FMSException;


public interface CourseDao {
	
	public Course getCourseById(int id) throws FMSException;  
	public ArrayList<Course> getAllCourse() throws FMSException;
	public Course addCourse(Course course) throws FMSException;
	public Course updateCourse(Course course) throws FMSException;
	public boolean deleteCourse(int id) throws FMSException;
	
}
