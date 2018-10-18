package com.fsoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.dao.AccountDao;
import com.fsoft.dao.TransferDao;
import com.fsoft.entities.Account;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	AccountDao accountDao = new AccountDao();
	TransferDao transferDao = new TransferDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    Account account = new Account(username, password);
    
    
    try {
      if (accountDao.checkLogin(account)) {
    	
    	  req.setAttribute("balanceValue",accountDao.selectAccountByName(username));
    	  req.getSession().setAttribute("account", account);
    	  req.setAttribute("listAccount",accountDao.getListAccount());
    	  req.getRequestDispatcher("/views/welcome.jsp").forward(req, resp);
    	  
      } else {
        req.setAttribute("error", "Incorrect");
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        
      }
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
}
