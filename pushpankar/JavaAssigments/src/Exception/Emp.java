package Exception;

import java.util.Scanner;
/**
 *
 * @author pushpankar kumar
 * create Exception class
 *If designation is “Manager” - HRA will be 10% of BASIC
if designation is “Officer” - HRA will be 12% of BASIC
if category is “CLERK” - HRA will be 5% of BASIC
Have constructor to which you will pass empId, designation, basic and hra.
And check whether the BASIC is less than 500 or not. If it is less than 500 raise a custom exception as given below:
 */
public class Emp {
	int id=0;String Designation=null;double basic=0;double hra=0;
	public Emp(int eid,String designation,double ebasic,double ehra){
		id=eid;
		Designation=designation;
		basic=ebasic;
		hra=ehra;
	}
	
		public void EmpDEt(int eid,String designation,double ebasic,double ehra){
			System.out.println(" Emp details are");
			System.out.println(" Eid:"+eid+"  Designation:"+designation+"  basic:"+ebasic+"  HRA"+ehra);
			
		}
		public static void main(String[] args){
			int id=0;
			String designation=null;
			double ebasic=0;
			double hra=0;
			Scanner sc=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			Scanner sc3=new Scanner(System.in);
			System.out.println("Enter employe detail");
			System.out.println("Enter emp id :");
			if(!sc.hasNextInt()){
			    System.out.println("Not an int ... enter an integer");
			System.exit(0);
			}
			else
			{
				 id= sc.nextInt();
			   
			}
			System.out.println("Enter emp basic :");
			if(!sc2.hasNextDouble()){
			    System.out.println("Not an int ... enter an integer");
			System.exit(0);
			}
			else
			{
				 ebasic= sc2.nextDouble();
				 if (ebasic<500){
						try {
							throw new LowSalException("ERROR BASIC SALARY CAN'T BE LESS THAN 500");//for handling Exception 
						} catch (LowSalException e) {
							System.out.println(e.getMessage());
						}
					}
					
			}
			System.out.println("Enter emp Designation :");
			if(!sc3.hasNextLine()){
			    System.out.println("Not an int ... enter an integer");
			System.exit(0);
			}
			else
			{
				 designation= sc3.nextLine();
/**
 * hra according to post
 */
					if(designation.equalsIgnoreCase("Manager")){
						hra=(0.1*ebasic);
						
					}
					else if (designation.equalsIgnoreCase("Officer"))
					{
						hra=(0.12*ebasic);
						
					}
					else if (designation.equalsIgnoreCase("Clrark"))
					{
						hra=(0.05*ebasic);
							
					}
					else 
					{
						throw new IllegalArgumentException("Enter valid Desiganation");	
					}	
				}
		Emp emp=new Emp(id, designation, ebasic,hra);
		
	
		emp.EmpDEt(id, designation, ebasic, hra);
	}
}
	




		