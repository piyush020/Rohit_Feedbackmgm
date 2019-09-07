package com.cg.fms.service;

import java.util.ArrayList;

import com.cg.fms.dao.FeedbackDao;
import com.cg.fms.dao.FeedbackDaoImpl;
import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FMSException;



public class FeedbackServiceImpl implements FeedbackService {
FeedbackDao dao;
	
	public FeedbackServiceImpl()
	{
		dao = new FeedbackDaoImpl();
	}

	@Override
	public ArrayList<Feedback> getFeedbackByParticipantId(int id)
			throws FMSException {
	
		return dao.getFeedbackByParticipantId(id);
	}

	@Override
	public ArrayList<Feedback> getFeedbackByTrainingId(int id)
			throws FMSException {
		
		return dao.getFeedbackByTrainingId(id);
	}

	@Override
	public ArrayList<Feedback> getAllFeedbacks() throws FMSException {
		// TODO Auto-generated method stub
		return dao.getAllFeedbacks();
	}

	@Override
	public int addFeedback(Feedback feedback) throws FMSException {
		// TODO Auto-generated method stub
		return dao.addFeedback(feedback);
	}

	@Override
	public boolean validateRating(int rating) throws FMSException {
		if(rating<=5)
			return true;
		else
		return false;
	}
}
