package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the Bank Design for Java Week 1, which simulates a bank can maintain and manipulate customers and accounts data.
 * Two abstract classes Customer and Account are created to track IDs, keep fundamental variables and methods;
 * Customer has customer ID, name, address and taxId, can deposit and withdraw money, as well as correct balance;
 * Account has account ID, customer ID, balance, interest rate for savings accounts, and checking number for checking accounts.
 * One interface is used to give different accounts manipulation methods with different types of customers,
 * Business customer can add same amount to all accounts, while personal customer can reset the accounts balance to 0.
 * Two enums are created to hold customer and account types information separately.
 * 
 * @author gang.zhao, August 30, 2015
 *
 */


public class Bank {
	
	private String Name;
	
	/**
	 *  Use HashMap to associate customer IDs and customers, as well as account IDs and accounts,
	 * 	provide O(1) access to customer or account information when given customer ID or account ID.
	 * @return
	 */
	
	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	private Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Map<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Integer, Customer> customers) {
		this.customers = customers;
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * This function can add customer to the bank given type of the customer, name, address and TaxID.
	 * @param typename  "BUSINESS" or "PERSONAL"
	 * @param name      customer name
	 * @param address   customer address 
	 * @param taxID     customer TaxID
	 */
	
	public void addCustomer(String typename, String name, String address, String taxID){
		CustomerType type = CustomerType.valueOf(typename);
		
		switch(type){
		case BUSINESS:
			Customer customerB = new BusinessCustomer(name, address, taxID);
			customers.put(customerB.getCustomerId(), customerB);
			break;
		case PERSONAL:
			Customer customerP = new PersonalCustomer(name, address, taxID);			
			customers.put(customerP.getCustomerId(), customerP);			
			break;
		}
	}
	
	/**
	 * This function can add account to customer when given type of the account, customer ID and initial balance.
	 * @param typename    "CHECKING" or "SAVINGS"
	 * @param customerID  the owner ID of the account
	 * @param balance     initial balance of the account
	 */
	
	public void addAccount(String typename, int customerID, BigDecimal balance){
		AccountType type = AccountType.valueOf(typename);
		
		switch(type){
		case CHECKING:
			Account accountC = new CheckingAccount(customerID, balance);
			accounts.put(accountC.getAccountId(), accountC);
			customers.get(customerID).addAccountId(accountC.getAccountId());
			break;
		case SAVINGS:
			Account accountS = new SavingsAccount(customerID, balance);
			accounts.put(accountS.getAccountId(), accountS);
			customers.get(customerID).addAccountId(accountS.getAccountId());
			break;
		}
	}
	
	public void withdrawMoney(int accountID, BigDecimal amount){
		accounts.get(accountID).withdrawMoney(amount);
	}
	
	public void depositMoney(int accountID, BigDecimal amount){
		accounts.get(accountID).depositMoney(amount);
	}
	
	public void correctBalance(int accountID, BigDecimal amount){
		accounts.get(accountID).setBalance(amount);
	}

	public void requestCheck(int accountID, int amount){
		if(accounts.get(accountID) instanceof CheckingAccount){
		((CheckingAccount)accounts.get(accountID)).requestCheck(amount);
		}
	}	
	
	public void setInterestRate(int accountID, Number amount){
		if (accounts.get(accountID) instanceof SavingsAccount){
		((SavingsAccount)accounts.get(accountID)).setInterestRate(amount);
		}
	}		
	
//	public void resetAccounts(int customerID, BigDecimal amount){
//		customers.get(customerID).resetAcounts(this, amount);
//	}		
	
	public void removeCustomer(int customerID){
		for (int accountID : customers.get(customerID).getAccountIds()){
			accounts.remove(accountID);
		}
		customers.remove(customerID);
	}
	
//	PersonalAccount psa = new CheckingAccount(0, null);
//	psa.resetAllAccounts();


	/**
	 * The front door of the bank.
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		//welcome to the bank
		System.out.println("****************************************************");		
		System.out.println("*++++++++         +       ++         ++ ++       ++*");
		System.out.println("*++      ++      +++      ++++       ++ ++     ++  *");
		System.out.println("*++      ++     ++ ++     ++ ++      ++ ++   ++    *");
		System.out.println("*++++++++++    +++++++    ++   ++    ++ ++ ++      *");
		System.out.println("*++      ++   ++     ++   ++     ++  ++ ++   ++    *");
		System.out.println("*++      ++  ++       ++  ++       ++++ ++     ++  *");
		System.out.println("*++++++++   ++         ++ ++         ++ ++       ++*");
		System.out.println("****************************************************");
		
		
		System.out.println(" ");

		
		//Hard code test cases for BankDesign Package
		
		Bank bank = new Bank();		

		//Add customers to bank
		
		bank.addCustomer("BUSINESS", "Facebook", "CA", "1234");
		bank.addCustomer("PERSONAL", "Ned", "NY", "123456");
		bank.addCustomer("BUSINESS", "Google", "CA", "1235");
		
		//Add accounts to customers

		bank.addAccount("CHECKING", 2000000, BigDecimal.valueOf(50000));
		bank.addAccount("SAVINGS", 2000000, BigDecimal.valueOf(20000));
		bank.addAccount("SAVINGS", 2000007, BigDecimal.valueOf(2000));
		bank.addAccount("CHECKING", 2000007, BigDecimal.valueOf(5000));
		bank.addAccount("CHECKING", 2000014, BigDecimal.valueOf(50000));
		
		
		System.out.println("Customers in the bank:");
		
		for (Customer customer : bank.customers.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
	
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (Account account : bank.accounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}
				
		// Data manipulation test cases 
		System.out.println(" ");
		System.out.println("Test Cases:");
		System.out.println("1. Set the interest rate of 1005 to 0.1");
		System.out.println("2. Set the balance of 1000 to 60000");
		System.out.println("3. Deposit 10000 to 1000");
		System.out.println("4. Request 100 checks from 1000");
		System.out.println("5. Set the interest rate of 1005 to 0.1");
		System.out.println("6. Add 1000 to all the accounts of a business customer or set all the accounts to 0 if a personal customer");
		System.out.println("7. Add 1000 to all the accounts of a business customer or set all the accounts to 0 if a personal customer");
		System.out.println("8. Remove customer 2000014 from the bank");
		System.out.println("9. Withdraw 3000 from account 1000");

		bank.setInterestRate(1005, 0.1);
		bank.correctBalance(1000, BigDecimal.valueOf(60000));
		bank.depositMoney(1005, BigDecimal.valueOf(10000));
		bank.requestCheck(1000, 100);
//		bank.resetAccounts(2000000, BigDecimal.valueOf(1000));
//		bank.resetAccounts(2000007, BigDecimal.valueOf(1000));
		bank.removeCustomer(2000014);
		bank.withdrawMoney(1000, BigDecimal.valueOf(3000));

		System.out.println(" ");
		System.out.println("Customers in the bank:");
		
		for (Customer customer : bank.customers.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
	
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (Account account : bank.accounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}	
		

	}
}
