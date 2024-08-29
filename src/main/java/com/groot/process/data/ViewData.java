package com.groot.process.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/viewData")
public class ViewData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter object to send the response
        try (PrintWriter out = response.getWriter()) {
            // Write the HTML content to the response
        	if(request.getParameter("message")!=null) {
        		out.print("<b>"+request.getParameter("message")+"</b>");
        	}
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Data Management</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }");
            out.println(".container { width: 80%; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h2 { text-align: center; color: #333; }");
            out.println("table { width: 100%; margin-top: 20px; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }");
            out.println("th { background-color: #4CAF50; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("a { text-decoration: none; color: blue; }");
            out.println(".add-data { display: inline-block; margin-bottom: 20px; padding: 10px 15px; background-color: #4CAF50; color: white; border-radius: 4px; text-align: center; }");
            out.println(".add-data:hover { background-color: #45a049; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Data Management</h2>");
            out.println("<a class='add-data' href='index2.html'>ADD DATA</a>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>City</th>");
            out.println("<th>Mobile</th>");
            out.println("<th>DOB</th>");
            out.println("<th>Update</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");

            // Database operations
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = FactoryOfConnection.getConnection();
                if (con == null) {
                    out.print("Connection is Null...!");
                }
                PreparedStatement ps = con.prepareStatement("select * from firstservlet");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt(1) + "</td>");
                    out.println("<td>" + rs.getString(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(4) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td><a href='./UpdateData?id=" + rs.getInt(1) + "'>Update</a></td>");
                    out.println("<td><a href='./DeleteData?id=" + rs.getInt(1) + "'>Delete</a></td>");
                    out.println("</tr>");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
