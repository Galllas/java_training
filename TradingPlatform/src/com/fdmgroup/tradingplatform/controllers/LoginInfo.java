package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.bin.EntityFactory;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;


/**
 * Servlet implementation class LoginInfo
 */
public class LoginInfo extends HttpServlet {
	
	private LogRAMDAO logRAMDAO = new LogRAMDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginInfo() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Person person = new Person();
		person.setUserName(username);
		person.setPassword(password);
		
		//emf = EntityFactory.getInstance();
//		logRAMDAO.setEmf(EntityFactory.getInstance());
//		Person person = logRAMDAO.read(username);
		
//		if (person == null || !person.getPassword().equals(password)){
//			
//			String error = "Wrong Username or Password!";
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Logfail");
//			dispatcher.forward(request, response);
//		}
//		else 
//		{
			request.setAttribute("person", person);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Logsuccess");
			dispatcher.forward(request, response);
//		}
//		
	}

}
