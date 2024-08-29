package com.groot.process.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
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
			con = FactoryOfConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			PreparedStatement ps = con.prepareStatement("delete from firstservlet where SN=?");
			ps.setInt(1,Integer.parseInt(request.getParameter("id")));
			int i=ps.executeUpdate();
			 
			  
			 
			if(i>0) {
				out.println();
				out.print("hello hjvcbdhjv");
//				response.sendRedirect("./view");
			}
		}catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 

}