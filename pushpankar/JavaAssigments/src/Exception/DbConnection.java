package Exception;
/**
 * @author pushpankar 
 * 
 *
 */

public class DbConnection {
	

		   private static DbConnection connection  =null;

		 
		   private  DbConnection() { 
			   super();}

		  
		   public static DbConnection getObject() throws MoreThanOneObjectException{
			   /**
			    * initially null ,then incountered first time and object is created;
			    */
			   
			   if(connection==null){
				   
			   connection=new DbConnection();
		       return  connection;
		       }
			   else{
				   
				   throw new MoreThanOneObjectException("Can't allow more than one object");
				  
		   }
			   
	 }
/**
 first time show message
 after first object it will show error or handeled message
 */

		@Override
		public String toString() {
			return "DbConnection";
		}
}
	
		
		
		
