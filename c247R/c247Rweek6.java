package c247R;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class c247Rweek6 {
	public static void main(String[] args) {
	int x []={1,2,3};	
//	triangle(x);
//	LinkedList trial = new LinkedList();
//	trial.add(1);
//	trial.add(2);
//	trial.add(3);
//	trial= reverse(trial);
//	for (int i=0;i<trial.size();i++) {
//		System.out.print(trial.get(i));
//	}
	//parens(3);
	//permutation("bat");
	
		powerset(x);
	}
	
	public static void triangle (int [] init) {
		for (int i=0;i<init.length;i++) {
		System.out.print(init[i]+" ");
		}
		System.out.println();
		if (init.length>1) {
			int next []=new int [init.length-1];
			for (int i=0;i<next.length;i++) {
				next[i]=init[i]+init[i+1];
				}
			triangle(next);
		}
	}
	public static LinkedList reverse (LinkedList L) {
		if (L.size()==1) {
			return L;
		}
		else {
			Object o= L.remove();
			reverse(L);
			L.add(o);
		}
		
		return L;
		
	}
	public static void parens(int i) {
		LinkedList x=ParensHelper(i);
		for (int j=0;j<x.size();j++) {
			System.out.print(x.get(j)+", ");
		}
	}
	public static LinkedList ParensHelper(int i) {
		if (i==1) {
		LinkedList y=new LinkedList();
		y.add("()");
		return y;
		}
		else {
			LinkedList a = ParensHelper(i-1);
			LinkedList z= new LinkedList();
			for (int k=0;k<a.size();k++) {
				StringBuilder sb= new StringBuilder();
				sb.append("(");
				sb.append(((String) a.get(k)).toCharArray());
				sb.append(")");
				z.add(sb.toString());
			}
			
			for (int j=0;j<a.size();j++) {
				StringBuilder sb= new StringBuilder();
				sb.append("(");
				sb.append(")");
				sb.append(((String) a.get(j)).toCharArray());
				if (z.indexOf(sb.toString())==-1) {
					z.add(sb.toString());
					}
			}
			for (int k=0;k<a.size();k++) {
				StringBuilder sb= new StringBuilder();
				sb.append(((String) a.get(k)).toCharArray());
				sb.append("(");
				sb.append(")");
				if (z.indexOf(sb.toString())==-1) {
				z.add(sb.toString());
				}
			}
			
		return z;
		}
	}
	public static void permutation(String s) {
		char x[] = s.toCharArray();
		char z[]=new char [0];
		int length=s.length();
		permutationHelper(z,length,x);
	}
	
	public static void permutationHelper(char[] s,int trueLength, char[] y) {
		if (s.length==trueLength) {
			StringBuilder sb=new StringBuilder();
			for (int i=0; i<s.length;i++) {
				sb.append(s[i]);
			}
			String l=sb.toString();
			if (l.length()==trueLength) {
				
				System.out.print(l+", ");
			}
		}
		else {
			for (int i=0; i<y.length; i++) {
			char [] ns = new char[s.length+1];
			for (int j=0;j<s.length;j++) {
				ns[j]=s[j];
			}
			ns[s.length]=y[i];
			char [] ny= new char [y.length-1];
			int helper=0;
			for (int k=0;k<y.length;k++) {
				if(k!=i) {
					ny[helper]=y[k];
					helper++;
				}
			}
//			System.out.print(ns.length);
//			System.out.print(" "+y.length);
			permutationHelper(ns, trueLength , ny);
			}
		}
	}
	public static void powerset (int [] values) {
		LinkedList v= new LinkedList();
		for (int i=0;i<values.length;i++) {
			v.add(values[i]);
		}
		LinkedList x=new LinkedList();
		powersetHelper(v,x);
	}
	
	public static void powersetHelper (LinkedList values,LinkedList have) {
		StringBuilder sb= new StringBuilder();
		sb.append('{');
		for (int i=0;i<have.size();i++) {
			sb.append(have.get(i));
			if(i!=have.size()-1) {
			sb.append(", ");
			}
		}
		sb.append('}');
		System.out.print(sb.toString());
		for (int j=0;j<values.size();j++) {
			Object i=values.remove(j);
			have.add(i);
			powersetHelper(values,have);
			values.add(j,i);
			have.remove(i);
		}
		
	}
	

}