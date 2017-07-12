package sys.view.tableitem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import sys.view.GetResourceClass;

public class MenuItemJlabel extends JLabel {

	public MenuItemJlabel(String text){
		super(text,JLabel.CENTER);
		setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(198), GetResourceClass.getRealSize(40)));
		setBorder(new MatteBorder(new Insets(0, 0, 1, 0), new Color(241,241,241)));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		System.out.println("fdsafdsa");
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setFont(new Font("黑体",Font.PLAIN,20));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(25)));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
