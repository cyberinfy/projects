package com.quest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.quest.bean.QuestFeedback;
import com.quest.service.QuestFeedbackService;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("operation"));
		if( request.getParameter("operation").equalsIgnoreCase("retrieval")){
			JSONArray jsonArray = new JSONArray();
			ArrayList<QuestFeedback> list = new ArrayList<QuestFeedback>();
			list = new QuestFeedbackService().performRetrieval();
			System.out.println(list.size());
			if(list.size()>0){
				for(QuestFeedback l : list) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("employeeid", l.getEmployeeid());
					jsonObject.put("feedback", l.getFeedback());
					jsonObject.put("stream", l.getStream());
					jsonArray.add(jsonObject);
				}
			}
			out.print(jsonArray);
		}
		else{
			JSONObject jsonObject = new JSONObject();
			QuestFeedback questFeedback = new QuestFeedback(
					Integer.parseInt(request.getParameter("employeeid")),
					request.getParameter("feedback"),
					request.getParameter("stream")
					);
			int status = new QuestFeedbackService().performInsert(questFeedback);
			System.out.println(status);
			if(status>0){
				jsonObject.put("status", "success");
			}
			else{
				jsonObject.put("status", "failure");
			}
			out.print(jsonObject);
			
		}
	}

}
