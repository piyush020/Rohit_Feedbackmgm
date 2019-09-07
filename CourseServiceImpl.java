package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dao.*;
import com.cg.fms.dto.Course;
import com.cg.fms.exception.FMSException;

public class CourseServiceImpl implements CourseService {

	
    CourseDao dao;
	
	public CourseServiceImpl()
	{
		dao=new CourseDaoImpl();
	}
	@Override
	public Course getCourseById(int id) throws FMSException {
		
		return dao.getCourseById(id);
	}

	@Override
	public ArrayList<Course> getAllCourse() throws FMSException {
		
		return dao.getAllCourse();
	}

	@Override
	public Course addCourse(Course course) throws FMSException {
		
		return dao.addCourse(course);
	}

	@Override
	public Course updateCourse(Course course) throws FMSException {
		
		return dao.updateCourse(course);
	}

	@Override
	public boolean deleteCourse(int id) throws FMSException {
		
		return dao.deleteCourse(id);
	}

	
}
