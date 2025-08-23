package tp1_exercise6;

import tp1_exercise6.entities.*;

public class Main {

	public static void main(String[] args) {
		SocioInterface s1, s2, s3;
		
		s1 = new Socio(12);
		s2 = new Socio(34);
		s3 = new Socio(67);
		
		MembershipFee fee = new MembershipFee( 500 );
		
		System.out.println( fee.getByMember(s1) );
		System.out.println( fee.getByMember(s2) );
		System.out.println( fee.getByMember(s3) );
	}

}
