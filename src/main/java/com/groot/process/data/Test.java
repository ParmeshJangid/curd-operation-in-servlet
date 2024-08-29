package com.groot.process.data;
import java.sql.Connection;

public class Test {
		public static void main(String[] args) {
		Connection conn=	FactoryOfConnection.getConnection();
		 if (conn != null) {
	            System.out.println("Connection established successfully!");
	        } else {
	            System.out.println("Failed to establish connection.");
	        }
		}
}