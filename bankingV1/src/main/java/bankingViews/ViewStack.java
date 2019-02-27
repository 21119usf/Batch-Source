package bankingViews;

import java.util.Scanner;
import java.util.Stack;

public class ViewStack {

	public static Scanner scanner = new Scanner(System.in);
	private Stack<View> viewStack;
	private ViewMaker viewMaker;
	public String activeUser = "";
	public ViewStack() {
		viewStack = new Stack<View>();
		viewMaker = new ViewMaker();
		LoginView logview = new LoginView();		
		viewStack.push(logview);
	}
	
	public void start() {
		while(true)	{
			if(!viewStack.isEmpty()) {
				if(viewStack.peek() != null) {
					viewStack.peek().show(this);
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}
	

	public void getNextView(String string) {
		viewStack.push(viewMaker.determineNextView(string));
	}
	
	public void getLastView() {
		viewStack.pop();
	}
}
