package sys.view.managerview.finance;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sys.GlobalVariables;
import sys.view.GetResourceClass;
import sys.view.managerview.MenuItemJlabel;
import sys.view.managerview.affair.AffairHomeJpanel;
import sys.view.managerview.managerfactory.MenuProduct;

public class FinManMenuPanel extends MenuProduct{

	// 财务人员
		private MenuItemJlabel homelabel;
		private MenuItemJlabel chuliDonationlabel;// 处理每一次捐助的转账
		private MenuItemJlabel finalDeallabel;// 募捐事例最终处理
		private MenuItemJlabel lastActiveItem;
		
		public FinManMenuPanel(){
			super();
			
			homelabel=new MenuItemJlabel("主页"); 
			homelabel.setForeground(Color.orange);
			lastActiveItem=homelabel;
			chuliDonationlabel=new MenuItemJlabel("处理捐助款项");
			finalDeallabel=new MenuItemJlabel("处理援助状态");
			
			add(homelabel);
			add(chuliDonationlabel);
			add(finalDeallabel);
			
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
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new FinHomeJPanel());
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
				}
			});
			chuliDonationlabel.addMouseListener(new MouseListener() {
				
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
					if(lastActiveItem==chuliDonationlabel)
						return;
					lastActiveItem.setForeground(Color.BLACK);
					chuliDonationlabel.setForeground(Color.orange);
					lastActiveItem=chuliDonationlabel;
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new DealDonationPanel());
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).validate();
				}
			});
			finalDeallabel.addMouseListener(new MouseListener() {
				
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
					if(lastActiveItem==finalDeallabel)
						return;
					lastActiveItem.setForeground(Color.BLACK);
					finalDeallabel.setForeground(Color.orange);
					lastActiveItem=finalDeallabel;
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).remove(1);
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).repaint();
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).add(new FinalDealPanel());
					((Container)GlobalVariables.frame.getContentPane().getComponent(1)).validate();
					
				}
			});
		}
}
