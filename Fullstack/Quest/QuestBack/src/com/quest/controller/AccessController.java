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
import com.quest.service.QuestUsersService;

/**
 * Servlet implementation class AccessController
 */
@WebServlet("/AccessController")
public class AccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		QuestUsersService questUsersService = new QuestUsersService();
		if(questUsersService.validUser(request.getParameter("employeeid"))>0) {
			jsonObject.put("status", "success");
		}
		else {
			jsonObject.put("status", "failure");
		}
		System.out.println(jsonObject);
		out.print(jsonObject);
	}

}
