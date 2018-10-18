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
import javax.servlet.http.HttpSession;

import com.fsoft.dao.TransferDao;
import com.fsoft.entities.Account;
import com.fsoft.entities.Transfer;
@WebServlet ("/show-transfer")
public class TransferController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
	// TODO Auto-generated method stub
	//	Account acc = (Account)req.getAttribute("account");
		TransferDao transferDao = new TransferDao();
		List<Transfer> listTransfer = new ArrayList<>();
		String userName = req.getParameter("userName");
		try {
			listTransfer = transferDao.showAllTransaction(userName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			req.setAttribute("listTransfer", listTransfer);
			req.getRequestDispatcher("/views/transferhistory.jsp").forward(req, resp);
			
		}
}

