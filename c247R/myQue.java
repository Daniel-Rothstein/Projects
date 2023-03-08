package c247R;
import java.util.*;

import javax.swing.text.html.HTMLDocument.BlockElement;


public class myQue {
	private static Stack elements = new Stack <>();
	private static Stack helper= new Stack <>();
	
	public static void add(Object E) {
		elements.push(E);
	}
	public static Object poll() {
		if(!elements.isEmpty()) {
		while (!elements.isEmpty()) {
			helper.add(elements.pop());
		}
		Object E= helper.pop() ;
		while(!helper.isEmpty()) {
			elements.add(helper.pop());
		}
		return E;
		}
		else {
			return null;
		}
	}
	public static Object peek() {
		if(!elements.isEmpty()) {
		while (!elements.isEmpty()) {
			helper.add(elements.pop());
		}
		Object E= helper.peek() ;
		while(!helper.isEmpty()) {
			elements.add(helper.pop());
		}
		return E;
		}
		else {
			return null;
		}
	}
	public static boolean isEmpty() {
		return elements.isEmpty();
	}

}