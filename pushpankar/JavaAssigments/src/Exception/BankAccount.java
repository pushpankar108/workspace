package Exception;

import java.util.Scanner;

public class BankAccount {
	int accNo;
	String custName;
	String accType;
	float balance;
	
	/**
	 * @param accNo
	 * @param custName
	 * @param accType
	 * @param balance
	 */
	public BankAccount(int accNo, String custName, String accType, float balance) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.accType = accType;
		this.balance = balance;
	}
	public static void main(String []args){
		int accNo=0;
		boolean flag=true;
	/**
	 * Account details;
	 */
		System.out.println("Enter acc number");
	Scanner sc=new Scanner(System.in);
	if(sc.hasNextInt()) {
		accNo=sc.nextInt();
		
	}
	else {
		System.err.println("Enter valid acc number");
		System.exit(0);
		
	}
	String custName=null;
	String accType=null;
	float balance=0;
	Scanner sc2=new Scanner(System.in);
	System.out.println("Enter Customer name");
	if(sc2.hasNextLine()) {
		custName=sc2.nextLine();
		
	}
	else {
		System.err.println("Enter  name as only string");
		System.exit(0);
		
	}
	Scanner sc3=new Scanner(System.in);
	System.out.println("Enter Account type");
	if(sc3.hasNextLine()) {
		accType=sc3.nextLine();
		if(accType.equalsIgnoreCase("saving")||accType.equalsIgnoreCase("current")){
			System.out.println("Valid account type");
		}
		else{System.err.println("Enter valid account type");
			System.exit(0);}
	}
	else {
		System.err.println("Enter Valid Type  system exit");
		System.exit(0);
		
	}
	
	System.out.println("Enter initial ammount");
	Scanner sc4=new Scanner(System.in);
	if(sc4.hasNextFloat()) {
		balance=sc4.nextFloat();
		
	}
	else {
		System.err.println("Enter float only");
		System.exit(0);
		
	}
	while(flag){
		int ch=0;
		/**
		 * menu
		 */
		System.out.println("Enter ur Transection mode type");
		System.out.println("Enter 1 for Deposit");
		System.out.println("Enter 2 for withdrow");
		System.out.println("Enter 3 for Balance");
		System.out.println("Enter 4 to exit");
		Scanner sc5=new Scanner(System.in);
		System.out.println("enter ur choice");
		if(sc5.hasNextInt()) {
			ch=sc5.nextInt();
			
		}
		else {
			System.err.println("Enter Number  only");
			flag=true;
			continue;
			
		}
		BankAccount b=new BankAccount(accNo, custName, accType, balance);
		switch(ch){
		
		case 1:
			/**
			 * deposit amount
			 */
			Scanner sc6=new Scanner(System.in);
			System.out.println("Enter  ammount to be deposited");
			float deposit=0;
			if(sc6.hasNextFloat()) {
				deposit=sc6.nextFloat();
				
			}
			else {
				System.err.println("Enter float only");
				flag=true;
				continue;
			}
			balance=b.deposit(deposit);
			
			flag=true;
			break;
			
		case 2:
			/**
			 * Withdrow ammount
			 */
			Scanner sc7=new Scanner(System.in);
			System.out.println("Enter  ammount ");
			float amt=0;
			if(sc7.hasNextFloat()) {
				amt=sc7.nextFloat();
				
			}
			else {
				System.err.println("Enter float only");
				flag=true;
				continue;
			}
			balance=b.withdrow(amt);
			System.out.println("Available balance is"+balance);
			flag=true;
			break;
		case 3:
			/**
			 * Balance enquary
			 */
			balance=b.getBalance();
			System.out.println("Available balannce"+balance);
			
			flag=true;
			break;
		case 4:
			/**
			 * exit menu
			 */
			System.out.println("Bey bey....");
			flag=false;
			continue;
		default :
			System.out.println(" Enter relevent input");
			flag=true;
			break;
			
			
		}
		
		
	}
	
}	
	/**
	 * check for negative deposit
	 * @param amt
	 * @return
	 */
	float deposit(float amt){
		
		if(amt>0){
			balance=balance+amt;
			System.out.println("balance is :"+balance);
			return balance;
		}
		else{
		try {
			throw new  NegativeAmmountException("Negative ammount not allowed");
		}
		catch (NegativeAmmountException e) {
			System.out.println(e.getMessage());
		}
		
	}
		return balance;
	}
	/**
	 * withdrow money and check for:
	 * negative ammount withdrowl
	 * withdrow more than available balance
	 * create exception class for above
	 * 
	 * @param amt
	 * @return
	 */
	float withdrow(float amt){
		
			if(accType.equalsIgnoreCase("Saving")){
				if(amt>0){
				
					if(balance>amt){
						balance=balance-amt;
						if(balance>1000)
						{
							System.out.println("balance is :"+balance);
							return balance;
						}
						else 
						{
							try {
								throw new InsufficentFundException("Insufficent found less then 1000");	
							}
							catch (InsufficentFundException e) {
								System.out.println(e.getMessage());
								}
					
						}return balance;
					}
				
				else 
				{
					try {
						throw new InsufficentFundException("Insufficent found ammount not allowed please add money");	
					}
					catch (InsufficentFundException e) {
						System.out.println(e.getMessage());
						}
				}
				
			}
				else 
				{
					try {
						throw new NegativeAmmountException("Insufficent found ammount not allowed please add money");	
					}
					catch (NegativeAmmountException e) {
						System.out.println(e.getMessage());
						}
				}
				
		}
			else if(accType.equalsIgnoreCase("current")){
				if(amt>0){
					
					if(balance>amt){
						balance=balance-amt;
						if(balance>5000)
						{
							System.out.println("balance is :"+balance);
						}
						else 
						{
							try {
								throw new InsufficentFundException("Insufficent found less then 1000");	
							}
							catch (InsufficentFundException e) {
								System.out.println(e.getMessage());
								}
					
						}
					}
				
				else 
				{
					try {
						throw new InsufficentFundException("Insufficent found ammount not allowed please add money");	
					}
					catch (InsufficentFundException e) {
						System.out.println(e.getMessage());
						}
				}
				
			}
				else 
				{
					try {
						throw new NegativeAmmountException("Insufficent found ammount not allowed please add money");	
					}
					catch (NegativeAmmountException e) {
						System.out.println(e.getMessage());
						}
				}
				
		}
				
	
			else{
				System.err.println("Enter valid account type");System.exit(0);
			}return balance;
	}
	/**
	 * check balance for valid account type 
	 * @return
	 */
	float getBalance()
	{
		if(accType.equalsIgnoreCase("Saving")){
			if(balance>=1000)
			{
				float f=balance;
			}
			else{
			try {
				throw new InsufficentFundException("Insufficent found ammount not allowed (less than 1000)please add money");	
			}
			catch (InsufficentFundException e) {
				System.out.println(e.getMessage());
				}
		}
		}
		else if(accType.equalsIgnoreCase("Current")){
			if(balance>=5000)
			{
				float f=balance;
			}
			else 
			{
				try {
					throw new InsufficentFundException("Insufficent found ammount not allowed (less than 1000)please add money");	
				}
				catch (InsufficentFundException e) {
					System.out.println(e.getMessage());
					}	
			}
		}
		else{
			System.err.println("Enter valid account type");System.exit(0);
		}
			
			return balance;

}
}

	