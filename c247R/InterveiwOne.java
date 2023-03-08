package c247R;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InterveiwOne {
	public static void main(String[] args) {
		int x [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int z[][]= {{0,1,2},{3,4,5},{6,7,8}};
		int t= 10;
		int y[]=new int [x.length];
		//y=shuffle(x);
		//bubblesort(y);
		y= zigzag(x);
		for (int i=0;i<y.length;i++) {
			System.out.print(y[i]+" ");
		}
		//System.out.print(twoSum(x,t,0));
		//System.out.println(boats(x,9));
		mergesort(y,0,y.length);
		System.out.println();
		for (int i=0;i<y.length;i++) {
			System.out.print(y[i]+" ");
		}
		System.out.print(quickSearch(z,7));
		}
	
	public static String quickSearch(int matrix [][],int value) {
		int upper=matrix.length;
		int lower=0;
		int mf=0;
		int nf=0;
		while(upper>lower) {
			int mid=(upper+lower)/2;
			if (matrix[mid][0]<=value) {
				upper=mid;
			}
			else {
				lower=mid;
			}
		}
		mf=lower;
		System.out.print(mf);
		upper=matrix[mf].length;
		lower=0;
		while(upper>lower) {
			int mid=(upper+lower)/2;
			if (matrix[mf][mid]<=value) {
				upper=mid;
			}
			else {
				lower=mid;
			}
		}
		nf=lower;
		if(matrix[mf][nf]!=value) {
			return "not found";
		}
		else {
			StringBuilder sb = new StringBuilder();
				sb.append(mf);
				sb.append(',');
				sb.append(nf);
				return sb.toString();
			}
		}
		
		
		
	
	
	public static int[] zigzag(int arr[]) {
		bubblesort(arr);
		int arr2 []=new int [arr.length];
		int top=0;
		int bottom=arr.length-1;
		for (int i=0;i<arr.length;i=i+2) {
			arr2[i]=arr[bottom];
			bottom--;
			if(i+1<arr2.length) {
			arr2[i+1]=arr[top];
			top++;
			}
		}
		return arr2;
	}
	public static void mergesort(int arr[],int left,int right) {
		if (left>=right) {
		}
		else {
			int mid=(left+right)/2;
			mergesort(arr,left,mid);
			mergesort(arr,mid+1,right);
			boolean swapped=true;
			while(swapped) {
				swapped=false;
				for (int j=left;j<=right;j++) {
					if (j+1<arr.length) {
					if (arr[j]>arr[j+1]) {
						swapped=true;
						int x=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=x;
					}
					}
				} 
			}
			
		}
		
		
		
	}
	
	
	public static int boats(int [] people, int limit) {
		bubblesort(people);
		
		int heaviest=0;
		int lightest=people.length;
		
		int answer=0;
		while(heaviest<=lightest) {
			if(heaviest+lightest>limit) {
				heaviest++;
				answer++;
			}
			else {
				heaviest++;
				lightest--;
				answer++;
			}
		}
		return answer;
	}
	
	public static void bubblesort(int [] arr) {
		boolean swapped=true;
		while(swapped) {
			swapped=false;
			for (int j=0;j<arr.length-1;j++) {
				if (arr[j]<arr[j+1]) {
					swapped=true;
					int x=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=x;
				}
			} 
		}
	}
	
	
	
	
	
	
	
	public static int[] shuffle (int x[]) {
		int arr []=new int [x.length];
		boolean [] filled=new boolean [x.length];
		int helperI=0; 
		for (int i=0;i<x.length;i++) {
		double shuff=Math.random();
		int cypher= (int)(shuff*x.length);
		if (!filled[cypher]) {
			filled[cypher]=true;
			arr[cypher]=x[i];
		}
		else {
			while(filled[helperI]) {
				
				helperI++;
			}
			arr[helperI]=x[i];
			filled[helperI]=true;
			helperI++;
		}
		
		}
		return arr;
	}
	
	
	
	
	
	public static String threeSum(int arr [], int target) {
		String found = "not found";
		for (int i=0;i<arr.length;i++) {
			int l= arr[i];
			found=twoSum(arr,target-l,i);
			if (!found.equals("notfound")) {
				
				found= found+",";
				found=found+Integer.toString(arr[i]);
				i=arr.length;
			}
		}	
		
		return found;
	}
	public static String twoSum(int arr [], int target, int forbiden) {
		String found = "not found";
		int i = 0;
		boolean fin = false;
		int otherI = 0;
		while (!fin && (i < arr.length - 1)) {
			if(i!=forbiden) {
			int y = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (j!=forbiden) {
				if (y + arr[j] == target) {
					fin = true;
					otherI = j;
				}
				}
			}
			}	
			i++;
		
		}
		StringBuilder sb = new StringBuilder();
		if (fin) {
			sb.append(arr[i - 1]);
			sb.append(',');
			sb.append(arr[otherI]);
			found = sb.toString();
		}
		return found;
	
	}
	
	
	
	}
