package com.groot.curd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Process extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		out.print(name+"<br>");
		out.print(email+"<br>");
		out.print(phoneNumber+"<br>");
		out.print(password+"<br>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con =null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
			PreparedStatement ps = con.prepareStatement("INSERT INTO firstservlet (name, phonenumber, email, password) VALUES (?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.setString(3, email);
			ps.setString(4, password);
			int i = ps.executeUpdate();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
