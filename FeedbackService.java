package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FMSException;

public interface FeedbackService {
	public ArrayList<Feedback> getFeedbackByParticipantId(int id) throws FMSException;  
	public ArrayList<Feedback> getFeedbackByTrainingId(int id) throws FMSException;  
	public ArrayList<Feedback> getAllFeedbacks() throws FMSException;
	public int addFeedback(Feedback feedback) throws FMSException;
	public boolean validateRating(int rating) throws FMSException;
}
