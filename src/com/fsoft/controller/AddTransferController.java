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
import com.fsoft.entities.Transfer;

/**
 * Servlet implementation class AddTransferController
 */
@WebServlet("/add-transfer")
public class AddTransferController extends HttpServlet {
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransferController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long amount = Long.parseLong(req.getParameter("amount"));
		String accountReceive = req.getParameter("account_receive");
		String note = req.getParameter("note");
		//Account acc = (Account)req.getAttribute("account"); 
		String accountTransfer = req.getParameter("account_transfer");
		String userName = req.getParameter("userName");
		TransferDao transferDao = new TransferDao();
		AccountDao accountDao = new AccountDao();
		try {
			accountDao.updateBalance(amount,accountTransfer);
			accountDao.updateBalance((-amount),accountReceive);
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		Transfer transfer = new Transfer(amount,note,accountReceive,accountTransfer);
		try {
			transferDao.insertTransfer(transfer);
			
			req.setAttribute("message", "Successfully!");
			req.setAttribute("listTransfer",transferDao.showAllTransaction(userName));
			req.getRequestDispatcher("/views/transferhistory.jsp").forward(req, resp);
			//resp.sendRedirect(req.getContextPath() + "/home");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
}
}
