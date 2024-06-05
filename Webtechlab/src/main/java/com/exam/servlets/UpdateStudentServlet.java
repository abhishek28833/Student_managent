package com.exam.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/exam";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "aslu2883";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement pstmt = null;

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String rollNumber = request.getParameter("rollNumber");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String eligibilityCriteria = request.getParameter("eligibilityCriteria");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            StringBuilder sql = new StringBuilder("UPDATE students SET ");
            if (name != null && !name.isEmpty()) sql.append("name=?, ");
            if (rollNumber != null && !rollNumber.isEmpty()) sql.append("roll_number=?, ");
            if (email != null && !email.isEmpty()) sql.append("email=?, ");
            if (dob != null && !dob.isEmpty()) sql.append("dob=?, ");
            if (eligibilityCriteria != null && !eligibilityCriteria.isEmpty()) sql.append("eligibility_criteria=?, ");
            sql.deleteCharAt(sql.length() - 2); // Remove last comma
            sql.append("WHERE id=?");

            pstmt = conn.prepareStatement(sql.toString());

            int index = 1;
            if (name != null && !name.isEmpty()) pstmt.setString(index++, name);
            if (rollNumber != null && !rollNumber.isEmpty()) pstmt.setString(index++, rollNumber);
            if (email != null && !email.isEmpty()) pstmt.setString(index++, email);
            if (dob != null && !dob.isEmpty()) pstmt.setString(index++, dob);
            if (eligibilityCriteria != null && !eligibilityCriteria.isEmpty()) pstmt.setString(index++, eligibilityCriteria);
            pstmt.setInt(index, Integer.parseInt(id));

            int row = pstmt.executeUpdate();
            if (row > 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Student updated successfully!');");
                out.println("location='index.html';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error updating student!');");
                out.println("location='index.html';");
                out.println("</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error: " + e.getMessage() + "');");
            out.println("location='index.html';");
            out.println("</script>");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
