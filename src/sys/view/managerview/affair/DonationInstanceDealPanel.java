package sys.view.managerview.affair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import sun.net.www.content.image.jpeg;
import sys.GlobalVariables;
import sys.model.objects.Donee;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
/**
 * 事例管理员登陆后的查看捐助事例窗口
 * 类似于卡片布局，
 * 卡片一：仍在募捐中（continue=1）   ，全选（全不选），停止募捐选中项，
 * 卡片二：募捐停止（continue=0）  ，没有按钮，等待财务人员结账，处理援助状态
 * 卡片三：募捐事例完结，，，没有按钮，没有可选框
 * @author Berry
 *
 */
public class DonationInstanceDealPanel extends JPanel {
	
	private JPanel headPanel;
	private JLabel continueLabel;
	private JLabel stopLabel;
	private JLabel finishLabel;
	private JLabel lastActiveLabel;
	
	
	public DonationInstanceDealPanel(){
		
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));  //设置jpanel区域
		setLayout(null);      //流式布局
		setOpaque(true);  //不透明
		setBackground(Color.white);  //背景白
		setForeground(Color.white);  //前景色白
		
		headPanel=new JPanel();
		headPanel.setBounds(0, GetResourceClass.getRealSize(10), GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(40));
		headPanel.setLayout(null);
		headPanel.setOpaque(false);
		
		continueLabel=new JLabel("捐助进行中",JLabel.CENTER);
		continueLabel.setBounds(GetResourceClass.getRealSize(10),GetResourceClass.getRealSize(10), 
				GetResourceClass.getRealSize(100),GetResourceClass.getRealSize( 28));
		continueLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		continueLabel.setOpaque(true);
		continueLabel.setBackground(Color.blue);
		continueLabel.setForeground(Color.white);
		continueLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headPanel.add(continueLabel);
		lastActiveLabel=continueLabel;
		
		stopLabel=new JLabel("捐助停止中",JLabel.CENTER);
		stopLabel.setBounds(GetResourceClass.getRealSize(120),GetResourceClass.getRealSize(10), 
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(28));
		stopLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		stopLabel.setOpaque(true);
		stopLabel.setBackground(Color.white);
		stopLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headPanel.add(stopLabel);
		
		finishLabel=new JLabel("捐助已结束",JLabel.CENTER);
		finishLabel.setBounds(GetResourceClass.getRealSize(230),GetResourceClass.getRealSize(10), 
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(28));
		finishLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		finishLabel.setOpaque(true);
		finishLabel.setBackground(Color.white);
		finishLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headPanel.add(finishLabel);
		
		headPanel.setBorder(new MatteBorder(0, 0, 2, 0, Color.blue));
	
		add(headPanel);
		add(new ContinueInstancePanel());
		continueLabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveLabel==continueLabel)
					return;
				lastActiveLabel.setBackground(Color.white);
				lastActiveLabel.setForeground(Color.black);
				continueLabel.setBackground(Color.blue);
				continueLabel.setForeground(Color.white);
				lastActiveLabel=continueLabel;
				
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).remove(1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).repaint();
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).add(new ContinueInstancePanel(),1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).validate();
			}
		});
		stopLabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveLabel==stopLabel)
					return;
				lastActiveLabel.setBackground(Color.white);
				lastActiveLabel.setForeground(Color.black);
				stopLabel.setBackground(Color.blue);
				stopLabel.setForeground(Color.white);
				lastActiveLabel=stopLabel;
				
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).remove(1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).repaint();
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).add(new StopInstancePanel(),1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).validate();
			}
		});
		finishLabel.addMouseListener(new MouseListener() {
			
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
				if(lastActiveLabel==finishLabel)
					return;
				lastActiveLabel.setBackground(Color.white);
				lastActiveLabel.setForeground(Color.black);
				finishLabel.setBackground(Color.blue);
				finishLabel.setForeground(Color.white);
				lastActiveLabel=finishLabel;
				
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).remove(1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).repaint();
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).add(new FinishInstancePanel(),1);
				((Container)(((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).getComponent(1))).validate();
			}
		});
		
	}
	
}
