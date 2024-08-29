package com.groot.process.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register2")
public class RagisterServlet2 extends HttpServlet {

	private static final String INSERT_QUERY = "INSERT INTO firstservlet (name, phoneNumber, email, password) VALUES (?, ?, ?, ?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			ps.setString(1, name);
			ps.setString(2, phonenumber);
			ps.setString(3, email);
			ps.setString(4, password);

			int count = ps.executeUpdate();
			if (count == 0) {
				System.out.print("Record not inserted");
			} else {
				pw.println("Record stored into Database");
				resp.sendRedirect("index2.html");
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	}
}