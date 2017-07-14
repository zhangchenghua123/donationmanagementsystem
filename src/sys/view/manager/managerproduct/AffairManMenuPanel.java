package sys.view.manager.managerproduct;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sys.GlobalVariables;
import sys.view.GetResourceClass;
import sys.view.manager.AffairHomeJpanel;
import sys.view.manager.DoneePulishJPanel;
import sys.view.tableitem.MenuItemJlabel;

public class AffairManMenuPanel extends JPanel {

	
	private MenuItemJlabel homelabel;
	private MenuItemJlabel fabuDoneelabel;
	private MenuItemJlabel lookDoneeInfolabel;
	private MenuItemJlabel lastActiveItem;
	
	public AffairManMenuPanel(){
		setLayout(new FlowLayout(1,0,0));
		setBounds(GetResourceClass.getRealSize(15), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
		
		
		setBorder(new LineBorder(new Color(228,228,228),2));
		setBackground(new Color(250,250,250));
		
		homelabel=new MenuItemJlabel("主页"); 
		homelabel.setForeground(Color.orange);
		lastActiveItem=homelabel;
		fabuDoneelabel=new MenuItemJlabel("发布受捐信息");
		lookDoneeInfolabel=new MenuItemJlabel("查看捐助信息");
		
		add(homelabel);
		add(fabuDoneelabel);
		add(lookDoneeInfolabel);
		
		homelabel.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(lastActiveItem==homelabel)
					return;
				lastActiveItem.setForeground(Color.BLACK);
				fabuDoneelabel.setForeground(Color.orange);
				lastActiveItem=fabuDoneelabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new AffairHomeJpanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
			}
		});
		
		fabuDoneelabel.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(lastActiveItem==fabuDoneelabel)
					return;
				lastActiveItem.setForeground(Color.BLACK);
				fabuDoneelabel.setForeground(Color.orange);
				lastActiveItem=fabuDoneelabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new DoneePulishJPanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
			}
		});
		
	}
}
