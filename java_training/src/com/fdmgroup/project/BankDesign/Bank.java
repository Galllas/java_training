package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the Bank Design for Java Week 1, which simulates a bank can maintain and manipulate customers and accounts data.
 * Two abstract classes Customer and Account are created to track IDs, keep fundamental variables;
 * Customer has customer ID, name, address and taxId, can deposit and withdraw money, as well as correct balance;
 * Account has account ID, customer ID, balance, interest rate for savings accounts, and checking number for checking accounts.
 * AcocuntBasic and CustomerBasic interfaces are provided to maintain basic methods;
 * BusinessAccount and PersonalAccount are extended from AccountBasic and implemented by checking and saving accounts
 * Company and Person are extended from CustomerBasic and implemented by business and personal customers
 * Company can add same amount to all accounts, while person can reset the accounts balance to 0.
 * Two enums are created to hold customer and account types information separately.
 * 
 * @author gang.zhao, September 3, 2015
 *
 */


public class Bank {
	
	private String Name;
	
	/**
	 *  Use HashMap to associate customer IDs and customers, as well as account IDs and accounts,
	 * 	provide O(1) access to customer or account information when given customer ID or account ID.
	 * @return
	 */
	
	private Map<Integer, Company> companies = new HashMap<Integer, Company>();
	private Map<Integer, Person> persons = new HashMap<Integer, Person>();
	private Map<Integer, BusinessAccount> businessAccounts = new HashMap<Integer, BusinessAccount>();
	private Map<Integer, PersonalAccount> personalAccounts = new HashMap<Integer, PersonalAccount>();
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public Map<Integer, Company> getCompanies() {
		return companies;
	}

	public Map<Integer, Person> getPersons() {
		return persons;
	}

	public Map<Integer, BusinessAccount> getBusinessAccounts() {
		return businessAccounts;
	}

	public Map<Integer, PersonalAccount> getPersonalAccounts() {
		return personalAccounts;
	}

	
	/**
	 * This function can add customer to the bank given type of the customer, name, address and TaxID.
	 * @param typename  "BUSINESS" or "PERSONAL"
	 * @param name      customer name
	 * @param address   customer address 
	 * @param taxId     customer TaxID
	 */
	
	public void addCustomer(String typename, String name, String address, String taxId){
		CustomerType type = CustomerType.valueOf(typename);
		
		switch(type){
		case BUSINESS:
			Company customerB = new BusinessCustomer(name, address, taxId);
			companies.put(customerB.getCustomerId(), customerB);
			break;
		case PERSONAL:
			Person customerP = new PersonalCustomer(name, address, taxId);			
			persons.put(customerP.getCustomerId(), customerP);			
			break;
		}
	}
	
	/**
	 * This function can add account to customer when given type of the account, customer ID and initial balance.
	 * @param typename    "CHECKING" or "SAVINGS"
	 * @param customerId  the owner ID of the account
	 * @param balance     initial balance of the account
	 */
	
	public void addAccount(String typename, int customerId, BigDecimal balance){
		AccountType type = AccountType.valueOf(typename);
		if (companies.containsKey(customerId)){
		switch(type){
		case CHECKING:
			BusinessAccount accountC = new CheckingAccount(customerId, balance);
			businessAccounts.put(accountC.getAccountId(), accountC);
			companies.get(customerId).addAccountId(accountC.getAccountId());
			break;
		case SAVINGS:
			BusinessAccount accountS = new SavingsAccount(customerId, balance);
			businessAccounts.put(accountS.getAccountId(), accountS);
			companies.get(customerId).addAccountId(accountS.getAccountId());
			break;
		}
		}
		else if (persons.containsKey(customerId)){
			switch(type){
			case CHECKING:
				PersonalAccount accountC = new CheckingAccount(customerId, balance);
				personalAccounts.put(accountC.getAccountId(), accountC);
				persons.get(customerId).addAccountId(accountC.getAccountId());
				break;
			case SAVINGS:
				PersonalAccount accountS = new SavingsAccount(customerId, balance);
				personalAccounts.put(accountS.getAccountId(), accountS);
				persons.get(customerId).addAccountId(accountS.getAccountId());
				break;
			}	
		}
	}
	
	public void withdrawMoney(int accountId, BigDecimal amount){
		if (businessAccounts.containsKey(accountId))
		{
			businessAccounts.get(accountId).withdrawMoney(amount);
	    }
		else if (personalAccounts.containsKey(accountId))
		{
			personalAccounts.get(accountId).withdrawMoney(amount);
		}
	}
	
	public void depositMoney(int accountId, BigDecimal amount){
		if (businessAccounts.containsKey(accountId))
		{
			businessAccounts.get(accountId).depositMoney(amount);
	    }
		else if (personalAccounts.containsKey(accountId))
		{
			personalAccounts.get(accountId).depositMoney(amount);
		}
	}
	
	public void correctBalance(int accountId, BigDecimal amount){
		if (businessAccounts.containsKey(accountId))
		{
			businessAccounts.get(accountId).setBalance(amount);
	    }
		else if (personalAccounts.containsKey(accountId))
		{
			personalAccounts.get(accountId).setBalance(amount);
		}
	}

	public void requestCheck(int accountId, int amount){
		if( businessAccounts.containsKey(accountId) && businessAccounts.get(accountId) instanceof CheckingAccount){
			((CheckingAccount) businessAccounts.get(accountId)).requestCheck(amount);
		}
		else if (personalAccounts.containsKey(accountId) && personalAccounts.get(accountId) instanceof CheckingAccount){
			((CheckingAccount) businessAccounts.get(accountId)).requestCheck(amount);			
		}
	}	
	
	public void setInterestRate(int accountId, Number amount){
		if (businessAccounts.containsKey(accountId) && businessAccounts.get(accountId) instanceof SavingsAccount){
			((SavingsAccount)businessAccounts.get(accountId)).setInterestRate(amount);
		}
		else if (personalAccounts.containsKey(accountId) && personalAccounts.get(accountId) instanceof SavingsAccount){
			((SavingsAccount)businessAccounts.get(accountId)).setInterestRate(amount);			
		}
	}		
	
	public void depositAllAcounts(int customerId, BigDecimal amount){
		if (companies.containsKey(customerId)){
			companies.get(customerId).depositAllAcounts(this, amount);
		}
	}		

	public void resetAllAccounts(int customerId){
		if (persons.containsKey(customerId)){
			persons.get(customerId).resetAllAccounts(this);
		}
	}	
	
	public void removeCustomer(int customerId){
		if (companies.containsKey(customerId)){
			for (int accountId : companies.get(customerId).getAccountIds()){
				businessAccounts.remove(accountId);
			}
			companies.remove(customerId);
		}
		else if (persons.containsKey(customerId)){
			for (int accountId : persons.get(customerId).getAccountIds()){
				personalAccounts.remove(accountId);
			}
			persons.remove(customerId);			
		}
	}
	

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
		
		for (Company customer : bank.companies.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
		
		for (Person customer : bank.persons.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
	
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (BusinessAccount account : bank.businessAccounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}
		
		for (PersonalAccount account : bank.personalAccounts.values()){
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
		bank.depositAllAcounts(2000000, BigDecimal.valueOf(1000));
		bank.resetAllAccounts(2000007);
		bank.removeCustomer(2000014);
		bank.withdrawMoney(1000, BigDecimal.valueOf(3000));

		System.out.println(" ");
		System.out.println("Customers in the bank:");
		
		
		for (Company customer : bank.companies.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
		
		for (Person customer : bank.persons.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
	
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (BusinessAccount account : bank.businessAccounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}
		
		for (PersonalAccount account : bank.personalAccounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}
			
		

	}
}
