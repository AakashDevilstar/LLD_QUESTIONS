package rating;

import java.util.ArrayList;
import java.util.List;

public class Rating {
	private List<Integer> ratings;
	
	public Rating() {
		this.ratings=new ArrayList<>();
	}
	
	public void addRating(int ratings) {
		this.ratings.add(ratings);
	}
	
	public int getAvgRating() {
		if(this.ratings.size()==0) {
			return 0;
		}
		int n=ratings.size();
		int sum_of_ratings=0;
		for(int it:ratings) {
			sum_of_ratings+=it;
		}
		int result=sum_of_ratings/n;
		return result;
	}
	
}