package parking;

public class Parking_Spot {
	int arr[]=new int[10];
	
	public int SpotNum() {
		int free_spot=0;
		for(int i=0;i<10;i++) {
			if(arr[i]==0) {
				free_spot=i+1;
				arr[i]=i+1;
				break;
			}
		}
		return free_spot;
	}
	
	public int Si(){
		int Total_space=0;
		for(int i=0;i<10;i++) {
			if(arr[i]==0) {
				Total_space++;
			}
		}
		return Total_space;
	}
	
	public void FreeSpace(int idx) {
		arr[idx-1]=0;
	}
	
	public void sipe() {
		System.out.print("\nSpot Status:");
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
}