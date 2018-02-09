package Datatypes;

import java.util.Scanner;  
/**
 * @author spaneos
 * date 03/01/2018
 * find even number below a given number
 * handel diffrent types of inputs
 */
public class Even {
public static void main(String []args)
{
	Scanner s=new Scanner (System.in);
	int num=0;
	System.out.println("Enter number of ur choice");
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
	int n=1;
	if(num==1){
		System.out.println("No even numbers below 1");
	}
	else{
		System.out.println("even numbers below -> "+num+"are :");
	while(n<=num){
		if(n%2==0)
			System.out.println(n);
		n++;
	}
	}
}

}
