package com.fsoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.dao.TransferDao;
import com.fsoft.entities.Account;
import com.fsoft.entities.Transfer;

/**
 * Servlet implementation class DeleteRowHistoryController
 */
@WebServlet("/delete-row")
public class DeleteRowHistoryController extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRowHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    TransferDao transferDao = new TransferDao();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String userName = req.getParameter("userName");
		//Account acc = (Account)req.getAttribute("account");
		try {
			transferDao.deleteRowHistory(id);
			List<Transfer> listTransfer = new ArrayList<>();
			listTransfer = transferDao.showAllTransaction(userName);
			req.setAttribute("listTransfer", listTransfer);
			req.getRequestDispatcher("/views/transferhistory.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
