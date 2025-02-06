package ProjectG.ProjectG;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/addemployee")

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the HTML file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addemployee.html");
        dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");

        // Log data (or process it as needed)
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "root", "password");
			System.out.println("connected to database");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Catch block");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Redirect to success.jsp
        //response.sendRedirect("./addemployee");
    }



}
