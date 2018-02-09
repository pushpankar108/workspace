package Instrument;

public class Main {

	public static void main(String[] args) {
		Instrument instrument1=new Piano();
		Instrument instrument2=new Guitar();
		Instrument instrument3=new Flute();
		
		instrument1.play();
		instrument2.play();
		instrument3.play();
		Instrument []inst=new Instrument []{new Flute(),new Guitar(),new Piano()};
		for(int i=0;i<3;i++){
			inst[i].play();
		}
		

	}

}
