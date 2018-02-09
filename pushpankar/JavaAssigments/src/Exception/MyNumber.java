package Exception;

import java.util.Scanner;

public class MyNumber {
	
	int x,y;
	public MyNumber(int p, int q) {
		x=p;
		y=q;
	}
	int add(){
		return (x+y);
	}
	int sub(){
		return (x-y);
	}
	int mul(){
		return(x*y);
	}
	void div(){
		double z;
		try{
			z=x/y;
			System.out.println("result is "+z);
			
		}
		catch(ArithmeticException e){
			System.out.println("Divided by zero-0 not allowed" +e);
		}
	}
	public static void main(String []args)
	{
		
		double res=0;
		
		boolean x=true;
		Scanner sc=new Scanner(System.in);
		
		while(x==true){
			int p=0;int q=0;int ch=0;
			System.out.println("Menu");
			System.out.println("Enterur choice");
			System.out.println("Enter 1 for add");
			System.out.println("Enter 2 for sub");
			System.out.println("Enter 3 for multiply");
			System.out.println("Enter 4 for divison");
			System.out.println("Enter 5 to exit");
			System.out.println("Enter 6 to continue");

			if(!sc.hasNextInt())
			    System.out.println("Not an int");
			else
			{
				 ch= sc.nextInt();
			   
			   
			}
			
			System.out.println("Enter value of a");
			if(!sc.hasNextInt())
			{
			    System.out.println("Not an int  ..enter an int");
			    x=true;
			    break;
			}
			else
			{
			   p= sc.nextInt();
			}
			System.out.println("enter value of b");
			if(!sc.hasNextInt()){
				
			
			    System.out.println("Not an int ... enter an int");
			    x=true;
			    break;
			}
			else
			{
			   q= sc.nextInt();
			
			}
			
			MyNumber my=new MyNumber(p,q);
			switch(ch){
			case 1:{
			res=my.add();
			System.out.println("Result is a+b:"+res);
				x=true;
				break;
			}
			case 2:{
				res=my.sub();
				System.out.println("Result is a-b:"+res);
					x=true;
					break;
				}
			case 3:{
				res=my.mul();
				System.out.println("Result is a*b:"+res);
					x=true;
					break;
				}
			case 4:{
				my.div();
				
					x=true;
					break;
				}
			case 5:{
				
				System.out.println("exit of operation......");
					x=false;
					break;
				}
			case 6:{
				x=true;
				break;
			}
			default:
				System.out.println("Enter valid value");
				x=true;
				
			
		}

}		
}
}

