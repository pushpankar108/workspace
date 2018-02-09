package Cillections;

import java.util.*;
/**
 * 
 * @author pushpankar kumar
 * date 08/01/2018
 * method to accept the two lists containing the names of the players playing in the two games. 
 * The method should find out the names of player present in both the list and
 *  return the names as a Sorted ArrayList.
 *
 */


public class Main {
	public static void main(String [] args){
		/**
		 * list of cricket players
		 */
		
		Players c1=new Players("Rama","rama100@gmail.com","Banglore","Karnataka",20);
		Players c2=new Players("Shayam","Shayam100@gmail.com","Banglore","Karnataka",22);
		Players c3=new Players("Raju","raju100@gmail.com","Kanpur","Up",20);
		Players c4=new Players("Ramesh","Ramesh100@gmail.com","Banglore","Karnataka",22);
		Players c5=new Players("Balaji","Balaji100@gmail.com","Banglore","Karnataka",20);
		Players c6=new Players("Golu","Golu100@gmail.com","Patna","Bihar",20);
		Players c7=new Players("Rani","rani100@gmail.com","Banglore","Karnataka",20);
		Players c8=new Players("Kumar","Kumar100@gmail.com","Banglore","Karnataka",20);
		
		List<Players> cricket=new ArrayList<Players>();
		cricket.add(c1);
		cricket.add(c2);
		cricket.add(c3);
		cricket.add(c4);
		cricket.add(c5);
		cricket.add(c6);
		cricket.add(c7);
		cricket.add(c8);
		System.out.println("Players who plays cricket are are:");
		System.out.println();
		for(Players cric:cricket){
			System.out.println(cric.name+" "+cric.email+" "+cric.city+" "+cric.state+" "+cric.age);
		}
		
		
		Players f1=new Players("Rama","rama100@gmail.com","Banglore","Karnataka",20);
		Players f2=new Players("Abhi","Abhi100@gmail.com","Banglore","Karnataka",22);
		Players f3=new Players("Raju","raju100@gmail.com","Kanpur","Up",20);
		Players f4=new Players("Ramesh","Ramesh100@gmail.com","Banglore","Karnataka",22);
		Players f5=new Players("Balaji","Balaji100@gmail.com","Banglore","Karnataka",20);
		Players f6=new Players("Golu","Golu100@gmail.com","Patna","Bihar",20);
		Players f7=new Players("Gauram","Gautham100@gmail.com","Banglore","Karnataka",20);
		Players f8=new Players("Kumar","Kumar100@gmail.com","Banglore","Karnataka",20);
		/**
		 * list of football players
		 */
		
		List<Players> football=new ArrayList<Players>();
		
		
		football.add(f1);
		football.add(f2);
		football.add(f3);
		football.add(f4);
		football.add(f5);
		football.add(f6);
		football.add(f7);
		football.add(f8);
		System.out.println("Players who plays football are:");
		System.out.println();
		for(Players foot:football){
			System.out.println(foot.name+" "+foot.email+" "+foot.city+" "+foot.state+" "+foot.age);
		}
		
		System.out.println("Common players are:");
		System.out.println();
		List list=new Main().getPlayers(football,cricket);
		Collections.sort(list);
		
		System.out.println(list);
	}
	/**
	 * Function to find common players from football and cricket
	 * @param football
	 * @param cricket
	 * @return
	 */
public List<String> getPlayers(List<Players> football, List<Players> cricket){
		
		
		List <String> str=new ArrayList<String>();
			for(Players cric:cricket){
				for(Players foot:football){
					if(cric.name==foot.name){
						
						str.add(cric.name);
						
						}
				}
				
			}
			return str;
						
}
}
