package c247R.c247Rclassism;

import java.util.LinkedList;
import java.util.List;

public class twoSum{
	private List <Integer> numbers= new LinkedList <Integer>();

	
	
	private boolean isEmpty() {
		if (numbers.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int add(int x) {
		int place=0;
		if (!isEmpty()) {
				place=binarySearch(x);
				numbers.add(place+1, x);
				return place+1;
		}
		else {
			numbers.add(place, x);
			return place;
		}
		
	}
	public boolean find (int target) {
		int higherInish=(numbers.size()+1)/2;
		int higherI=higherInish;
		int lowerInish=higherI-1;
		int lowerI=lowerInish;

		while ((lowerI>=0)&&(higherI<numbers.size())){
			if (numbers.get(lowerI)+numbers.get(higherI)==target) {
				return true;
			}
			if(numbers.get(lowerI)+numbers.get(higherI)>target) {
				if(lowerI!=0) {
						lowerI--;
				}
				else {
					lowerInish--;
					lowerI=lowerInish;
					higherI=lowerI+1;
				}
			}
			else {
				if(higherI!=numbers.size()-1) {
				higherI++;
				}
				else {
					higherInish++;
					higherI=higherInish;
					lowerI=higherI-1;
				}
			}
		}
		return false;
		
	}
	
	
	private int binarySearch (int target){
		int upper =numbers.size()-1;
		int lower = 0;
		int i = (lower+upper+1)/2;
		while (upper!=lower){
		if( numbers.get(i)>target){
		if(upper!=i){
		upper=i;
		}
		else{
		upper--;
		}
		i=(lower+upper+1)/2;
		}
		else if(numbers.get(i)<target){
		if (lower!=i){
		lower=i;
		}
		else {
		lower=lower+1;
		}
		i=(lower+upper+1)/2;
		}
		else{
		return i;
		}
		}
		return i;
		}
}