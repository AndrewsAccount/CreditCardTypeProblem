import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreditCardTypeTesting {

	// read the input, use scanner/ hasNext Line
	// parse the string
	// store each element in the parse to an array
	// check first element for valid ccNum
	// check if ccNum is a valid cc
	// create a creditCard
	
	private AmericanExpress amex;
	private Discover discover;
	private MasterCard master;
	private Visa visa;
	
	static File file = new File("file.txt"); 

	static CreditCardFactory ccFactory;
	
	public static void main(String[] arg) {
		
		final String[] TEST_DATA = {
				"5100123412341234,07/22,John Doe",
				"6011123412341234,09/23,Jane Doe",
				"2443214321432143,01/25,That Person",
				"4234123412341234,12/12/21,This Guy",
				"4234123412341,10/10/23, Another Name",
				"3434123412341234123,02/21/21, Card Name",
				"3734123412341234123, 05/05/25, Old Person",
				"8675309,01/01/22,Young Person",
				"9434123412341234123,12/25/25, MidAge Person",
				"80001234123412341234,07/24/24, Homer Simpson"
		};
		
		int arrSize = TEST_DATA.length;
		
		int cardNumber;

		for(int i = 0; i < arrSize; i++) {
			
			String[] line = TEST_DATA[i].split(",");
			
			cardNumber = Integer.parseInt(line[0]);
			
			try {
				ccFactory.cardType(cardNumber);
			} catch (InvalidCreditCardNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

}
