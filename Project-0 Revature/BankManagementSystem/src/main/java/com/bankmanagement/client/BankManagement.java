package com.bankmanagement.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankManagement {
	private static Logger log = Logger.getLogger(EmplyoeeMain.class);
		static Scanner sc=new Scanner(System.in);
		public static void main(String args[]) {
			log.info("**********/----Welcome to the Bank Management System---/***********");
			while(true) {
			System.out.println("1. New Employee");
			System.out.println("2. Existing Employee");
			System.out.println("3. New Customer");
			System.out.println("4. Existing Customer");
			System.out.println("Enter your choice:");
	        int input=sc.nextInt();
	        sc.nextLine();
	        switch(input) {
	        case 1:
	        	EmplyoeeMain.newMain();
	        	break;
	        case 2:
	        	EmplyoeeMain.existingMain();
	        	break;
	        case 3:
	        	CustomerMain.newCustomer();
	        	break;
	        case 4:
	        	CustomerMain.existingCustomer();
	        	break;
	
	        default:
	        	log.warn("Please enter correct choice!");
	        	break;
	        }
	}	
}
}