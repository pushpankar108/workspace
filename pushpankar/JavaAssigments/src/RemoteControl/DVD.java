package RemoteControl;
/**
 * 
 * @author Pushpankar Kumar
 * Date:04/01/2018
 *implement interface Remote Control with all its function for DVD
 */
public class DVD implements RemoteControl{
	private boolean state;
	private int volume;

/**
 * For operating DVD
 */
	public DVD() {
		this.state=false;//state 
		this.volume=MIN_SOUND;

	}
	public boolean powerOnOff() {
		state=!state;//change state
		return state;
	}
	/**
	 * Function to Increase volume for DVD
	 */
	public int volumeUp(int increment) {
		if (state) {
			if(increment>=MIN_SOUND && increment<=MAX_SOUND) {
				if(increment>=volume) {
					this.volume=increment;
					return volume;
				}
				else {
					System.out.println("Already the volume is "+volume+" Enter the value higher than "+volume
							+" to increase");
					return -1;
				}
			}
			else {
				System.out.println("The volume is out of range (Range 0-50)");
				return -1;
			}
		}
		else {
			System.out.println("Dvd is not switched on.");
			return -1;
		}

	}
	/**
	 * Function to Decrease volume for DVD
	 */
	public int volumeDown(int decrement) {
		if (state) {
			if(decrement>=MIN_SOUND && decrement<=MAX_SOUND) {
				if(decrement<=volume) {
					this.volume=decrement;
					return volume;
				}
				else {
					System.out.println("Already the volume is "+volume+" Enter the value lower than "+volume
							+" to decrese");
					return -1;
				}

			}
			else {
				System.out.println("The volume is out of range (Range 0-50)");
				return -1;
			}
		}
		else {
			System.out.println("Dvd is not switched on");
			return -1;
		}
	}
	/**
	 * Mute DVD volume
	 */
	public void mute() {
		if (state) {
			System.out.println("The DVD volume is muted.");
		}
		else {
			System.out.println("DVD is switched off. power on first and then mute");
		}	}
	
	public String toString() {
		return "DVD";
	}

}


