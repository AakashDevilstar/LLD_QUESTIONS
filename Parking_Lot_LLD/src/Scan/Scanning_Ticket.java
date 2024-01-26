package Scan;

public class Scanning_Ticket {
	
	public int Scan_Conform(String inputNumber,String storedNumber) {
		
		int size1=inputNumber.length();
		int size2=storedNumber.length();
		
		if(size1!=size2) {
			return 0;
		}
		
		else if(inputNumber.equals(storedNumber)) {
			return 1;
		}
		return 0;
	}
	
}