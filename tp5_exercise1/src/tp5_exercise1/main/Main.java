package tp5_exercise1.main;

import tp5_exercise1.*;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<ISoundEmisor> emisors = new ArrayList<>();
		
		emisors.add( new Cat( "Javier", 12 ) );
		emisors.add( new Cow( "Carlos", 2 ) );
		emisors.add( new Dog( "Lucas", 1 ) );
		emisors.add( new Ambulance( "ACOW-122", "1", "12" ) );
		
		for(ISoundEmisor emisor: emisors) {
			emisor.emitSound();
		}

	}

}
