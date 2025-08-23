package tp1_exercise6.entities;

public class MembershipFee {
	double baseFee;

	public MembershipFee(double baseFee) {
		super();
		this.baseFee = baseFee;
	}
	
	public double getByMember (SocioInterface socio) {
		return this.baseFee * (1 - socio.getDiscountPercentage()/100); 
	}
	
}
