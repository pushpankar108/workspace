

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Arthmatics
 */
public class Arthmatics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Arthmatics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init()
	       { 
	    
	   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String option = request.getParameter("option") ;
	     
		 PrintWriter writer=response.getWriter();
		 
	     
	   try{
	     String selected_option = (option.equals("A")?"A":option.equals("B")?
	                             "B":option.equals("C")?"C":option.equals("D")?"D":"E");
	     
	     writer.println("Selected option Is.... :"+selected_option);
	    
	     
	        String tvalue=request.getParameter("textbox1");
	        int num=Integer.parseInt(tvalue);
	        
	       
	        if(selected_option.equals("A")){
	        int  fib1 = 0, fib2 = 1, fib3,count = 0;
	        writer.println("your selected option is A:Fibonaaci");
	        writer.println("Fibonacci number is"+num);
	        writer.println(0);
	        writer.println(1);
	        while (count < num)
	        {
	            fib3 = fib1 + fib2;
	            count++;
	            writer.println(fib3);
	            fib1 = fib2;
	            fib2 = fib3;
	        }
	        }
	        
	        if(selected_option.equals("B")){
	        	 writer.println("your selected option is B:PrimeOrNot");
	            int i, flag = 0;


	            for(i=2; i<=num/2; ++i)
	            {
	                // condition for nonprime number
	                if(num%i==0)
	                {
	                    flag=1;
	                    break;
	                }
	            }

	            if (flag==0)
	            	 writer.println(num+"Is a Prime number");
	            else
	            	 writer.println(num+ "Is not a Prime number");
	            
	           
	        }
	        
	        if(selected_option.equals("C")){
	       	 int fact=1;
	       	 writer.println("your selected option is C:Factorial");
	 		while(num>0)
	 		{
	 			if(num>0){
	 				fact=fact*num;
	 				num--;
	 			}
	 			
	 		}
	 		 writer.println("Factorial is:"+fact);
	        }
	        
	        if(selected_option.equals("D")){
	        	 writer.println("your selected option is D:Table");
	        	 writer.println("TAble of number is:");
	        	 writer.println(num*1 +" "); writer.println(num*2 +" "); writer.println(num*3 +" "); writer.println(num*4 +" "); writer.println(num*5 +" "); writer.println(num*6 +" ");
	        	 writer.println(num*7 +" "); writer.println(num*8 +" "); writer.println(num*9 +" "); writer.println(num*10 +" ");
	        }
	        
	        
	        if(selected_option.equals("E")){
	        	int i, Sum = 0 ;
	        	 writer.println("your selected option is E:PerfectNum");
	    		for(i = 1 ; i < num ; i++) {
	    			if(num% i == 0)  {
	    				Sum = Sum + i;
	    			}
	    		}
	    		if (Sum == num) {
	    			 writer.println(num+"IS perfect number");
	    		}
	    		else {
	    			 writer.println(num+"IS not a perfect number");
	    		}
	        }
	        
	        writer.close();
	}
	        catch(Exception exception)
	        {
	            exception.printStackTrace();    
	        }

		
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
			
		    }
		 
	

		
	
	public void destroy() { 
	      // This is optional step but if you like you
	      // can write hitCount value in your database.
	   } 

}
