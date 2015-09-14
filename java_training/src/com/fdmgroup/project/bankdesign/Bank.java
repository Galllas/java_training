package com.fdmgroup.project.bankdesign;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the Bank Design for Java Week 1, which simulates a bank can maintain and manipulate customers and accounts data.
 * Two abstract classes Customer and Account are created to track IDs, keep fundamental variables;
 * Customer has customer ID, name, address and taxId, can deposit and withdraw money, as well as correct balance;
 * Account has account ID, customer ID, balance, interest rate for savings accounts, and checking number for checking accounts.
 * BasicAcocunt and BasicCustomer interfaces are provided to maintain basic methods;
 * BusinessAccount and PersonalAccount are extended from AccountBasic and implemented by checking and saving accounts
 * Company and Person are extended from CustomerBasic and implemented by business and personal customers
 * Company can add same amount to all accounts, while person can reset the accounts balance to 0.
 * Two enums are created to hold customer and account types information separately.
 * 
 * @author gang.zhao, September 3, 2015
 *
 */


public class Bank {
	
	private String name;
	
	private static int INITIAL_CUSTOMERID = 2000000;
	private int customerIdIncrement = 7;
	private static int customerId = INITIAL_CUSTOMERID;

	private static int INITIAL_ACCOUNTID = 1000;
	private int accountIdIncrement = 5;
	private static int accountId = INITIAL_ACCOUNTID;	
	
	private void generateNextCustomerId(){
		customerId += customerIdIncrement;
	}
	
	private void generateNextAccountId(){
		accountId += accountIdIncrement;
	}
	
	/**
	 *  Use HashMap to associate customer IDs and customers, as well as account IDs and accounts,
	 * 	provide O(1) access to customer or account information when given customer ID or account ID.
	 * @return
	 */
	
	private Map<Integer, BasicCustomer> customers = new HashMap<Integer, BasicCustomer>();
	private Map<Integer, BasicAccount> accounts = new HashMap<Integer, BasicAccount>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Map<Integer, BasicCustomer> getCustomers() {
		return customers;
	}

	public Map<Integer, BasicAccount> getAccounts() {
		return accounts;
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
			Company customerB = new BusinessCustomer(customerId, name, address, taxId);
			customers.put(customerB.getCustomerId(), customerB);
			this.generateNextCustomerId();
			break;
		case PERSONAL:
			Person customerP = new PersonalCustomer(customerId, name, address, taxId);			
			customers.put(customerP.getCustomerId(), customerP);	
			this.generateNextCustomerId();			
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
		
		switch(type){
		case CHECKING:
			BusinessAccount accountC = new CheckingAccount(customerId, accountId, balance);
			accounts.put(accountC.getAccountId(), accountC);
			customers.get(customerId).addAccountId(accountC.getAccountId());
			this.generateNextAccountId();
			break;
		case SAVINGS:
			BusinessAccount accountS = new SavingsAccount(customerId, accountId, balance);
			accounts.put(accountS.getAccountId(), accountS);
			customers.get(customerId).addAccountId(accountS.getAccountId());
			this.generateNextAccountId();
			break;
		}
	}
	
	public void withdrawMoney(int accountId, BigDecimal amount){
		accounts.get(accountId).withdrawMoney(amount);
	}
	
	public void depositMoney(int accountId, BigDecimal amount){
		accounts.get(accountId).depositMoney(amount);			
	}
	
	public void correctBalance(int accountId, BigDecimal amount){
		accounts.get(accountId).setBalance(amount);
	}

	public void requestCheck(int accountId, int amount){
		if( accounts.containsKey(accountId) && accounts.get(accountId) instanceof CheckingAccount){
			accounts.get(accountId).requestCheck(amount);
		}
	}	
	
	public void setInterestRate(int accountId, Number amount){
		if (accounts.containsKey(accountId) && accounts.get(accountId) instanceof SavingsAccount){
			accounts.get(accountId).setInterestRate(amount);
		}
	}		
	
	public void depositAllAcounts(int customerId, BigDecimal amount){
		customers.get(customerId).depositAllAcounts(this, amount);
	}		

	public void resetAllAccounts(int customerId){
		customers.get(customerId).resetAllAccounts(this);
	}	
	
	public void removeCustomer(int customerId){
		for (int accountId : customers.get(customerId).getAccountIds()){
			accounts.remove(accountId);
		}
		customers.remove(customerId);
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
		
		for (BasicCustomer customer : bank.customers.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
		
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (BasicAccount account : bank.accounts.values()){
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
		
		
		for (BasicCustomer customer : bank.customers.values()){
		System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getAddress() + " " + customer.getTaxId() + " " +customer.getClass());
		}
	
		System.out.println(" ");
		
		System.out.println("Accounts information of the customers:");
		
		for (BasicAccount account : bank.accounts.values()){
			if (account instanceof SavingsAccount){
		System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((SavingsAccount)account).getInterestRate() + " "+account.getClass());
		}
			else{
				System.out.println(account.getCustomerId() + " " + account.getAccountId() + " " + account.getBalance() + " " +((CheckingAccount)account).getNextCheck() + " "+account.getClass());	
			}
		}
		
			
		

	}
}





//
//
//
//
//
//public int selectOperation(){
//	
//	String[] operationType = {"Add Business Customer", "Add Personal Customer", "Add Business Checking Account", 
//			"Add Business Savings Account", "Add Personal Checking Account", "Add Personal Savings Account", "Query Customer",
//			"Remove Customer", "Business Customer Add All", "Personal Customer Reset All", "Show All Accounts", "Query Account",
//			"Account Deposit", "Account Withdraw", "Account Correction", "Checking Account Order Check", "Checking Account Next Check", 
//			"Savings Account Change Saving Rate"};	
//	
//	String option = (String) JOptionPane.showInputDialog(null,
//	"Would you like to add Customer or Account?",
//	Name,
//	JOptionPane.QUESTION_MESSAGE,
//	null,     
//	operationType,  
//	operationType[0]); 
//	
//	return Arrays.asList(operationType).indexOf(option);
//}
//
//
//public String getInput(){
//	
//	  JTextField xField = new JTextField(10);
//
//      JPanel myPanel = new JPanel();
//      myPanel.add(new JLabel("Value"));
//      myPanel.add(xField);    
//
//      int result = JOptionPane.showConfirmDialog(null, myPanel, 
//               "Please Enter Value", JOptionPane.OK_CANCEL_OPTION);
//	
//      return xField.getText();
//}
////
////
//public String[] getCustomer(){
//	
//	  JTextField xField = new JTextField(10);
//      JTextField yField = new JTextField(10);
//      JTextField zField = new JTextField(10);
//
//      JPanel myPanel = new JPanel();
//      myPanel.add(new JLabel("Name:"));
//      myPanel.add(xField);
//      myPanel.add(Box.createVerticalStrut(15)); // a spacer
//      myPanel.add(new JLabel("Address:"));
//      myPanel.add(yField);
//      myPanel.add(Box.createVerticalStrut(15)); // a spacer
//      myPanel.add(new JLabel("TaxID:"));
//      myPanel.add(zField);	      
//
//      int result = JOptionPane.showConfirmDialog(null, myPanel, 
//               "Please Enter Customer Values", JOptionPane.OK_CANCEL_OPTION);
////      if (result == JOptionPane.OK_OPTION) {
////         System.out.println("x value: " + xField.getText());
////         System.out.println("y value: " + yField.getText());
////      }	
//      
//      String[] inputs = {xField.getText(), yField.getText(), zField.getText()};
////      System.out.println(inputs);
//      return inputs;
//     
//}
//
//

//Bank bank = new Bank();
//bank.setBank();
//
//int option = 0;
//
//while (option != -1){
//
//option = bank.selectOperation();
//
//switch (option) {
//	
//case 0: String[] v0 = bank.getCustomer();
//		bank.addBusinessCustomer(v0[0], v0[1], v0[2]);
//		JOptionPane.showMessageDialog (null, "Business Customer Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 1: String[] v1 = bank.getCustomer();
//		bank.addPersonalCustomer(v1[0], v1[1], v1[2]);
//		JOptionPane.showMessageDialog (null, "Personal Customer Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 2: String c2 = bank.getInput();
//		String v2 = bank.getInput();
//		int id2 = Integer.parseInt(c2);
//		BigDecimal b2=new BigDecimal(v2);
//		Account a2 = new CheckingAccount(b2);
//		Customer cu2 = bank.getCustomer(id2);
//		cu2.Accounts.add(a2);
//		JOptionPane.showMessageDialog (null, "Account Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 3: String c4 = bank.getInput();
//		String v4 = bank.getInput();
//		int id4 = Integer.parseInt(c4);
//		BigDecimal b4=new BigDecimal(v4);
//		Account a4 = new SavingsAccount(b4);
//		Customer cu4 = bank.getCustomer(id4);
//		cu4.Accounts.add(a4);
//		JOptionPane.showMessageDialog (null, "Account Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;		
//case 4: String c5 = bank.getInput();
//		String v5 = bank.getInput();
//		int id5 = Integer.parseInt(c5);
//		BigDecimal b5=new BigDecimal(v5);
//		Account a5 = new CheckingAccount(b5);
//		Customer cu5 = bank.getCustomer(id5);
//		cu5.Accounts.add(a5);
//		JOptionPane.showMessageDialog (null, "Account Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 5: String c6 = bank.getInput();
//		String v6 = bank.getInput();
//		int id6 = Integer.parseInt(c6);
//		BigDecimal b6=new BigDecimal(v6);
//		Account a6 = new SavingsAccount(b6);
//		Customer cu6 = bank.getCustomer(id6);
//		cu6.Accounts.add(a6);
//		JOptionPane.showMessageDialog (null, "Account Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;					
//case 6: String c7 = bank.getInput();
//		int id7 = Integer.parseInt(c7);
//		String info7 = bank.getCustomerinfo(id7);
//		JOptionPane.showMessageDialog (null, info7, "Information", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 7: String c8 = bank.getInput();
//		int id8 = Integer.parseInt(c8);
//		bank.removeCustomer(id8);
//		JOptionPane.showMessageDialog (null, "Customer Removed", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 8: String c9 = bank.getInput();
//		String v9 = bank.getInput();
//		int id9 = Integer.parseInt(c9);
//		BigDecimal b9=new BigDecimal(v9);				
//		Customer cu9 = bank.getCustomer(id9);
//		if ( cu9 instanceof BusinessCustomer ){
//		((BusinessCustomer) cu9).addMoney(b9);
//		}		
//		JOptionPane.showMessageDialog (null, "All Account Added", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 9: String c10 = bank.getInput();
//		int id10 = Integer.parseInt(c10);				
//		Customer cu10 = bank.getCustomer(id10);
//		if ( cu10 instanceof PersonalCustomer ){
//			((PersonalCustomer) cu10).resetBalance();
//		}		
//		JOptionPane.showMessageDialog (null, "All Balances Reseted", "Title", JOptionPane.INFORMATION_MESSAGE);
//		break;
//case 10: bank.getAccounts();
//		 JOptionPane.showMessageDialog (null, Arrays.toString(bank.Accounts.toArray()), "Title", JOptionPane.INFORMATION_MESSAGE);
//		 break;
//case 11: String c12 = bank.getInput();
//		 int id12 = Integer.parseInt(c12);
//		 String info12 = bank.getAccountinfo(id12);
//		 JOptionPane.showMessageDialog (null, info12, "Title", JOptionPane.INFORMATION_MESSAGE);
//		 break;				 
////case 12: String c13 = bank.getInput();
////		 String v13 = bank.getInput();
////		 int id13 = Integer.parseInt(c13);
////		 BigDecimal b13=new BigDecimal(v13);				
////		 Account cu13= bank.getAccount(id13);
//
//
//
//
//
//	}
//
//
//	}
//
//JOptionPane.showMessageDialog (null, "Closed", bank.Name, JOptionPane.INFORMATION_MESSAGE);




