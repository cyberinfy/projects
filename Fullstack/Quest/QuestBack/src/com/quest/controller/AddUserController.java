package com.quest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.quest.bean.QuestUser;
import com.quest.service.QuestAdminService;
import com.quest.service.QuestUsersService;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
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
		if(request.getParameter("operation").equalsIgnoreCase("add")){
			QuestUser questUser = new QuestUser(
					Integer.parseInt(request.getParameter("employeeid")),
					request.getParameter("name"),
					request.getParameter("lg")
					);
			JSONObject jsonObject = new JSONObject();
			if(new QuestUsersService().performInsert(questUser)>0) {
					jsonObject .put("status", "success");
				}
				else {
					jsonObject.put("status", "failure");
				}
				System.out.println(jsonObject);
				out.print(jsonObject);
		}
		else if(request.getParameter("operation").equalsIgnoreCase("remove")){
			int employeeid = Integer.parseInt(request.getParameter("employeeid"));
			JSONObject jsonObject = new JSONObject();
			if(new QuestUsersService().performDelete(employeeid)>0) {
					jsonObject .put("status", "success");
				}
				else {
					jsonObject.put("status", "failure");
				}
				System.out.println(jsonObject);
				out.print(jsonObject);
		}
		
		else{
			JSONArray jsonArray = new JSONArray();
			ArrayList<QuestUser> userList = new ArrayList<QuestUser>();
			userList = new QuestUsersService().retrieveAll();
			if(userList.size()>0) {
				for(QuestUser questUser : userList){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("employeeid", questUser.getEmployeeId());
					jsonObject.put("name", questUser.getName());
					jsonObject.put("lg", questUser.getLg());
					jsonArray.add(jsonObject);
				}
				
			}
			System.out.println(jsonArray);
			out.print(jsonArray);
		}
	}

}
