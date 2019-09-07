package com.cg.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;








import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FMSException;
import com.cg.fms.util.DBUtil;

public class FeedbackDaoImpl implements FeedbackDao{
	
	
Connection con;
	
	public FeedbackDaoImpl()
	{
		con = DBUtil.getConnection();
		
	}

	@Override
	public ArrayList<Feedback> getFeedbackByParticipantId(int id)
			throws FMSException {
		ArrayList<Feedback> list = new ArrayList<Feedback>();
		Feedback ref= null;
		String qry = "SELECT * FROM  FEEDBACK_MASTER WHERE PARTICIPANT_ID=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				 int tId = rs.getInt(1);
				  int pId=rs.getInt(2);
				  int presentation=rs.getInt(3);
				  int clarifyDoubts= rs.getInt(4);
				  int timeMgt=rs.getInt(5);
				  int hndOut=rs.getInt(6);
				  int hwSw=rs.getInt(7);
				String sugg = rs.getString(8);
				String comment = rs.getString(9);
				ref = new Feedback(tId,pId,presentation,clarifyDoubts,timeMgt,hndOut,hwSw,sugg,comment);
				list.add(ref);
				
			}
		}
		catch(Exception e)
		{
			throw new FMSException(e.getMessage());
		}
		return list;
		
	}


	

	@Override
	public ArrayList<Feedback> getFeedbackByTrainingId(int id)
			throws FMSException {
		ArrayList<Feedback> list = new ArrayList<Feedback>();
		Feedback ref= null;
		String qry = "SELECT * FROM  FEEDBACK_MASTER WHERE TRAINING_CODE=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				 int tId = rs.getInt(1);
				  int pId=rs.getInt(2);
				  int presentation=rs.getInt(3);
				  int clarifyDoubts= rs.getInt(4);
				  int timeMgt=rs.getInt(5);
				  int hndOut=rs.getInt(6);
				  int hwSw=rs.getInt(7);
				String sugg = rs.getString(8);
				String comment = rs.getString(9);
				ref = new Feedback(tId,pId,presentation,clarifyDoubts,timeMgt,hndOut,hwSw,sugg,comment);
				list.add(ref);
				
			}
		}
		catch(Exception e)
		{
			throw new FMSException(e.getMessage());
		}
		return list;
	
		
	}

	@Override
	public ArrayList<Feedback> getAllFeedbacks() throws FMSException {
		
		String qry = "SELECT * FROM FEEDBACK_MASTER";
		ArrayList<Feedback>list = new ArrayList<Feedback>();
		Feedback ref= null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				
				 int tId = rs.getInt(1);
				  int pId=rs.getInt(2);
				  int presentation=rs.getInt(3);
				  int clarifyDoubts= rs.getInt(4);
				  int timeMgt=rs.getInt(5);
				  int hndOut=rs.getInt(6);
				  int hwSw=rs.getInt(7);
				String sugg = rs.getString(8);
				String comment = rs.getString(9);
				ref = new Feedback(tId,pId,presentation,clarifyDoubts,timeMgt,hndOut,hwSw,sugg,comment);
				list.add(ref);
				
			}
			
		}
		catch(Exception e)
		{
			throw new FMSException(e.getMessage());
		}
		return list;
	}
	

	@Override
	public int addFeedback(Feedback feedback) throws FMSException {
		int row;
		Feedback ref = null;
		String qry = "INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, feedback.getTrainingCode());
			pstmt.setInt(2, feedback.getParticipantId());
			pstmt.setInt(3, feedback.getPresentationCommunication());
			pstmt.setInt(4, feedback.getClarifyDoubts());
			pstmt.setInt(5, feedback.getTimeManagement());
			pstmt.setInt(6, feedback.getHandOut());
			pstmt.setInt(7, feedback.getHwSwNetwork());
			pstmt.setString(8, feedback.getComments());
			pstmt.setString(9, feedback.getSuggestions());
			
			
			 row = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			throw new FMSException(e.getMessage());
		}
		return row;
	}

}
