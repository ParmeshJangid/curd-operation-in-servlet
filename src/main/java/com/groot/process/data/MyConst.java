package com.groot.process.data;

public class MyConst {
//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "system");
		public final static String  DB_URL="jdbc:mysql://localhost:3306/servlet";
		public final static String  DB_USER_NAME="root";
		public final static String  DB_PASSWORD="system";
		public static final String INSERT_QUERY = "INSERT INTO firstservlet (name, phoneNumber, email, password) VALUES (?, ?, ?, ?)";
}