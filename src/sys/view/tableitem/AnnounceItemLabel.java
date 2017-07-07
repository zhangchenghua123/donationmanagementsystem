package sys.view.tableitem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import sys.view.GetResourceClass;

public class AnnounceItemLabel extends JLabel{

	public AnnounceItemLabel(String content){
		super(content);
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(350),GetResourceClass.getRealSize(30)));
		setFont(new Font("宋体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				setForeground(Color.black);
				repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setForeground(Color.red);
				repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
