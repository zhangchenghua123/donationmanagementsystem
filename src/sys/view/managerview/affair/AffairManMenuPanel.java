package sys.view.managerview.affair;

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
import sys.view.managerview.MenuItemJlabel;
import sys.view.managerview.managerfactory.MenuProduct;
/**
 * 事例管理员左侧菜单栏
 * @author Berry
 *
 */
public class AffairManMenuPanel extends MenuProduct {

	
	private MenuItemJlabel homelabel;
	private MenuItemJlabel fabuDoneelabel;
	private MenuItemJlabel lookDoneeInfolabel;
	private MenuItemJlabel lastActiveItem;
	
	public AffairManMenuPanel(){
		super();
		homelabel=new MenuItemJlabel("主页"); 
		homelabel.setForeground(Color.orange);
		lastActiveItem=homelabel;
		fabuDoneelabel=new MenuItemJlabel("发布受捐信息");
		lookDoneeInfolabel=new MenuItemJlabel("查看捐助事例");
		
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
				homelabel.setForeground(Color.orange);
				lastActiveItem=homelabel;
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
		lookDoneeInfolabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveItem==lookDoneeInfolabel)
					return;
				lastActiveItem.setForeground(Color.BLACK);
				lookDoneeInfolabel.setForeground(Color.orange);
				lastActiveItem=lookDoneeInfolabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new DonationInstanceDealPanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).validate();
				
			}
		});
		
	}
}
