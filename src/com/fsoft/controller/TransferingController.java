package com.fsoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.dao.AccountDao;
import com.fsoft.dao.TransferDao;
import com.fsoft.entities.Account;

/**
 * Servlet implementation class TransferingController
 */
@WebServlet("/transfering")
public class TransferingController extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
   /* public TransferingController() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    AccountDao accountDao = new AccountDao();
    TransferDao transferDao = new TransferDao();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String userName= ((Account) req.getAttribute("account")).getAccount();
		String userName = req.getParameter("userName");
		try {
			//req.removeAttribute("balanceValue");
			req.setAttribute("balanceValue",accountDao.selectAccountByName(userName));
			 req.setAttribute("listAccount",accountDao.getListAccount());
			// req.setAttribute("listTransfer",transferDao.showAllTransaction());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  //req.getSession().setAttribute("account", account);
		req.getRequestDispatcher("/views/welcome.jsp").forward(req, resp);
  	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
