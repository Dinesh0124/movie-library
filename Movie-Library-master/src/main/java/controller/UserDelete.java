package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
@WebServlet("/deleteuser")
public class UserDelete extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int id=Integer.parseInt(req.getParameter("id"));
	 Dao dao=new Dao();
	 try {
		dao.deleteuser(id);
		req.setAttribute("user", dao.findbyEmailForUser1());
		RequestDispatcher rd=req.getRequestDispatcher("UserDetails.jsp");
		rd.include(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
}
