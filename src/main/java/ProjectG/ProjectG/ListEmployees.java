package ProjectG.ProjectG;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListEmployees
 */
@WebServlet(name = "listemployees", urlPatterns = { "/listemployees" })
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "password");
			
			//Inserting data into database
			String inserQuery = "INSERT INTO employees VALUES(?, ?, ?, ?, ?)";
			PreparedStatement prptInsert = cnn.prepareStatement(inserQuery);
			prptInsert.setInt(1, 15);
			prptInsert.setString(2, "dummy user");
			prptInsert.setString(3, "dummy user");
			prptInsert.setInt(4, 25);
			prptInsert.setDouble(5, 23000);
			prptInsert.execute();
			System.out.println("----Insert Query Executed----");
			
			//Reading data from database
			String query = "SELECT * FROM employees";
			PreparedStatement prpt = cnn.prepareStatement(query);
			ResultSet results = prpt.executeQuery();
			while (results.next()) {
				System.out.println(results.getString("first_name"));
			}
			
			//Updating first name of the user
			
			String updateQuery = "UPDATE employees SET first_name = ? WHERE id = ?";
			PreparedStatement prptUpdate = cnn.prepareStatement(updateQuery);
			prptUpdate.setString(1, "SERVLETS");
			prptUpdate.setInt(2, 15);
			prptUpdate.execute();
			System.out.println("----Updated user in the date base----");
			
			
			//Deleting user
			
			String deleteQuery = "DELETE FROM employees WHERE id = ?";
			PreparedStatement prptDelete = cnn.prepareStatement(deleteQuery);
			prptDelete.setInt(1, 15);
			prptDelete.execute();
			System.out.println("---User Deleted--");
			
			
			cnn.close();
			prptInsert.close();
			prpt.close();
			prptUpdate.close();
			prptDelete.close();
			results.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
