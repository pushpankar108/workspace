package abstractAndInterface;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int [] A=new int [10];
		Random rand=new Random();
		for(int i=0;i<10;i++)
		{
			A[i]=rand.nextInt(3);
		}
		for(int i=0;i<10;i++)
		{
			if(A[i]==1)
			{
				Game game1=new Car();
				game1.start();
				game1.play();
				game1.stop();
			}
			else if(A[i]==2)
			{
				Game game2=new Bike();
				game2.start();
				game2.play();
				game2.stop();
			}
			else
			{
				Game game3=new Bicycle();
				game3.start();
				game3.play();
				game3.stop();
			}
		}

	}

}
