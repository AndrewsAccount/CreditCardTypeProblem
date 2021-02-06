import java.util.ArrayList;
import java.util.List;

public class CreditCardFactory {
	
	private List notValidCards = new ArrayList<Long>();
	
	// read first digit
	// if is NOT 2/5, 3, 4, 6 add to bad list
	// if 2/5, is second digit 1-5, if so is 16-digits MC
	// if 3, is second digit 4 or 7, if so is 15-digits amex
	// if 4, is 13 or 16 digits visa
	// if 6, are first 4 digits "6011", if so is 16-digits disc
	

	
	public CreditCard cardType(long creditCardNumber ) throws  InvalidCreditCardNumberException {
		
		String ccNumber = String.valueOf(creditCardNumber);
		int length = String.valueOf(ccNumber).length();
		int firstDigit = ccNumber.charAt(0);
		int secondDigit = ccNumber.charAt(1);
		String firstFour = ccNumber.substring(0, 4);
		CreditCard cardType;

		
		if((firstDigit == 2 || firstDigit == 5) && (secondDigit == 1 || secondDigit == 5) && length == 16)
			return cardType = new MasterCard();
		
		if(firstDigit == 3 && (secondDigit == 4 || secondDigit == 7) && length == 15)
				return cardType = new AmericanExpress();

		if(firstDigit == 4 && (length == 13 || length == 16)) {
			return cardType = new Visa();
		}
		
		if(firstFour.equals("6011") && length == 16) {
			return cardType = new Discover();
		}
		
		else {
			notValidCards.add(creditCardNumber);
			
		}
		throw new InvalidCreditCardNumberException("Invalid card number");
	}
}
