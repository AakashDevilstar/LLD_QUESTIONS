package Pay;

public class Payment{
	float  HourAmount=50;
	float TotalHourAmount=0;
	float TotalMinuteAmount=0;
	
	public float TotalAmount(int Hour,int Minutes) {
		TotalHourAmount=HourAmount*Hour;
		
		if(Minutes<60 && Minutes>=30) {
			TotalMinuteAmount=20;
		}
		
		else if(Minutes<30 && Minutes>=15) {
			TotalMinuteAmount=15;
		}
		
		else if(Minutes<15 && Minutes>=1) {
			TotalMinuteAmount=10;
		}
		
		return (TotalHourAmount+TotalMinuteAmount);
	}
	
}