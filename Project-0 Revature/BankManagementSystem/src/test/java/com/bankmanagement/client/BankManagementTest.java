package com.bankmanagement.client;

import org.junit.Assert;
import org.junit.Test;

import com.bankmanagement.bankmanagement.Customer;
import com.bankmanagement.bankmanagement.Employee;
import com.bankmanagement.dao.CustomerDAOImp;
import com.bankmanagement.dao.EmployeeDAOImplementation;


public class BankManagementTest {
	CustomerDAOImp e=new CustomerDAOImp();
	@Test
	public void testDeposit() {		
		Assert.assertEquals(1,e.depoist(1, 500, 1000));
	}
	@Test
	public void testNewCustomer() {
		Customer cust=new Customer();
				Assert.assertNotEquals(1,e.newCustomer(cust));
	}
	@Test
	public void testExistingCustomer() {
		Assert.assertNotEquals(1,e.existingCustomer(1));
	}
	@Test
	public void testWithdraw() {
		Assert.assertEquals(1,e.withdraw(2,1000, 200));
	}
	@Test
	public void test() {
		Customer cu=new Customer();
		cu.getCurrentAmount();
		Assert.assertEquals(1,e.newCustomer(cu));
	}
}
