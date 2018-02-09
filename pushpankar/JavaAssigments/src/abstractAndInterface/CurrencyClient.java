package abstractAndInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyClient {

	public static void main(String[] args) {
		
		int ch = 0;int x=1;
		
	
		while(x==1){
			Scanner sc=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			String name;
			System.out.println("enter 1 to continue or 0 to exit");
			/*try {
				ch=sc.nextInt(); 
			} 
			catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Entered value is not accepted try again");
		}*/
			if(sc.hasNextInt()){
				ch=sc.nextInt();
			}
			else{
				System.out.println("Enter 0/1 only");
				x=1;
				continue;
			}
	
	
	
		switch(ch){
		case 1:
			System.out.println(" enter cuntry name");
			name=sc2.nextLine();
			System.out.println(CurrencyContainer.getCurrency(name));
			x=1;
			break;
		case 0: 
			System.exit(0);
			x=0;
			break;
	
	
		default : 
			System.out.println("enter valid input");
			x=1;
		}
}
	while(ch!=0);
	return ;
}
}



