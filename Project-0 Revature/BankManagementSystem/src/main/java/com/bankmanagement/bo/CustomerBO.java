package com.bankmanagement.bo;

import java.util.List;

import com.bankmanagement.bankmanagement.Customer;

public interface CustomerBO {
		public int newCustomer(Customer cust);
		public List<Customer> existingCustomer(long CustomerAccountNumber);
		public int depoist(long customerAccountNumber,double currentAmount,double creditedAmount);
		public int withdraw(long customerAccountNumber,double currentAmount,double debitedAmount);
		public int transfer(long customerAccountNumber,double currentAmount,double debitedAmount,long transaccno,double transcurramount, double transcred);
}
