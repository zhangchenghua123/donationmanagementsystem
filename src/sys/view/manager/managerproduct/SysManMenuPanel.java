package sys.view.manager.managerproduct;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sys.GlobalVariables;
import sys.view.GetResourceClass;
import sys.view.manager.AnmtPublishJPanel;
import sys.view.manager.SysHomeJPanel;
import sys.view.manager.TaskDelegateJPanel;
import sys.view.tableitem.MenuItemJlabel;

public class SysManMenuPanel extends JPanel {

	private MenuItemJlabel homelabel;
	private MenuItemJlabel taskAssignlabel;
	private MenuItemJlabel anmtPublishlabel;
	private MenuItemJlabel lastActiveItem;
	
	public SysManMenuPanel(){
		setLayout(new FlowLayout(1,0,0));
		setBounds(GetResourceClass.getRealSize(15), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
		setBorder(new LineBorder(new Color(228,228,228),2));
		setBackground(new Color(250,250,250));
		
		homelabel=new MenuItemJlabel("主页"); 
		homelabel.setForeground(Color.orange);
		lastActiveItem=homelabel;
		taskAssignlabel=new MenuItemJlabel("任务新建及委派");
		anmtPublishlabel=new MenuItemJlabel("发布公告");
		
		add(taskAssignlabel);
		add(homelabel);
		add(anmtPublishlabel);
		
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
				taskAssignlabel.setForeground(Color.orange);
				lastActiveItem=taskAssignlabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new SysHomeJPanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
			}
		});
		taskAssignlabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveItem==taskAssignlabel)
					return;
				lastActiveItem.setForeground(Color.BLACK);
				taskAssignlabel.setForeground(Color.orange);
				lastActiveItem=taskAssignlabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new TaskDelegateJPanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
			}
		});
		
		anmtPublishlabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveItem==anmtPublishlabel)
					return;
				lastActiveItem.setForeground(Color.BLACK);
				anmtPublishlabel.setForeground(Color.orange);
				lastActiveItem=anmtPublishlabel;
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new AnmtPublishJPanel());
				((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
			}
		});
	}
}
