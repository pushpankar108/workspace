package abstractAndInterface;

import java.util.Scanner;
/**
 * 
 * @author Pushpankar kumar
 * Date:04/01/2018
 * Iterator program for checking next element
 *
 */

public class UserList implements MyIterator{
		 private String[] name;
		 private int count;

		
		public UserList(String[] name) {
			super();
			this.name = name;
			this.count=0;
		}
		/**
		 * returns true if next element is there
		 */
		public boolean hasNext() {
			return(this.count<this.name.length)?true:false;
		}
		/**
		 * Return current element 
		 */
		public String next() {
			if (this.hasNext()) {
				return name[count++];
			}
			return null;
			
		}
		/**
		 * Main function 
		 * 
		 */
		
		public static void main(String args[]){
			int n=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter how many names u want to enter");
			if(sc.hasNextInt()) {
				n=sc.nextInt();			
			}
			else {
				System.err.println("Enter only numbers .. input invalid try again");
				System.exit(0);
				
			}
			Scanner sc2=new Scanner(System.in);
			String []name=new String[n];
			System.out.println("Enter names");
			/*
			 * enter input for String
			 */
			for(int i=0;i<n;i++){
				name[i]=sc2.nextLine();
			}
			
			UserList ul=new UserList(name);
			/*
			 * if next element is there in string then call next();
			 */
			System.out.println("Name returned my iterator");
			while(ul.hasNext()){
			String name1=ul.next();
			System.out.println(name1);
			}
	}
}
