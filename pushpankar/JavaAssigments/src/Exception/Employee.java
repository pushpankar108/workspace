package Exception;

import java.util.Scanner;
/**
 * @author pushpankar
 * create object of employee with different given instants
 * handle exception if exprience is less than 2.5 or more than 3.5
 *
 */

public class Employee {
	int enumber=0;
	String ename="\0";
	float eexp=0;
	
	public Employee(int empnumber, String name ,float exp ){
		enumber=empnumber;
		ename=name;
		eexp=exp;
		System.out.println("emp number is:"+enumber+"  name is :"+ename+"  Emp exp is:"+eexp);
		
	
	}
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);

		int num=0;
		float exp=0;
		int ch=0;
		String name=null;
		System.out.println("Enter details");
		System.out.println("emp num is");
		
		/**
		 * Different input validation;
		 * false  input stops execution 
		 */

		if(!sc.hasNextInt()){
		    System.out.println("Not an int ... enter an integer");
		System.exit(0);
		}
		else
		{
			 num= sc.nextInt();
		   
		}
		System.out.println("Enter name");
		if(!sc2.hasNextLine()){
		    System.out.println("Not an int ... enter an string");
		    System.exit(0);
		}
		else
		{
			 name= sc2.nextLine();
		   
		}
		System.out.println("Enter exprience");
		if(!sc.hasNextFloat()){
		    System.out.println("Not an int ... enter an float");
		    System.exit(0);
		}
		else
		{
			 exp= sc.nextFloat();
		   
		}
		/**
		 * checking exprience and throws exception hendaled message
		 * execption is IllegalArgumentException
		 */
		if(exp>2.5 && exp<3.5){
			Employee employee=new Employee(num, name, exp);
		}
		else
		{
			throw new IllegalArgumentException("Exprience:  "+exp+"  is less than 2.5 or morethan 3.5");
		}
		
		
	}

}
