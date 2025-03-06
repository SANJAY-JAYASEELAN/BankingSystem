package controller;

import jakarta.servlet.ServletException;
import model.*;
import java.math.BigDecimal;
import dao.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;
//import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class transactionHandlingServlet
 */
@WebServlet("/transactionHandlingServlet")
public class transactionHandlingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDao tdao = new TransactionDao();
	AccountDao adao = new AccountDao();
       
    
    public transactionHandlingServlet() {
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
		String path = request.getParameter("action");
		System.out.println(path);
		if(path.equals("deposit")) {
			String amount = request.getParameter("amount");
			System.out.println(amount);
			BigDecimal deposit = new BigDecimal(amount);
			HttpSession session = request.getSession();
			int accountId = (Integer) session.getAttribute("accountId");
			if(tdao.deposit(accountId, deposit)) {
				PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h1>Amount Deposited Successfully!!</h1>");
		        out.println("<a href='options.jsp'>Back</a>");
		        out.println("</body></html>");

		        out.close();
			}
			else {
				PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h1>Error!!</h1>");
		        out.println("</body></html>");

		        out.close();
			}
		}
		else if(path.equals("withdraw")) {
			String amount = request.getParameter("amount");
			System.out.println(amount);
			BigDecimal deposit = new BigDecimal(amount);
			HttpSession session = request.getSession();
			int accountId = (Integer) session.getAttribute("accountId");
			if(tdao.withdraw(accountId, deposit)) {
				PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h1>Amount Withdrawed Successfully!!</h1>");
		        out.println("<a href='options.jsp'>Back</a>");
		        out.println("</body></html>");

		        out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
		        out.println("<h1>Error!!</h1>");
		        out.println("Not Enough Balance");
		        out.println("</body></html>");
		        out.close();
			}
		}
		else if(path.equals("transfer")) {
			String amount = request.getParameter("amount");
			System.out.println(amount);
			BigDecimal amountToSend = new BigDecimal(amount);
			HttpSession session = request.getSession();
			int fromAccountId = (Integer) session.getAttribute("accountId");
			String receiver = request.getParameter("account_number");
			int toAccountId = adao.getAccountID(receiver);
			if(tdao.transfer(fromAccountId, toAccountId, amountToSend)) {
				PrintWriter out = response.getWriter();
		        out.println("<html><body>");
		        out.println("<h1>Amount Transferred Successfully!!</h1>");
		        out.println("<a href='options.jsp'>Back</a>");
		        out.println("</body></html>");
		        out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
		        out.println("<h1>Error!!</h1>");
		        out.println("Not Enough Balance");
		        out.println("</body></html>");
		        out.close();
			}
		}
		else if(path.equals("update")) {
			String newFirstName = request.getParameter("first_name");
			String newLastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String newPassword = request.getParameter("password");
			HttpSession session = request.getSession();
			String accoundNumber = (String)session.getAttribute("accountNumber");
			Account account = new Account(newFirstName,newLastName,email,newPassword);
			if(adao.updateAccount(account, accoundNumber)) {
				PrintWriter out = response.getWriter();
		        out.println("<html><body>");
		        out.println("<h1>Account Updated Successfully!!</h1>");
		        out.println("<a href='options.jsp'>Back</a>");
		        out.println("</body></html>");
		        out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
		        out.println("<h1>Error!!</h1>");
		        out.println("</body></html>");
		        out.close();
			}
			
		}
		else if(path.equals("account_details")) {
			HttpSession session = request.getSession();
			String AccountNumber = (String)session.getAttribute("accountNumber");
			double balance = adao.getBalance(AccountNumber);
			PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<h2>Account Number: " + AccountNumber + "</h2>");
	        out.println("<h2>Balance: " + balance + "</h2>");
	        out.println("<a href='options.jsp'>Back</a>");
	        out.println("</body></html>");
	        out.close();
		}
	}

}












