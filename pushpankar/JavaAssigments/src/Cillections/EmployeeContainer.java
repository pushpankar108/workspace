package Cillections;

import java.util.Scanner;
import java.util.*;

public class EmployeeContainer {
	public static void main(String [] args){
		
		Scanner sc1=new Scanner(System.in);
		boolean Flag=true;
		int ch=0;
		HashSet<Employee> e1=new HashSet<Employee>();
		/**
		 * menu for choice
		 */
		while(Flag) {
			System.out.println("press 1 to add employee");
			System.out.println("press 2 to delete employee");
			System.out.println("press 3 to search and view");
			System.out.println("press 4 to display all or view all");
			
			System.out.println("Enter your choice:");
			sc1=new Scanner(System.in);
			if(sc1.hasNextInt()) {
				ch=sc1.nextInt();
				Flag=false;
			}
			else {
				System.out.println("Enter only numbers");
				Flag=true;
				continue;
			}
			
			switch (ch) {
			/**
			 * case 1 is for
			 * adding unique elements
			 */
			case 1:System.out.println("Adding employee..");
			
				int empno=0;
				String ename=null;
				String job=null;
				Scanner sc2=new Scanner(System.in);
				System.out.println("Enter number of employee");		
				sc2=new Scanner(System.in);
				if(sc2.hasNextInt()) {
					empno=sc2.nextInt();	
				}
				else {
					System.err.println("Enter only numbers");
						
				}
				Scanner sc3=new Scanner(System.in);
				System.out.println("Enter name of employee");		
				sc3=new Scanner(System.in);
				if(sc3.hasNextLine()) {
					ename=sc3.nextLine();
						
				}
				else {
					System.err.println("Enter name only");
						
				}
				System.out.println("Enter job of employee");		
				sc3=new Scanner(System.in);
				
				if(sc3.hasNextLine()) {
					job=sc3.nextLine();
						
				}
				else {
					System.err.println("Enter string only");
					
					}
				
				Employee emp=new Employee(empno,ename,job);
				//checking for existing employee in set
				if(e1.add(emp))
				{
					System.out.println(emp.empno+""+emp.ename+""+emp.job);
				}
				else{
					System.out.println("Employee already exists in set");
				
				}
			Flag=true;
			break;
			/**
			 * case 2 is for
			 * search empno in the Set, if empno is found the employee object has to be removed
			 */
			case 2:System.out.println("Enter empnum to remove employee");
			System.out.println("Enter number of employee");	
			Scanner sc=new Scanner(System.in);
			sc=new Scanner(System.in);
			if(sc.hasNextInt()) {
				int empno1=sc.nextInt();	
				for(Employee e2:e1){
					if(e2.getEmpno()==empno1)
					{
						e1.remove(e2);
						
					}
					else 
						System.out.println("sorry ....Employee not found");
				}
					
				}
			
			else {
				System.err.println("Enter only numbers");
					
			}
			Flag=true;
			break;
			/**case 3 is for:
			 * search for empno in the Set, if empno is found, the employee details has to be  displayed , otherwise it should display “Sorry! Employee is not found”.
			 */
			case 3:
				System.out.println("Enter empnum to be searched for employee");
				System.out.println("Enter number of employee");	
				Scanner sc4=new Scanner(System.in);
				sc4=new Scanner(System.in);
				if(sc4.hasNextInt()) {
					int empno1=sc4.nextInt();	
					for(Employee e2:e1){
						if(e2.getEmpno()==empno1)
						{
							System.out.println(e2.empno+" "+e2.ename+" "+e2.job);
							
						}
						else 
							System.out.println("Employee not found");
					}
						
					}
				
				else {
					System.err.println("Enter only numbers");
						
				}
				Flag=true;
				break;
				/**
				 * case 4 is:
				 * if set is not empty then print all
				 */
			case 4:if(!e1.isEmpty()){
				for(Employee e2:e1){
					System.out.println(e2.empno+" "+e2.ename+" "+e2.job);
				}
				
					
				}
				else
					System.out.println("Set is empty");
				Flag=true;
				break;
				/**
				 * case 5 for exiting from menu
				 */
			case 5:
				System.out.println("Exiting the menu");
				Flag=false;
				break;
			default:
				System.out.println("Enter valid input choice");
				Flag=true;
				break;
			}
			}
				
	}

}
