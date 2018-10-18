package com.fsoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.dao.AccountDao;
import com.fsoft.entities.Account;

/**
 * Servlet implementation class ChangePassWordController
 */
@WebServlet("/change-pass")
public class ChangePassWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDao accountDao = new AccountDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/changepassword.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = req.getParameter("user_name");
		
		String newpass = req.getParameter("new_pass");
		
		try {
			req.setAttribute("balanceValue",accountDao.selectAccountByName(userName));
			 req.setAttribute("listAccount",accountDao.getListAccount());
			accountDao.changePass(newpass,userName);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/welcome.jsp").forward(req,resp);
	}

}
