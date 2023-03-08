package c247R.c247Rclassism;

import java.util.LinkedList;
import java.util.List;

public class O1 {
	int x [];
	public O1() {
		x=new int [0];
	}
	public void Add(int value) {
		int p= x.length;
		int y []= new int [x.length+1];
		int i=0;
		if(x.length>0) {
		while(x[i]<value) {
			if (x[i]<value) {
					y[i]=x[i];
			}
			i++;
		}
		}
		y[i]=value;
		while(i<x.length) {
			y[i+1]=x[i];
		}
		x=y;
	}
	public boolean Delete(int value) {
		boolean exists=false;
		for (int i=0;i<x.length;i++) {
			if(x[i]==value) {
				exists=true;
			}
			else {
				i=x.length;
			}
		}
		if(exists) {
			int i=x.length;
			int y []= new int [x.length-1];
			while(x[i]>value) {
				if (x[i]>value) {
						y[i-1]=x[i];
				}
				i--;
			}
			i--;
			while(i<x.length) {
				y[i]=x[i];
			}
			x=y;
		}
		return exists;
	}
	public int GetMedian() {
		int median=0;
		if(x.length>0) {
		
			median=x[x.length/2];
		}
		return median;
	}
}
