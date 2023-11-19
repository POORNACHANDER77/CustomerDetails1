package customer1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class CustomerDetailsDisplay
 */
public class CustomerDetailsDisplay extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailsDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptst=con.prepareStatement("select * from customerdetails");
			ResultSet rs=ptst.executeQuery();
			   ResultSetMetaData rm=rs.getMetaData();
			   PrintWriter pw=response.getWriter();
			                  int n=rm.getColumnCount();
			   pw.println("<html><body><center>");
			   pw.println("     <h1> CustomerDetails</h1>");
			   
			   pw.println("<table border=1 frame='box'>");
			   pw.println("<tr>");
			   for(int i=1;i<=n;i++)
			   {
				 pw.println("<th>"+rm.getColumnName(i)+"</th>");  
			   }
			   pw.println("<th>Action</th>");
			   pw.println("<th>Action</th>");
			   pw.println("<th>Action</th>");
			   pw.println("</tr>");
			  
			   while(rs.next())
			   {
				   pw.println("<tr>");
				   pw.println("<td>"+rs.getString(1)+"</td>");
				   pw.println("<td>"+rs.getString(2)+"</td>");
				   pw.println("<td>"+rs.getString(3)+"</td>");
				   pw.println("<td>"+rs.getString(4)+"</td>");
				   pw.println("<td>"+rs.getString(5)+"</td>");
				   pw.println("<td>"+rs.getString(6)+"</td>");
				   pw.println("<td>"+rs.getString(7)+"</td>");
				   pw.println("<td>"+rs.getString(8)+"</td>");
				   pw.println("<td><a href='AddCustomer.html'>Insert</a></td>");
				   pw.println("<td><a href='DeleteCustomerDetails.html'>Delete</a></td>");
				   pw.println("<td><a href='UpdateCustomer.html'>Update</a></td>");
				   
				   pw.println("</tr>");
			   }
			  
			   pw.println("</table>");
			   pw.println("</center></body></html>");
			   
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
