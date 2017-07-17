package sys.view.nomanagerview;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import sys.GlobalVariables;
import sys.view.UpdatePasswordDialog;
import sys.view.tableitem.DoneeItemPanel;


public class PopupPanel extends JPopupMenu{

		
		JMenuItem lookInfoItem;
		JMenuItem updatePasswordItem;
		
		
		public  PopupPanel() {
			lookInfoItem=new JMenuItem("查看个人信息",JMenuItem.CENTER);
			lookInfoItem.setFont(new Font("黑体",Font.PLAIN,16));
			add(lookInfoItem);
			
			updatePasswordItem=new JMenuItem("修改秘密",JMenuItem.CENTER);
			updatePasswordItem.setFont(new Font("黑体",Font.PLAIN,16));
			add(updatePasswordItem);
			
			
			lookInfoItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new PersonalInfoPanel(),1);
				}
			});
			updatePasswordItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new UpdatePasswordDialog().setVisible(true);
				}
			});
		}
}
			
		

