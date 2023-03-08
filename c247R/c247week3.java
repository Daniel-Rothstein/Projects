package c247R;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class c247week3 {
	public static void main(String[] args) {
	String [] s= {"6", "2", "1", "+", "*", "2","/"};
	System.out.println(polish(s));
	String t= "[](){}{}[]";
	System.out.println(valid(t));
	Stack l= new Stack();
	l.add(1);
	l.add(3);
	l.add(8);
	l.add(5);
	l.add(2);
	l.add(4);
	sort(l);
	System.out.println(l);
	}
	
	public static int polish(String[] a) {
		boolean [] markdown =new boolean [a.length];
		int value=0;
		boolean first=true;
		for (int i=2; i<a.length;i++) {
			if (a[i]=="+") {
			 if (first) {
				 value=Integer. parseInt(a[i-1]);
				 value=value+Integer. parseInt(a[i-2]);
				 markdown [i-1]=true;
				 markdown [i-2]=true;
				 markdown [i]=true;
				 first=false;
			 }
			 else {
				markdown[i]=true;
				int x=i;
				 while (markdown[x]) {
					 x--;
				 }
				 value=value+Integer. parseInt(a[x]);
				 markdown[x]=true;
			 }
			}
			if (a[i]=="-") {
				if (first) {
					value=Integer. parseInt(a[i-1]);
					 value=value-Integer. parseInt(a[i-2]);
					 markdown [i-2]=true;
					 markdown [i-1]=true; 
					 markdown [i]=true;
					 first=false;
				 }
				 else {
						markdown[i]=true;
						int x=i;
						 while (markdown[x]) {
							 x--;
						 }
						 value=value-Integer. parseInt(a[x]);
						 markdown[x]=true;
					 }

			}
			if (a[i]=="*") {
				if (first) {
					value=Integer. parseInt(a[i-1]);
					 value=value*Integer. parseInt(a[i-2]);
					 markdown [i-1]=true;
					 markdown [i-2]=true;
					 markdown [i]=true;
					 first=false;
				 }
				 else {
						markdown[i]=true;
						int x=i;
						 while (markdown[x]) {
							 x--;
						 }
						 value=value*Integer. parseInt(a[x]);
						 markdown[x]=true;
					 }

			}
			if (a[i]=="/") {
				if (first) {
					value=Integer. parseInt(a[i-2]);
					 value=value/Integer. parseInt(a[i-1]);
					 markdown [i-1]=true;
					 markdown [i-2]=true; 
					 markdown [i]=true;
					 first=false;
				 }
				 else {
						markdown[i]=true;
						int x=i;
						 while (markdown[x]) {
							 x--;
						 }
						 value=value/Integer. parseInt(a[x]);
						 markdown[x]=true;
					 }

			}
		}
		return value;
	}
	public static boolean valid(String s) {
		boolean t=true;
		char [] x = s.toCharArray();
		for (int i=0;i<x.length;i=i+2) {
			if( x[i]=='(') {
				if (x[i+1]!=')') {
					t=false;
				}
			}
			else if( x[i]=='{') {
				if (x[i+1]!='}') {
					t=false;
				}
			}
			else if( x[i]=='[') {
				if (x[i+1]!=']') {
					t=false;
				}
			}
			else {
				t=false;
			}
			if (!t) {
				i=x.length;
			}
		}
		return t;
	}
	public static void sort(Stack s) {
	 Stack t= new Stack();
	 Comparable max=(Comparable) s.peek();
	 Comparable lastM=null;
	 while (!s.isEmpty()) {
		 if (max.compareTo(s.peek())<0) {
			 max=(Comparable)s.peek();
		 }
		 t.add(s.pop());
	 }
	s.add(max);
	 while (!t.isEmpty()) {
		 if (max.compareTo(t.peek())==0) {
			t.pop();
		 }
		 else {
			s.add(t.pop());
		 }
	 }
	 lastM=max;
	 max=(Comparable) s.peek();
	while (!lastM.equals(s.peek())) {
		while (lastM.compareTo(s.peek())!=0) {
			 if (max.compareTo(s.peek())<0) {
				 max=(Comparable)s.peek();
			 }
			 t.add(s.pop());
		 }
		s.add(max);
		 while (!t.isEmpty()) {
			 if (max.compareTo(t.peek())==0) {
				t.pop();
			 }
			 else {
				s.add(t.pop());
			 }
		 }
		 lastM=max;
		 max=(Comparable) s.peek();
	}
	}
}