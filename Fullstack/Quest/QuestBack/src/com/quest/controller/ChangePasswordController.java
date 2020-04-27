package com.quest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.quest.bean.QuestAdmin;
import com.quest.service.QuestAdminService;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		QuestAdmin questAdmin = new QuestAdmin(
				Integer.parseInt(request.getParameter("employeeid")),
				request.getParameter("password"));
		QuestAdminService questAdminService = new QuestAdminService();
		if(questAdminService.performUpdate(questAdmin)>0) {
			jsonObject.put("status", "success");
		}
		else {
			jsonObject.put("status", "failure");
		}
		System.out.println(jsonObject);
		out.print(jsonObject);
		
	}

}
