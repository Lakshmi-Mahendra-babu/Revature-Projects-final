package com.bankmanagement.bo;

import java.util.List;

import com.bankmanagement.bankmanagement.Customer;
import com.bankmanagement.dao.CustomerDAO;
import com.bankmanagement.dao.CustomerDAOImp;

public class CustomerBOImplementation implements CustomerBO{

	@Override
	public int newCustomer(Customer cust) {
		// TODO Auto-generated method stub
		CustomerDAO udao=new CustomerDAOImp();
		int status =udao.newCustomer(cust);
		return status;
	}

	@Override
	public List<Customer> existingCustomer(long customerAccountNumber) {
		// TODO Auto-generated method stub
		CustomerDAO udao=new CustomerDAOImp();
		List<Customer> status=udao.existingCustomer(customerAccountNumber);
		return status;
	}

	@Override
	public int depoist(long customerAccountNumber, double currentAmount, double creditedAmount) {
		// TODO Auto-generated method stub
		CustomerDAO udao=new CustomerDAOImp();
		int status =udao.depoist(customerAccountNumber, currentAmount, creditedAmount);
		return status;
	}

	@Override
	public int withdraw(long customerAccountNumber, double currentAmount, double debitedAmount) {
		// TODO Auto-generated method stub
		CustomerDAO udao=new CustomerDAOImp();
		int status =udao.withdraw(customerAccountNumber, currentAmount, debitedAmount);
		return status;
	}

	@Override
	public int transfer(long customerAccountNumber, double currentAmount, double debitedAmount, long transaccno,
			double transcurramount, double transcred) {
		// TODO Auto-generated method stub
		CustomerDAO udao=new CustomerDAOImp();
		int status =udao.transfer(customerAccountNumber, currentAmount, debitedAmount, transaccno, transcurramount, transcred);
		return status;
	}
	

}
