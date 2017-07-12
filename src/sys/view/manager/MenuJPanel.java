package sys.view.manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sys.GlobalVariables;
import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.MenuItemJlabel;

public class MenuJPanel extends JPanel {

	// 通用
	private MenuItemJlabel homelabel;
	private MenuItemJlabel quitlabel;
	// 系统管理员
	private MenuItemJlabel taskAssignlabel;
	private MenuItemJlabel anmtPublishlabel;
	// 事例管理员
	private MenuItemJlabel fabuDoneelabel;
	private MenuItemJlabel lookDoneeInfolabel;
	// 财务人员
	private MenuItemJlabel chuliDonationlabel;// 处理每一次捐助的转账
	private MenuItemJlabel finalDeallabel;// 募捐事例最终处理
	
	private MenuItemJlabel lastActiveItem;
	
	private String type; 
	private Object user;
	public MenuJPanel(){
		setLayout(new FlowLayout(1,0,0));
		setBounds(GetResourceClass.getRealSize(15), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
		
		
		setBorder(new LineBorder(new Color(228,228,228),2));
		setBackground(new Color(250,250,250));
		
		homelabel=new MenuItemJlabel("主页"); 
		homelabel.setForeground(Color.orange);
		lastActiveItem=homelabel;
		add(homelabel);
		
		type=(String) GlobalVariables.userInfo.get("type");
		user=GlobalVariables.userInfo.get("user");
		if(type.equals("系统管理员")){
			
			taskAssignlabel=new MenuItemJlabel("任务新建及委派");
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
			add(taskAssignlabel);
			
			anmtPublishlabel=new MenuItemJlabel("发布公告");
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
			add(anmtPublishlabel);
			
		}
		else if (type.equals("事例管理员")) {
			
			fabuDoneelabel=new MenuItemJlabel("发布受捐信息");
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
			add(fabuDoneelabel);
			
			lookDoneeInfolabel=new MenuItemJlabel("查看捐助信息");
			add(lookDoneeInfolabel);
		}
		else if(type.equals("财务人员")){
			chuliDonationlabel=new MenuItemJlabel("处理捐助款项");
			add(chuliDonationlabel);
			
			finalDeallabel=new MenuItemJlabel("处理援助状态");
			add(finalDeallabel);
		}
		
		
		quitlabel=new MenuItemJlabel("退出");
		add(quitlabel);
		setSize(GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
		repaint();
	}
}
