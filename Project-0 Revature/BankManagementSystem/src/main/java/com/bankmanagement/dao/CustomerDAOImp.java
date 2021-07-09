package com.bankmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankmanagement.bankmanagement.Customer;
import com.bankmanagement.config.DBConnectionSingleton;

public class CustomerDAOImp implements CustomerDAO{
	Customer cust=new Customer();
	@Override
	public int newCustomer(Customer cust) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			PreparedStatement pstmt=(DBConnectionSingleton.getConnectionInstance())
			.prepareCall("insert into  customer(CustomerName,MailId,MobileNumber,Address,CurrentAmount) values(?,?,?,?,?)");
			pstmt.setString(1, cust.getCustomerName());
			pstmt.setString(2, cust.getMailId());
			pstmt.setLong(3, cust.getMobileNumber());
			pstmt.setString(4, cust.getAddress());
			pstmt.setDouble(5, cust.getCurrentAmount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Customer> existingCustomer(long  customerAccountNumber) {
		// TODO Auto-generated method stub
		List<Customer> listOfemp=null;
		try {
			Statement stmt=(DBConnectionSingleton.getConnectionInstance()).createStatement();

			ResultSet rs = stmt.executeQuery("select * from customer where CustomerAccountNumber="+customerAccountNumber+"");
			listOfemp=new ArrayList<Customer>();
			while(rs.next()) {
			cust.setCustomerAccountNumber(rs.getLong(1));
			cust.setCustomerName(rs.getString(2));	
			cust.setMailId(rs.getString(3));
			cust.setMobileNumber(rs.getLong(4));
			cust.setAddress(rs.getString(5));
			cust.setCurrentAmount(rs.getDouble(6));
			cust.setCreditedAmount(rs.getDouble(7));
			cust.setDebitedAmount(rs.getDouble(8));
			listOfemp.add(cust);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfemp;
	}
	public int depoist(long customerAccountNumber,double currentAmount,double creditedAmount) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			
			Statement stmt1=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			result = stmt1.executeUpdate("update customer set CurrentAmount="+currentAmount+",CreditedAmount="+creditedAmount+" where CustomerAccountNumber="+customerAccountNumber+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int withdraw(long customerAccountNumber,double currentAmount,double debitedAmount ) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			
			Statement stmt2=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			result = stmt2.executeUpdate("update customer set CurrentAmount="+currentAmount+",DebitedAmount="+debitedAmount+" where CustomerAccountNumber="+customerAccountNumber+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int transfer(long customerAccountNumber,double currentAmount,double debitedAmount,long transaccno,double transcurramount, double transcred) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			
			Statement stmt2=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			result = stmt2.executeUpdate("update customer set CurrentAmount="+currentAmount+",DebitedAmount="+debitedAmount+" where CustomerAccountNumber="+customerAccountNumber+"");
		if(result!=0) {
			Statement stmt3=(DBConnectionSingleton.getConnectionInstance()).createStatement();
			result = stmt3.executeUpdate("update customer set CurrentAmount="+transcurramount+",CreditedAmount="+transcred+" where CustomerAccountNumber="+transaccno+"");
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
