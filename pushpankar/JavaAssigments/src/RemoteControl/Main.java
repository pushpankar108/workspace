package RemoteControl;
/**
 * Author :Pushpankar
 * Date:04/01/2018
 * Operation for tv and DVD
 */
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int ch=0;
		boolean flag=true;
		DVD dvd=new DVD();
		Tv tv=new Tv();
		/**
		 * Select Device choice
		 */
		while(flag) {
			System.out.println("Enter 1 to operate TV");
			System.out.println("Enter 2 to operate DVD");
			System.out.println("Enter 3 to exit");
			Scanner sc=new Scanner(System.in);
			if(sc.hasNextInt()) {
				ch=sc.nextInt();
				flag=false;
			}
			else {
				System.err.println("Enter only numbers");
				flag=true;
				continue;
			}
			switch (ch) {
			case 1:
				Device(tv);
				flag=true;
				break;

			case 2:
				Device(dvd);
				flag=true;
				break;

			case 3:
				System.out.println("Thank you!!!");
				flag=false;
				break;

			default:
				System.err.println("Enter only 1 to 3");
				flag=true;
				break;
			}
		}
	}
	/**
	 * Select operations for device
	 * @param device
	 */
	public static void Device(RemoteControl device) {
		Scanner sc1=new Scanner(System.in);
		boolean Flag=true;
		int ch=0;
		while(Flag) {
			System.out.println("press 1 to power on/power off");
			System.out.println("press 2 to increase volume");
			System.out.println("press 3 to decrease volume");
			System.out.println("press 4 to mute");
			System.out.println("Enter 5 to exit");
			System.out.println("Enter your choice");
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
			case 1:
				boolean state=device.powerOnOff();
				System.out.print(device+" is switched ");
				System.out.println((state)?"ON":"OFF");
				Flag=true;
				break;
			case 2:
				boolean flag=true;
				while(flag) {
					System.out.println("Enter the volume level");
					sc1=new Scanner(System.in);
					if(sc1.hasNextInt()) {
						int increment=sc1.nextInt();
						int vol=device.volumeUp(increment);
						if(vol!=-1)
							System.out.println("The volume is "+ vol);
						flag=false;
					}
					else {
						System.out.println("Invalid input ...Enter ");
						flag=true;
					}
				}
				Flag=true;
				break;	
			case 3:
				flag=true;
				while(flag) {
					System.out.println("Enter the volume level");
					sc1=new Scanner(System.in);
					if(sc1.hasNextInt()) {
						int decrement=sc1.nextInt();
						int vol=device.volumeDown(decrement);
						if(vol!=-1)
							System.out.println("The volume is "+ vol);
						flag=false;
					}
					else {
						System.out.println("Enter only nos");
						flag=true;
					}
				}
				Flag=true;
				break;
			case 4:
				device.mute();
				Flag=true;
				break;
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