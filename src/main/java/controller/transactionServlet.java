package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.RequestDispatcher;
import java.util.List;
import dao.*;
/**
 * Servlet implementation class transactionServlet
 */
@WebServlet("/transactionServlet")
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	TransactionDao tdao = new TransactionDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionServlet() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("action");
		System.out.println(path);
		
		switch(path) {
			case "deposit":
				RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("deposit.jsp");
				requestDispatcher1.forward(request, response);
				break;
			case "withdraw":
				RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("withdraw.jsp");
				requestDispatcher2.forward(request, response);
				break;
			case "transfer":
				RequestDispatcher requestDispatcher3 = request.getRequestDispatcher("transfer.jsp");
				requestDispatcher3.forward(request, response);
				break;
			case "transactions":
				HttpSession session = request.getSession();
				int accountId = (Integer)session.getAttribute("accountId");
				List<String> transactions = tdao.getAllTransactions(accountId);
				request.setAttribute("stringList", transactions);
				RequestDispatcher requestDispatcher4 = request.getRequestDispatcher("transactions.jsp");
				requestDispatcher4.forward(request, response);
				break;
			case "update":
				RequestDispatcher requestDispatcher5 = request.getRequestDispatcher("update.jsp");
				requestDispatcher5.forward(request, response);
				break;
			case "account_details":
				HttpSession session1 = request.getSession();
				String AccountNumber = (String)session1.getAttribute("accountNumber");
				AccountDao adao = new AccountDao();
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
