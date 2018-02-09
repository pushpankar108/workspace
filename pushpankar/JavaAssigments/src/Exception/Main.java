package Exception;

import java.util.Scanner;
/**
 * @author pushpankar
 * date 5/01/2018
 * it allows to create only single object,
 *  if there is an attempt  to create another object ,  it should throw an exception.
 *
 */

public class Main {

	public static void main(String[] args){
		System.out.println("Enter 1 to enter object");
		boolean x=true;
		
		Scanner sc=new Scanner(System.in);
		int ch=0;
		
		
		while(x){
			System.out.println("Enter 1 to continue and add object..... or 2 exit.... ");
			if(!sc.hasNextInt()){
			    System.out.println("Not an int ... enter an integer");
			System.exit(0);
			}
			else
			{
				 ch= sc.nextInt();
			   
			}
			/**
			 * create menu
			 * first option shows connection
			 * because of single ton class next object creation shows handeled error
			 */
			
			switch (ch) {
			/**
			 * add object once
			 */
			case 1:
				DbConnection connection;
				try {
					connection = DbConnection.getObject();
					System.out.println(connection);

				} catch (MoreThanOneObjectException e) {
					System.out.println(e.getMessage());
				}
				x=true;
				break;
			case 2:x=false;//exit 
			System.out.println(("Bey Bey .. exiting from menu"));
			break;

			default:
				System.out.println("enter valid value");
				x=true;
				break;
			}


		}
	}

}

