package TipCalculator;

public class tipCalculator {
	public double tipCalc(double total,double percent) {
		double tip = total * (percent/100);
		return tip;
	}
	
}
