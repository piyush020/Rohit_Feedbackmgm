package com.cg.fms.dao;

import java.util.ArrayList;

import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FMSException;

public interface FeedbackDao {
	
	public ArrayList<Feedback> getFeedbackByParticipantId(int id) throws FMSException;  
	public ArrayList<Feedback> getFeedbackByTrainingId(int id) throws FMSException;  
	public ArrayList<Feedback> getAllFeedbacks() throws FMSException;
	public int  addFeedback(Feedback feedback) throws FMSException;

}
