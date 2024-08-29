//package com.groot.process.data;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
////@WebServlet("/viewData") 
//public class RegisterData extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // Example: Retrieving form data
//    	String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phoneNumber = request.getParameter("phoneNumber");
//		String password = request.getParameter("password");
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        Connection connection = FactoryOfConnection.getConnection();
//        if (connection != null) {
//        	try {
//    			PreparedStatement ps = connection.prepareStatement("INSERT INTO firstservlet (name, phonenumber, email, password) VALUES (?, ?, ?, ?)");
//    			ps.setString(1, name);
//    			ps.setString(2, phoneNumber);
//    			ps.setString(3, email);
//    			ps.setString(4, password);
//    			int i = ps.executeUpdate();
//                response.getWriter().write("User registered successfully!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                response.getWriter().write("Failed to register user.");
//            }
//        } else {
//            response.getWriter().write("Failed to establish a database connection.");
//        }
//    }
//}
