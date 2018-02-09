package Datatypes;

import java.util.Scanner; 
/**
 * 
 * @author pushpankar
 * date 03/01/2018
 * check the given five digit number is palindrom or not
 * and sum of all five digits
 *  and find reverse of number
 *
 */
public class Palindrom {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=0;
		/**
		 * inputs validation
		 */
		System.out.println("Enter ur five digit number");
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
		 * checking input is of five digit or not
		 */
		
		if(num>9999&&num>100000)
		{
		int org=num;
		int rev=0;
		int rem,rem1=0;
		while(num>0){
			rem=num%10;
			rem1=rem+rem1;//sum of five digits
			rev=rev*10+rem;//finding reverse
			num=num/10;
			
		}
		if(rev==org){
			System.out.println("Number is palindrom: "+org);
		}
		else
			System.out.println("Number is not a palindrom: "+org);
		System.out.println("Reverse is :"+rev);
		System.out.println("Sum of numbers are: "+rem1);
		

	}
		else
			System.out.println("Out of range");//if number is not of five digits
		
	}
}
