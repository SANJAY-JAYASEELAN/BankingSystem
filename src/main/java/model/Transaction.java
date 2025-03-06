package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private int accountId;
    private String transactionType; 
    private BigDecimal amount;
    private Integer fromAccountId; 
    private Integer toAccountId;   
    private LocalDateTime transactionDate;
    private String status; 

    // Constructor for Deposits & Withdrawals
    public Transaction(int accountId, String transactionType, BigDecimal amount, String status) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.status = status;
    }

    // Constructor for Transfers
    public Transaction(int fromAccountId, int toAccountId, BigDecimal amount, String status) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.transactionType = "TRANSFER";
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.status = status;
    }

    // Getters and Setters
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // toString method for easy printing
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", transactionDate=" + transactionDate +
                ", status='" + status + '\'' +
                '}';
    }
}