package com.cbm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbm.bean.Item;
import com.cbm.bean.User;
import com.cbm.dao.PopulateItem;
import com.cbm.dao.PrePopulation;

/**
 * Servlet implementation class PopulateUser
 */
@WebServlet("/PopulateUser")
public class PopulateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrePopulation population = new PrePopulation();
		ArrayList<User> al = new ArrayList<User>();
		ArrayList<Item> itemArrayList = new ArrayList<Item>();
		int currentBalance = 0;
		
		try {
			al = population.getUserName();
			itemArrayList = new PopulateItem().getItemName();
			currentBalance = population.getCurrentBalance();
			System.out.println("PopulatedItemArrayList " + itemArrayList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		request.setAttribute("UserList", al);
		request.setAttribute("ItemList", itemArrayList);
		request.setAttribute("currentBalance", currentBalance);
		request.getRequestDispatcher("Homepage2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
