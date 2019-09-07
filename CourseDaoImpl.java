package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.fms.dto.*;
import com.cg.fms.exception.FMSException;
import com.cg.fms.util.*;

public class CourseDaoImpl implements CourseDao {

	
Connection con;
	
	public CourseDaoImpl()
	{
		con = DBUtil.getConnection();
		
	}
	
	@Override
	public Course getCourseById(int id) throws FMSException {
	
		Course ref = null;
		String qry = "SELECT * FROM course_master WHERE  COURSE_ID=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				int courseId = rs.getInt(1);
				String courseName = rs.getString(2);
				int noOfDays = rs.getInt(3);
				ref = new Course(courseId,courseName,noOfDays);
				
			}
		}
		catch(Exception e)
		{
		     throw new FMSException(e.getMessage());
		}
		return ref;
	}

	@Override
	public ArrayList<Course> getAllCourse() throws FMSException {
		
		String qry = "SELECT * FROM course_master";
		ArrayList<Course>list = new ArrayList<Course>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				int courseId = rs.getInt(1);
				String courseName = rs.getString(2);
				int noOfDays = rs.getInt(3);
				Course course = new Course(courseId,courseName,noOfDays);
				list.add(course);
			}
		}
		catch(Exception e)
		{
		     throw new FMSException(e.getMessage());
		}
		return list;
	}

	@Override
	public Course addCourse(Course course) throws FMSException {
		
		Course ref = null;
		String qry = "INSERT INTO course_master VALUES(seq_course.nextval,?,?)";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getNoOfDays());
			int row = pstmt.executeUpdate();
			if(row>0)
			{
				course.getCourseId();
				ref = course;
			}
		}
		catch(Exception e)
		{
		     throw new FMSException(e.getMessage());
		}
		return ref;
	}
	public int getCourseId() throws FMSException
	{
		int id = 0;
		String qry = "SELECT seq_course.currval FROM DUAL";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
		     throw new FMSException(e.getMessage());
		}
		return id;
	}

	@Override
	public Course updateCourse(Course course) throws FMSException {
		
		Course ref =null;
		String qry = "UPDATE course_master SET COURSE_NAME=?,NO_OF_DAYS=? WHERE COURSE_ID=?";
		try
		{
		PreparedStatement pstmt = null;
		 pstmt = con.prepareStatement(qry);
		 pstmt.setString(1, course.getCourseName());
         pstmt.setInt(2, course.getNoOfDays());
         pstmt.setInt(3, course.getCourseId());
         int row=pstmt.executeUpdate();
         if(row>0){
        	ref=course;
         }
         
		}
		catch(Exception e){
		     throw new FMSException(e.getMessage());
		}
		return ref;
	}

	@Override
	public boolean deleteCourse(int id) throws FMSException {
		
		boolean deleteCourse=false;int deleted=0;
		String qry = "DELETE FROM course_master WHERE COURSE_ID=?";
		try
		{
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			deleted=pstmt.executeUpdate();
			if(deleted>0)
				deleteCourse=true;
			else
				deleteCourse=false;
			
		}
		catch(Exception e)
		{
		     throw new FMSException(e.getMessage());
		}
		return deleteCourse;
		
	}

}
