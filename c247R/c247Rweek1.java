package c247R;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class c247Rweek1 {
	public static void main(String[] args) {
	int [] a= {4,7,8,10,15,20,55,75,97,99};
	mRange(a,0,100);
	int j=55;
	//for(j=0;j<100;j++){
	//System.out.print(j+",");
	System.out.println(binarySearch(a,j));
	//}
	System.out.println(largestSub("abbandmebbbbbacheckselo"));
	int rows = 5;
	int cols = 3;
	int[][] array = new int[rows][cols];
	int value = 1;
	for (int i = 0; i < rows; i++) {
    	for (int k = 0; k < cols; k++) {
        	array[i][k] = 2*value;
        	value++;
    	}
	}
	for (int l=0;l<30;l++){
		System.out.print(l+"'");
	System.out.println(contains2D(array,l));

	
	}
	
	}
	public static void mRange (int [] a, int lower, int upper){
	
	StringBuilder sb = new StringBuilder();
	sb.append ("[ ");
	for (int i=0;i<a.length;i++){
	if (lower==a[i]){
	lower++;
	}
	else if (lower==a[i]-1){
	sb.append(lower);
	lower=a[i]+1;
	if(a[i]!=upper){
	sb.append(", ");
	}
	}
	else{
	sb.append(lower);
	sb.append(" -> ");
	sb.append(a[i]-1);
	lower=a[i]+1;
	if(a[i]!=upper){
	sb.append(", ");
	}
	}
	}
	if (lower<upper){
	sb.append(lower);
	sb.append("- > ");
	sb.append(upper);
	}
	else if(lower==upper){
	sb.append(upper);
 	}
 	sb.append(']');
 	System.out.println(sb.toString());
	}
	
	public static int binarySearch(int [] a, int target){
	int upper =a.length-1;
	int lower = 0;
	int i = (lower+upper+1)/2;
	while (upper!=lower){
	if( a[i]>target){
	if(upper!=i){
	upper=i;
	}
	else{
	upper--;
	}
	i=(lower+upper+1)/2;
	}
	else if(a[i]<target){
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
	if(a[i]==target){
	return i;
	}
	else{
	return -1;
	}
	}
	
	public static String largestSub( String x){
	int largest = 0;
	int largestS=0;
	int start = 0;
 	char [] a = x.toCharArray();
	for (start=0;start<a.length; start++){
	StringBuilder sb = new StringBuilder();
	sb.append(a[start]);
	int b=start;
	while(!(b+1>=a.length)&&!sb.toString().contains(String.valueOf(a[b+1]))){
	sb.append(a[b+1]);
	b++;
	if(b+1>=a.length){
	break;
	}
	}
	if(sb.toString().length()>largest){
	largest=sb.toString().length();
	largestS=start;
	}
	}
	StringBuilder sc = new StringBuilder();
	for (int i=largestS; sc.toString().length()<largest;i++){
	sc.append(a[i]);
	}
	return sc.toString();
	}
	public static boolean contains2D( int [][] a, int t ){
	
	boolean contains=false;
	for(int i=0;i<a.length;i++){
	 for (int j=0;j<a[0].length;j++){
	 if (a[i][j]==t){
	 contains=true;
	 }
	  if (a[i][j]>=t){
	  j=a.length;
	  }
	 
	 }}
	return contains;
	
	
	}
	}

	