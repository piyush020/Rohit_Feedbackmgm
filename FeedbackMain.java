package com.cg.fms.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FMSException;
import com.cg.fms.service.FeedbackService;
import com.cg.fms.service.FeedbackServiceImpl;

public class FeedbackMain {

	static Scanner sc = new Scanner(System.in);
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static FeedbackService fbService = null;
	public static void main(String[] args) throws FMSException, IOException{
		int  choice;
		fbService= new FeedbackServiceImpl();
		while(true)
		{
			System.out.println("what you want to do?");
			System.out.println("1:  Add Feedback \t\t 2: Get Feedback By Participant Id\t\t 3:Get Feedback By Training Id\t\t 4:Get Feedback\t\t 5: exit");
			choice= sc.nextInt();
			switch (choice)
			{
			case 1:insertFeedback();break;
			case 2:getByPId();break;
			case 3:getByTId();break;
			case 4:getAllFeedback();break;
			default :System.exit(1);
			}
		}
	}


	
	private static void getAllFeedback() throws FMSException {
		
		ArrayList<Feedback> list2= new ArrayList<Feedback>();
		list2= fbService.getAllFeedbacks();
		Iterator<Feedback> it=  list2.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	



	private static void insertFeedback() throws FMSException, IOException {
	    System.out.println("Enter Training Code");
		 int trainingCode= sc.nextInt();
		 System.out.println("Enter Participant Id");
		 int participantId= sc.nextInt();
		 System.out.println("Enter Presentation and Communication rating with in 5 (Five is the highest rating)");
			 int presentationCommunication= sc.nextInt();
			 if(fbService.validateRating(presentationCommunication))
		 {System.out.println("Enter Clarify Doubts rating with in 5 (Five is the highest rating)");
		 int clarifyDoubts= sc.nextInt();
		 if(fbService.validateRating(clarifyDoubts))
		 {
		 System.out.println("Enter Time Management rating with in 5 (Five is the highest rating)");
		 int timeManagement= sc.nextInt();
		 if(fbService.validateRating(timeManagement))
		 {
		 System.out.println("Enter HandOut rating with in 5 (Five is the highest rating)");
		 int handOut= sc.nextInt();
		 if(fbService.validateRating(handOut))
		 {
		 System.out.println("Enter hardware and software rating with in 5 (Five is the highest rating)");
		 int hwSwNetwork= sc.nextInt();
		 if(fbService.validateRating(hwSwNetwork))
		 {System.out.println("Enter Comments");
		 
		String comments=br.readLine();
		
		 System.out.println("Enter Suggestions");
		 String suggestions= br.readLine();
		 
		 Feedback feedback= new Feedback(trainingCode,participantId,presentationCommunication,clarifyDoubts,timeManagement,handOut,hwSwNetwork,comments,suggestions);
		int result= fbService.addFeedback(feedback);
		if(result!=0)
		{
			System.out.println("Feedback add successfully");
		}
		else
		{
			System.out.println(" Some Error for adding feedback");
		}
		 }
		 }
		 }
		 }
		 }
	}



	private static void getByPId() {
		System.out.println("Enter Participant id");
		int fid=sc.nextInt();
		try {
			ArrayList<Feedback> f=fbService.getFeedbackByParticipantId(fid);
			
			if(f!=null)
			System.out.println(f);
			else 
				System.out.println("No Feedback available for this id");
		}
		catch (FMSException e) {
			
			e.printStackTrace();
		}
	}
		private static void getByTId() {
			System.out.println("Enter Training Id");
			int tid=sc.nextInt();
			try {
				ArrayList<Feedback> f=fbService.getFeedbackByTrainingId(tid);
				if(f!=null)
				System.out.println(f);
				else 
					System.out.println("No Feedback available for this id");
			}
			catch (FMSException e) {
				
				e.printStackTrace();
			}
}
}
