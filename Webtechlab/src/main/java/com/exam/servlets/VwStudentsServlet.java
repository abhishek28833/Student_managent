package com.exam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudentsServlet")
public class VwStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/exam";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "aslu2883";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            rs = stmt.executeQuery(sql);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>View Students</title>");
            out.println("<style>");
            out.println("table {");
            out.println("    width: 100%;");
            out.println("    border-collapse: collapse;");
            out.println("}");
            out.println("table, th, td {");
            out.println("    border: 1px solid black;");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 10px;");
            out.println("    text-align: left;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #f2f2f2;");
            out.println("}");
            out.println("tr:hover {");
            out.println("    background-color: #f5f5f5;");
            out.println("    cursor: pointer;");
            out.println("}");
            out.println(".button-container {");
            out.println("    margin-top: 20px;");
            out.println("}");
            out.println(".button-container button {");
            out.println("    background-color: #4CAF50;");
            out.println("    color: white;");
            out.println("    padding: 10px 20px;");
            out.println("    border: none;");
            out.println("    text-decoration: none;");
            out.println("    cursor: pointer;");
            out.println("    margin-right: 10px;");
            out.println("}");
            out.println(".button-container button:hover {");
            out.println("    background-color: #45a049;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Student Details</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Roll Number</th>");
            out.println("<th>Email</th>");
            out.println("<th>DOB</th>");
            out.println("<th>Eligibility Criteria</th>");
            out.println("</tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rollNumber = rs.getString("roll_number");
                String email = rs.getString("email");
                String dob = rs.getDate("dob").toString();
                String eligibilityCriteria = rs.getString("eligibility_criteria");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + rollNumber + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + dob + "</td>");
                out.println("<td>" + eligibilityCriteria + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<div class=\"button-container\">");
            out.println("<button onclick=\"window.location.href='index.html'\">Back to Home</button>");
            out.println("<button onclick=\"window.location.href='updateStudent.html'\">Update Student</button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
