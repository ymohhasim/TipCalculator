package TipCalculator;

//import java.util.Scanner;
import javax.swing.SwingUtilities;

public class TipCalculatorManager {
	public static void main (String []args) {
		/* Scanner scanner = new Scanner(System.in);
		System.out.println("How much is your total?");
		
		double total = scanner.nextDouble();
		double tipPercentage = scanner.nextDouble();
		
		scanner.close();
		
		tipCalculator tipCalculator = new tipCalculator();
		double tipAmt = tipCalculator.tipCalc(total,tipPercentage);
		
		System.out.println("Total amount: $" + total);
        System.out.println("Tip percentage: " + tipPercentage + "%");
        System.out.println("Tip amount: $" + tipAmt);
		*/
		
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new TipCalculatorGUI();
	            }
	        });
		
		
		
	}
}
