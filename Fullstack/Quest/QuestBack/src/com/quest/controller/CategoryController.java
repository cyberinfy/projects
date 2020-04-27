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

import com.quest.bean.QuestCategory;
import com.quest.service.QuestAdminService;
import com.quest.service.QuestCategoriesService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
		QuestCategoriesService questCategoriesService = new QuestCategoriesService();
		if(request.getParameter("operation").equalsIgnoreCase("add")){
			QuestCategory questCategory = new QuestCategory(request.getParameter("categoryname"));
			JSONObject jsonObject = new JSONObject();
			if(questCategoriesService.performInsert(questCategory)>0){
				jsonObject.put("status", "success");
			}
			else{
				jsonObject.put("status", "failure");
			}
			out.print(jsonObject);
			
		}
		else if(request.getParameter("operation").equalsIgnoreCase("remove")){
			QuestCategory questCategory = new QuestCategory(request.getParameter("categoryname"));
			JSONObject jsonObject = new JSONObject();
			if(questCategoriesService.performDelete(questCategory)>0){
				jsonObject.put("status", "success");
			}
			else{
				jsonObject.put("status", "failure");
			}
			out.print(jsonObject);
			
		}
		else{
			JSONArray jsonArray = new JSONArray();
			ArrayList<String> categoryList = new ArrayList<String>();
			categoryList = questCategoriesService.retrieveAll();
			if(categoryList.size()>0) {
				for(String category : categoryList){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("categoryname", category);
					jsonArray.add(jsonObject);
				}
				
			}
			System.out.println(jsonArray);
			out.print(jsonArray);
		}
	}

}
