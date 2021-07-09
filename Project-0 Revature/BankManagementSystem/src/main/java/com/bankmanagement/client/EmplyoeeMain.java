package com.bankmanagement.client;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankmanagement.bankmanagement.Customer;
import com.bankmanagement.bankmanagement.Employee;
import com.bankmanagement.bo.CustomerBO;
import com.bankmanagement.bo.CustomerBOImplementation;
import com.bankmanagement.bo.EmployeeBO;
import com.bankmanagement.bo.EmployeeBOImplementation;

public class EmplyoeeMain {
	private static Logger log = Logger.getLogger(EmplyoeeMain.class);
	static Scanner sc=new Scanner(System.in);
	public static void newMain() {
	    log.info("If you are new Employee please enter the required details in below:");
		System.out.println("Enter your Name:");
		String uname = sc.nextLine();
		System.out.println("Enter the Password:");
		String upass=sc.nextLine();
		System.out.println("Enter the Mail Id:");
		String umail=sc.nextLine();
		System.out.println("Enter the Mobile Number:");
		long umob=sc.nextLong();
		Employee emp=new Employee();
		emp.setEmployeeName(uname);
		emp.setPassword(upass);
		emp.setMailId(umail);
		emp.setMobileNumber(umob);
		EmployeeBO ubo=new EmployeeBOImplementation();
		int state=ubo.newUser(emp);
		if(state!=0) {
			log.info("Userdetails added successfully");
		}else {
			log.warn("Userdetails Not added successfully");
		}
	}
	public static void existingMain() {
	log.info("If you are existing Employee please login here:");
	System.out.println("Enter Employee Id:");
	int exuid=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the Password:");
	String exupass=sc.nextLine();
	Employee emp=new Employee();
	emp.setEmployeeId(exuid);
	emp.setPassword(exupass);
	String s=null;
	EmployeeBO ubo=new EmployeeBOImplementation();
	List<Employee> lu=ubo.existingEmployee(exuid);
	for(Employee e:lu) {
		s=e.getPassword();
	}
		if(s.equalsIgnoreCase(exupass)) {
			log.info("Employee Login Success!");
			System.out.println("1. See Customer Account Details");
			
			System.out.println("Please enter your choice");
			int cdetails=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Customer Account Number:");
			long caccount = sc.nextLong();
			Customer cust=new Customer();
			cust.setCustomerAccountNumber(caccount);
			CustomerBO cbo=new CustomerBOImplementation();
			List<Customer> lc=cbo.existingCustomer(caccount);
			for(Customer c:lc) {
				String cname=c.getCustomerName();
				double ccamount=c.getCurrentAmount();
		        double ccredit=c.getCreditedAmount();
		        double cdebit=c.getDebitedAmount();
					switch(cdetails) {
					case 1:
						System.out.println("CustomerAccountNumber:"+" "+caccount);
						System.out.println("CustomerName:"+" "+cname);
						System.out.println("CurrentAmount:"+" "+ccamount);
						System.out.println("CreditedAmount:"+" "+ccredit);
						System.out.println("DebitedAmount:"+" "+cdebit);
					    break;
					default:
					    	log.warn("Enter Correct Choice!");
					}
					
			}
		}else {
			log.warn("Employee Login Fail!");
		}
	}			
}
