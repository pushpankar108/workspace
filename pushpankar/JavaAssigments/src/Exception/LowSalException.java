package Exception;
/**
 * used by Emp class for exception hendaling
 * extends exception 
 */
public class LowSalException extends Exception {
	public LowSalException(String message){
		super(message);
	}
}
