package Cillections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PhonebookClient {
	public static void main(String []argh)
	{
		String phno=null;
		String name=null;

		PhoneBook book=new PhoneBook();

		boolean flag=true;

		while(flag) {
			Map<String,String> map1=new HashMap<>();
			int ch=0;
			System.out.println("Enter 1 to add");
			System.out.println("Enter 2 to search name");
			System.out.println("Enter 3 to exit");
			Scanner sc=new Scanner(System.in);
			if(sc.hasNextInt()) {
				ch=sc.nextInt();
				flag=true;
			}
			else {
				System.err.println("Enter only numbers");
				flag=true;
				continue;
			}
			Scanner sc1=new Scanner(System.in);
			switch(ch){
			
			case 1:
				System.out.println("Enter number ");
				if(sc.hasNextLine()) {
					
					phno = sc1.nextLine();	
					flag=false;
				}
				else {
					System.err.println("Enter valid number");
					flag=true;
					continue;
				}
				
				System.out.println("Enter name ");
				if(sc.hasNextLine()) {
					name = sc1.nextLine();	
					
				
					flag=true;
				}
				else {
					System.out.println("Enter valid name");
					flag=true;
					continue;
				}
				//map1.get(phno);
				book.addDetails(phno,name);
				flag=true;
				break;
			case 2:
				System.out.println("Enter number to be searched");
				sc=new Scanner(System.in);
				if(sc.hasNextLine()) {
					phno = sc.nextLine();	
					flag=true;
					//map1.get(phno);
					book.getName(phno);
				}
				else {
					System.out.println("Enter valid number");
					flag=true;
					continue;
				}
				book.getName(phno);
				flag =true;
				break;
			case 3:
				System.out.println("Stop .......");
				System.exit(0);
				flag=false;
						break;
			default :
				System.out.println("Enter valid input");
				break;

			}	
		}
	}
}
