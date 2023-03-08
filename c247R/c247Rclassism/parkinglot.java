package c247R.c247Rclassism;

import java.util.LinkedList;

public class parkinglot{
		private int size;
		public boolean [] spots= new boolean [size]; // false is empty true is full
		
		public boolean openSpot(int x){ // if you ask about a spot x (going from zero to size-1)  returns true if open
			return !spots[x];
		}
		public boolean comingIn(int spot){
			if (openSpot(spot)) {
				spots[spot]=true;
				return true;
			}
			else {
				System.out.println("That spot is not open, please find another one");
				return false;
			}	
		}
		public boolean leaving (int spot) {
			if (!openSpot(spot)) {
				spots[spot]=false;
				System.out.println("thank you for parking with us");
				return true;
			}
			else {
				System.out.println("that spot was not in use are you sure you left from there?");	
				return false;
			}
			
		}
		
	}