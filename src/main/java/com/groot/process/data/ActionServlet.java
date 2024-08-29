package com.groot.process.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=req.getParameter("action");
		if(action.equals("update")) {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phonenumber = req.getParameter("phoneNumber");
			String password = req.getParameter("password");

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Connection conn = FactoryOfConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("update firstservlet set name=?,email=?,phoneNumber=? where SN=?");
				ps.setString(1, name);
				ps.setString(3, phonenumber);
				ps.setString(2, email);
				ps.setString(4, req.getParameter("sn"));

				int count = ps.executeUpdate();
				if (count == 0) {
				resp.sendRedirect("./viewData?message=Please check record exsit "+req.getParameter("sn"));
				} else {
					resp.sendRedirect("./viewData?message=recored update "+req.getParameter("sn"));
//					resp.sendRedirect("index2.html");
				}

			} catch (SQLException e) {
				pw.println(e.getMessage());
				e.printStackTrace();

			} catch (Exception ex) {
				pw.println(ex.getMessage());
				ex.printStackTrace();
			}

			pw.close();
		}
	}
}
