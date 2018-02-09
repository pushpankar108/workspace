package Datatypes;
import java.util.Scanner;
/**
 * @author pushpankar
 * date 03/01/2018
 * 
 * find sum of all five digits until single single digit sum is found
 *  and find reverse of number
 * 
 *
 */

public class SumInSindig {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=0;
		System.out.println("Enter five digit number of ur choice");
		/**
		 * nput validation
		 */
		
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
		 * checking number is of five digit or not
		 */
		if(num>9999&&num<100000)
		{
		System.out.println("Enter number for occurance check:");
		int orc=s.nextInt();
		int rem;int count=0;
		int rem1;
		while(num>9)//to find sum in single digit
		{
			int sum=0;
			/**
			 * find sum and again finding sum until single digit
			 */
			while(num>0){
				rem=num%10;
				rem1=rem;
				sum=sum+rem1;
				num=num/10;
				if(rem==orc)//checking occurrence of specified digit in given fiver digit number 
					count++;	
				}
		num=sum;
	}
		System.out.println("Single digit sum is:"+num);
		
		if(count>0)
			System.out.println(" Number occures "+count+ "times");
		else
			System.out.println("Does not occures");

}
		else
			System.out.println("Out of range");
}
}