package com.cbm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbm.bean.Item;
import com.cbm.bean.Transaction;
import com.cbm.bean.User;
import com.cbm.dao.PopulateItem;
import com.cbm.dao.PrePopulation;
import com.cbm.dao.TranxDao;

/**
 * Servlet implementation class InsertTranx
 */
@WebServlet("/InsertTranx")
public class InsertTranx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTranx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("InsertTranx")){
			int flag = 0;
			TranxDao tranxDao = new TranxDao();
			Transaction transaction = new Transaction();
			Item item = new Item();
			User user = new User();
			int  itemId = Integer.parseInt(request.getParameter("itemDropDown"));
			int userId = Integer.parseInt(request.getParameter("userDropDown"));
			int balance  = Integer.parseInt(request.getParameter("balance"));
			System.out.println("ItemIdForTransaction "+ itemId);
			System.out.println("UserIdForTransaction "+ userId);
			try {
				item = new PopulateItem().getItemBean(itemId);
				user = new PrePopulation().getUserBean(userId);
				System.out.println(item);
				System.out.println(user);
				transaction.setAmount(Integer.parseInt(request.getParameter("amount")));
				transaction.setTranxSummary(request.getParameter("summary"));
				transaction.setUser(user);
				transaction.setItem(item);
				transaction.setTranxType(0);
				flag = new TranxDao().InsertTranx(transaction, balance);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Index.html");
		}

	}

}
