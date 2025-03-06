package controller;

import dao.*;
import model.*;
import java.math.BigDecimal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDao adao = new AccountDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("action");
		System.out.println(path);
		if(path.equals("login")) {
			String accountNumber = request.getParameter("account_number");
			String password = request.getParameter("password");
            int accountId = adao.getAccountID(accountNumber);
			if(adao.validateAccount(accountId, password)) {
				 HttpSession session = request.getSession();
		         session.setAttribute("accountNumber", accountNumber);
		         session.setAttribute("accountId",accountId);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("options.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h1>Error</h1>");
		        out.println("</body></html>");

		        out.close();
			}
		}
		else if(path.equals("register")) {
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String amount = request.getParameter("initial_deposit").trim();
			BigDecimal initialDeposit = new BigDecimal(amount);
			Account account = new Account(firstName,lastName,email,password,initialDeposit);
			if(adao.createAccount(account)) {
				response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h1>Account Created Successfully!!!</h1>");
		        out.println("<button onclick=\"window.location.href='login.jsp';\">Go to Login Page</button>");
		        out.println("</body></html>");

		        out.close();
			}
			
		}
	}

}
