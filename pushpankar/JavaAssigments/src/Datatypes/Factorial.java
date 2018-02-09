package Datatypes;

import java.util.Scanner;
/**
 * 
 * @author pushpankar kumar
 * date 03/01/2018
 *  Find  factorial of given number
 *
 */
public class Factorial {

	public static void main(String[] args) {
		int fact=1;
		int num=0;
		Scanner s=new Scanner(System.in);
		/**
		 * validate foe inputs type also
		 */
		System.out.println("Enter user input for factorial");
		if(s.hasNextInt()){
			num=s.nextInt();
			}
		else{
			System.out.println("Enter valid integer  bey bey try again");
			System.exit(0);
			}
		if(num<0){
			System.out.println("Enter a positive number bey bey try again");
			System.exit(0);
		}
		/**
		 * Calculating factorial
		 */
		while(num>0)
		{
			if(num>0){
				fact=fact*num;
				num--;
			}
			
		}
		System.out.println("Factorial is:"+fact);
	
	}

}
