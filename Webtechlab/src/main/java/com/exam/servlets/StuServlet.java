package com.exam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StuServlet
 */
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // JDBC URL, username, and password of MySQL server
	        String jdbcUrl = "jdbc:mysql://localhost:3306/exam";
	        String dbUser = "root";
	        String dbPassword = "aslu2883";

	        // JDBC variables for opening and managing connection
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        PrintWriter out = response.getWriter();

	        // Parameters obtained from request
	        String name = request.getParameter("name");
	        String rollNumber = request.getParameter("rollNumber");
	        String email = request.getParameter("email");
	        String dob = request.getParameter("dob");
	        String eligibilityCriteria = request.getParameter("eligibilityCriteria");

	        try {
	            // Establish a connection
	            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

	            // Create SQL query
	            String sql = "INSERT INTO students (name, roll_number, email, dob, eligibility_criteria) VALUES (?, ?, ?, ?, ?)";

	            // Create prepared statement
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, name);
	            stmt.setString(2, rollNumber);
	            stmt.setString(3, email);
	            stmt.setString(4, dob);
	            stmt.setString(5, eligibilityCriteria);

	            // Execute the query
	            int rows = stmt.executeUpdate();
	            if (rows > 0) {
//	                response.getWriter().println("Student added successfully!");
	            	out.println("<script type=\"text/javascript\">");
	                out.println("alert('Student added successfully!');");
	                out.println("location='index.html';");
	                out.println("</script>");
	            } else {
//	                response.getWriter().println("Failed to add student.");
	            	out.println("<script type=\"text/javascript\">");
	                out.println("alert('Error adding student!');");
	                out.println("location='index.html';");
	                out.println("</script>");
	            }

	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	            response.getWriter().println("Error: " + ex.getMessage());
	        	ex.printStackTrace();
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Error: " + ex.getMessage() + "');");
	            out.println("location='index.html';");
	            out.println("</script>");
	        } finally {
	            try {
	                // Close connections
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }

}
