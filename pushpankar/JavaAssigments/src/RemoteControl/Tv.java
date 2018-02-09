package RemoteControl;
public class Tv implements RemoteControl{
		private boolean state;
		private int volume;



		public Tv() {
			this.state=false;//state
			this.volume=MIN_SOUND;
		}
		public boolean powerOnOff() {
			this.state=!state;//change state
			return state;
		}
		/**
		 * Increase TV volume
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
				System.out.println("TV is not switched on.");
				return -1;
			}
		}
		/**
		 * decrease Tv volume
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
				System.out.println("TV is not switched on");
				return -1;
			}	}
		/**
		 * Mute Tv
		 */
		public void mute() {
			if (state) {
				System.out.println("The TV volume is muted.");
			}
			else {
				System.out.println("TV is switched off. power on first and then mute");
			}
		}
		public String toString() {
			return "Tv";
		}
	}
