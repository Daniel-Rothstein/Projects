 package c247R;
import java.util.*;

import javax.swing.text.html.HTMLDocument.BlockElement;


public class myMinQue {
	private static Stack elements = new Stack <>();
	private static Comparable min;
	
	public static void add(Comparable E) {
		elements.push(E);
		if (elements.isEmpty()) {
			min = E;
		}
		else if( min.compareTo(E)<0 ) {
			min=E;
		}
	}
	public static Object push() {		
		if(!elements.isEmpty()) {
		Object E= elements.pop();
		if (E.equals(min)) {
			
		}
		return E;
		}
		else {
			return null;
		}
	}
	public static Object peek() {
		if (!elements.isEmpty()) {
		Object E= elements.peek() ;
		return E;
		}
		else {
			return null;
		}
	}
	
	public static boolean isEmpty() {
		return elements.isEmpty();
	}
	public static Comparable getMin() {
		if (elements.isEmpty()) {
		return min;
		}
		else {
		return null;
		}
	}

}