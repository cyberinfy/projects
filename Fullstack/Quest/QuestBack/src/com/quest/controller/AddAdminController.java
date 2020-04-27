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

import com.quest.bean.QuestAdmin;
import com.quest.service.QuestAdminService;

/**
 * Servlet implementation class AddAdminController
 */
@WebServlet("/AddAdminController")
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		QuestAdminService questAdminService = null;
		QuestAdmin questAdmin = null;
		if(request.getParameter("operation").equalsIgnoreCase("add")){
					questAdmin = new QuestAdmin(
					Integer.parseInt(request.getParameter("employeeid")),
					request.getParameter("password"));
					questAdminService = new QuestAdminService();
			if(questAdminService.performInsert(questAdmin)>0) {
				jsonObject.put("status", "success");
			}
			else {
				jsonObject.put("status", "failure");
			}
			System.out.println(jsonObject);
			out.print(jsonObject);
		}
		else if(request.getParameter("operation").equalsIgnoreCase("remove")){
			questAdmin = new QuestAdmin(
					Integer.parseInt(request.getParameter("employeeid")),
					request.getParameter("password"));
					questAdminService = new QuestAdminService();
			if(questAdminService.performDelete(questAdmin)>0) {
				jsonObject.put("status", "success");
			}
			else {
				jsonObject.put("status", "failure");
			}
			System.out.println(jsonObject);
			out.print(jsonObject);
		}
		else{
			JSONArray jsonArray = new JSONArray();
			questAdminService = new QuestAdminService();
			ArrayList<String> adminList = new ArrayList<String>();
			adminList = questAdminService.retrieveAll();
			if(adminList.size()>0) {
				for(String admin : adminList){
					jsonObject = new JSONObject();
					jsonObject.put("employeeid", admin);
					jsonArray.add(jsonObject);
				}
				
			}
			System.out.println(jsonArray);
			out.print(jsonArray);
		}
	}

}
