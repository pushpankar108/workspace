package abstractAndInterface;

public class CurrencyContainer{
	public static Currency getCurrency(String Cuntry){
	Cuntry=Cuntry.toLowerCase();
	if(Cuntry.equals("india")){
		India india=new India();
		return india.getCurrency(Cuntry);
	}
	else if(Cuntry.equals("usa")){ 
		Usa usa=new Usa();
		return usa.getCurrency(Cuntry);
	}
	else if(Cuntry.equals("uk")){
		Uk uk=new Uk();
		return uk.getCurrency(Cuntry);
		
	}
		
	else 
		  throw new IllegalArgumentException("enter valid name");
	}
}
