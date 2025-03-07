package dao;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TransactionDao {
	private static final Logger logger = Logger.getLogger(TransactionDao.class.getName());
	private final String URL = "jdbc:mysql://localhost:3306/bank";
	private final String USER_NAME = "root";
	private final String PASSWORD = "";
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return connection;	
	}
	
	public boolean deposit(int accountId,BigDecimal amount) {
		String insertQuery = "INSERT INTO transactions (account_id,transaction_type,amount,status)"
				+ "VALUES (?,'DEPOSIT',?,'SUCCESS')";
		String updateQuery = "UPDATE account SET balance = balance + ? WHERE account_id=?";
		boolean isSuccessful = false;
		
		try(Connection connection = getConnection();
			PreparedStatement insertStm = connection.prepareStatement(insertQuery);
			PreparedStatement updateStm = connection.prepareStatement(updateQuery)){
			connection.setAutoCommit(false);
			
			updateStm.setBigDecimal(1, amount);
			updateStm.setInt(2,accountId);
			updateStm.executeUpdate();
			
			insertStm.setInt(1,accountId);
			insertStm.setBigDecimal(2, amount);
			insertStm.executeUpdate();
			
			connection.commit();
			isSuccessful=true;
			
		}
		catch(SQLException e) {
			logger.log(Level.SEVERE,"Deposit failed",e);
		}
		
		return isSuccessful;
	}
	
	public boolean withdraw(int accountId,BigDecimal amount) {
		boolean isSuccessful = false;
		String balanceQuery = "SELECT balance FROM account WHERE account_id=?";
		String insertQuery = "INSERT INTO transactions (account_id,transaction_type,status,amount)"
				+ "VALUES (?,'WITHDRAWAL','SUCCESS',?)";
		String updateQuery = "UPDATE account SET balance = balance-? WHERE account_id=?";
		
		try(Connection connection = getConnection();
			PreparedStatement bstm = connection.prepareStatement(balanceQuery);
			PreparedStatement istm = connection.prepareStatement(insertQuery);
			PreparedStatement ustm = connection.prepareStatement(updateQuery)){
			
			connection.setAutoCommit(false);
			
			bstm.setInt(1, accountId);
			ResultSet rs = bstm.executeQuery();
			if(rs.next() && rs.getBigDecimal("balance").compareTo(amount)>=0) {
				
				ustm.setBigDecimal(1,amount);
				ustm.setInt(2,accountId);
				ustm.executeUpdate();
				
				istm.setInt(1,accountId);
				istm.setBigDecimal(2, amount);
				istm.executeUpdate();
				
				connection.commit();
				isSuccessful = true;
			}
			else {
				logger.warning("Insufficient funds for withdrawl");
			}
			
		}
		catch(SQLException e) {
			logger.log(Level.SEVERE,"Withdrawl failed",e);
		}
		return isSuccessful;
	}
	
	public boolean transfer(int fromAccountId,int toAccountId,BigDecimal amount) {
		boolean isSuccessful = false;
		String balance = "SELECT balance FROM account WHERE account_id=?";
		String sentFrom = "UPDATE account SET balance = balance-? WHERE account_id=?";
		String sentTo = "UPDATE account SET balance = balance+? WHERE account_id=?";
		String insert = "INSERT INTO transactions (account_id,from_account_id,to_account_id,"
				+ "amount,transaction_type,status) VALUES(?,?,?,?,'TRANSFER','SUCCESS')";
		
		try(Connection connection  = getConnection();
			PreparedStatement bstm = connection.prepareStatement(balance);
			PreparedStatement sfstm = connection.prepareStatement(sentFrom);
			PreparedStatement ststm = connection.prepareStatement(sentTo);
			PreparedStatement istm = connection.prepareStatement(insert)){
			
			bstm.setInt(1, fromAccountId);
			ResultSet rs = bstm.executeQuery();
			if(rs.next() && rs.getBigDecimal("balance").compareTo(amount)>=0) {
				connection.setAutoCommit(false);
				
				sfstm.setBigDecimal(1, amount);
				sfstm.setInt(2, fromAccountId);
				sfstm.executeUpdate();
				
				ststm.setBigDecimal(1, amount);
				ststm.setInt(2, toAccountId);
				ststm.executeUpdate();
				
				istm.setInt(1, fromAccountId);
				istm.setInt(2, fromAccountId);
				istm.setInt(3, toAccountId);
				istm.setBigDecimal(4, amount);
				istm.executeUpdate();
				
				connection.commit();	
				isSuccessful=true;
			}
			
			else {
				logger.warning("Insufficient Funds!!");
			}
		}
		catch(SQLException e) {
			logger.log(Level.SEVERE,"Money Transfer Failed!!",e);
		}
		
		return isSuccessful;
	}
	
	
	
	public List<String> getAllTransactions(int accountId){
		 List<String> transactions = new ArrayList<>();
	        String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY transaction_date DESC";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	             
	            stmt.setLong(1, accountId);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                transactions.add("Transaction ID: " + rs.getLong("transaction_id") +
	                        ", Type: " + rs.getString("transaction_type") +
	                        ", Amount: " + rs.getBigDecimal("amount") +
	                        ", Status: " + rs.getString("status") +
	                        ", Date: " + rs.getTimestamp("transaction_date"));
	            }
	        } catch (SQLException e) {
	            logger.log(Level.SEVERE, "Error fetching transactions", e);
	        }
	        return transactions;
	}
	
	
	
	
		
}
