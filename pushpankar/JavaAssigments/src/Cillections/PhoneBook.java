package Cillections;
import java.util.*;

public class PhoneBook{
	
Map<String,String> map=new HashMap<>();
		
public  void addDetails(String phno,String name){
	map.put(phno,name);
		}
		
public String getName(String phno){
			
    if(map.containsKey(phno))
    {
        System.out.println(phno+"="+map.get(phno));
        return map.get(phno);
    }
    else
    {
        System.out.println("Not found");
    }
	return null;
		}
}
