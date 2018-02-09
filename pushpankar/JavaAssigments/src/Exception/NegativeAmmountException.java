package Exception;

/**
 *handles exception for  Negative Amount withdraw or deposit
 */

public class NegativeAmmountException extends Exception {

	
	
	  
		public  NegativeAmmountException (String message){
			super(message);
		}
	}

