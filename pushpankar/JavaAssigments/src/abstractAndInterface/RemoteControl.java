package abstractAndInterface;

public interface RemoteControl {
	public int MIN_SOUND=0;
	public int MAX_SOUND=50;
	public boolean powerOnOff(); // Returns new state, on = true
	public int volumeUp(int increment); // Returns new volume level
	public int volumeDown(int decrement); // Returns new volume level
	public void mute(); // Mutes sound output
}