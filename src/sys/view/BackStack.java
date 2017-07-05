package sys.view;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sys.GlobalVariables;

public class BackStack extends Stack<ArrayList<JPanel>> {


	private static BackStack backStack;
	static{
		backStack=new BackStack();
	}
	public static void saveHistory(ArrayList<JPanel> list){
		backStack.push(list);
	}
	public static void backToHistory(){
		ArrayList<JPanel> list=backStack.pop();
		for(int i=0;i<list.size();i++){
			GlobalVariables.frame.getContentPane().add(list.get(i));
			GlobalVariables.frame.getContentPane().repaint();
		}
	}
}
