package sys.view.tableitem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import sys.GlobalVariables;
import sys.model.objects.Announcement;
import sys.view.GetResourceClass;
import sys.view.nomanager.AnmtDetailJPanel;

public class AnnounceItemLabel extends JLabel{

	
	public AnnounceItemLabel(final Announcement announcement){
		super(announcement.getTitle());
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(350),GetResourceClass.getRealSize(30)));
		setFont(new Font("宋体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(0, 5, 0, 5));
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
				System.out.println(GlobalVariables.frame.getContentPane().getComponent(1));
				Container container=(Container)GlobalVariables.frame.getContentPane().getComponent(1);
				if(container.getComponentCount()==3){
					container.getComponent(1).setVisible(false);
					container.getComponent(2).setVisible(false);
				}
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(AnmtDetailJPanel.getInstance());
				AnmtDetailJPanel.getInstance().setData(announcement);
				((Container)GlobalVariables.frame.getContentPane()).repaint();
			}
		});
	}
}
