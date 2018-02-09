

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Greeting
 */
public class Greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String greeting="HEllo World";
	private int hitCount; 

	   public void init() { 
	      // Reset hit counter.
	      hitCount = 0;
	   }

    /**
     * Default constructor. 
     */
    public Greeting() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
	      out.println( greeting );
	      Date date=new Date();
	      out.println("Cuttent time and Date :"+date);
	      out.println("Total hits are:"+hitCount);
	     
	      hitCount++;
	      
		
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
