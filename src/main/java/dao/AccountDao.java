package dao;

import model.*;
import java.math.BigDecimal;
import java.sql.*;

public class AccountDao {
	private final String URL = "jdbc:mysql://127.0.0.1:3306/bank";
	private final String USER_NAME = "root";
	private final String PASSWORD = "30113011@JSV";
	
	
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
	
	public boolean createAccount(Account account) {
		String query = "INSERT INTO account (first_name,last_name,email,password,balance) VALUES (?,?,?,?,?)";
		String firstName = account.getFirstName();
		String lastName = account.getLastName();
		String email = account.getEmail();
		String password = account.getPassword();
		BigDecimal deposit = account.getBalance();
		boolean isSuccess = false;
		try(Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setString(1,firstName);
			pstm.setString(2, lastName);
			pstm.setString(3, email);
			pstm.setString(4, password);
			pstm.setBigDecimal(5, deposit);
			isSuccess = pstm.executeUpdate()>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean validateAccount(int accountId,String password) {
		boolean isSuccessful = false;
		String query = "SELECT password FROM account WHERE account_id=?";
		try(Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setInt(1, accountId);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				String realPassword = rs.getString("password");
				if(realPassword.equals(password)) {
					return true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return isSuccessful;
	}
	
	
	
	public boolean updateAccount(Account account,String accountNumber) {
		String query = "UPDATE account SET first_name=?,last_name=?,email=?,password=? WHERE account_number=?";
		String firstName = account.getFirstName();
		String lastName = account.getLastName();
		String email = account.getEmail();
		String password = account.getPassword();
		boolean isSuccess = false;
		try(Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setString(1,firstName);
			pstm.setString(2, lastName);
			pstm.setString(3, email);
			pstm.setString(4, password);
			pstm.setString(5, accountNumber);
			isSuccess = pstm.executeUpdate()>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public int getAccountID(String accountNumber) {
		String query = "SELECT account_id FROM account WHERE account_number=?";
		int accountId = -1;
		try(Connection connection = getConnection();
				PreparedStatement pstm = connection.prepareStatement(query)){
				pstm.setString(1,accountNumber);
				ResultSet rs = pstm.executeQuery();
				if(rs.next()) {
					accountId=rs.getInt("account_id");
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return accountId;
	}
	
	public String getAccountNumber(int accountId) {
		String query = "SELECT account_number FROM account WHERE account_id=?";
		
		try(Connection connection = getConnection();
				PreparedStatement pstm = connection.prepareStatement(query)){
				pstm.setInt(1,accountId);
				ResultSet rs = pstm.executeQuery();
				if(rs.next()) {
					return rs.getString("account_number");
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean updateBalance(String accountNumber,double balance) {
		boolean isSuccess = false;
		int accountId = getAccountID(accountNumber);
		String query = "UPDATE account SET balance=? WHERE account_id=?";
		try(Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setInt(2,accountId);
			pstm.setDouble(1,balance);
			isSuccess = pstm.executeUpdate()>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public double getBalance(String accountNumber) {
		String query = "SELECT balance FROM account WHERE account_id=?";
		double balance = -1;
		int accountId = getAccountID(accountNumber);
		try(Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setInt(1,accountId);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				balance = rs.getDouble("balance");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	
	
}
