package com.groot.process.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con = DBOperation.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			PreparedStatement ps= con.prepareStatement("select * from firstservlet where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.print(" <form action='./ActionServlet?action=update' method='post'>");
					out.println("<input type='text' placeholder='Name' name='name' value="+rs.getString("name")+" required>\r\n"
							+ "            <input type='text' placeholder='Email'  value="+rs.getString("email")+"  name='email' required>\r\n"
									+ "            <input type='hidden' value="+id+"  name='sn' required>\r\n"
							+ "            <input type='password' placeholder='Password' disabled value="+rs.getString("password")+"  name='password' required>\r\n"
							+ "            <input type='text' placeholder='Phone Number'  value="+rs.getString("phoneNumber")+"  name='phoneNumber' required>\r\n"
							+ "            <input type='submit' value='Submit'>");
				out.print("</form>");
			}else {
				out.print("record doesnot exist");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
