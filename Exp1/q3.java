
abstract class Banks {
	abstract double getRateOfInterest();
}
class SBI extends Banks {
	double getRateOfInterest() {
		return 6.5;
	}
}
class HDFC extends Banks {
	double getRateOfInterest() {
		return 6.8;
	}
}
class PNB extends Banks {
	double getRateOfInterest() {
		return 7.0;
	}
}
public class q3 {

	public static void main(String[] args) {
		Banks b;
		b = new SBI();
		System.out.println("Rate of Interest in SBI: " + b.getRateOfInterest() + "%");
		b = new HDFC();
		System.out.println("Rate of Interest in HDFC: " + b.getRateOfInterest() + "%");
		b = new PNB();
		System.out.println("Rate of Interest in PNB: " + b.getRateOfInterest() + "%");
	}
}
