package sys.view.managerview.finance;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.model.objects.Donee;
import sys.presenter.DonationPresenter;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;

public class FinalDealPanel extends JPanel {
	private JLabel checkAllLabel;
	private JLabel finishAllLabel;
	private JLabel infoJLabel;
	private JPanel doneesPanel;
	
	private ArrayList<Donee> allCanFinishDonees;
	private ArrayList<Donee> selectedList;
	public FinalDealPanel(){
		
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));  //设置jpanel区域
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		
		allCanFinishDonees=DoneePresenter.getDoneeByCondition(0, "canfinish");
		if(allCanFinishDonees==null||allCanFinishDonees!=null&&allCanFinishDonees.size()==0){
			infoJLabel=new JLabel("暂无数据");
			infoJLabel.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(30));
			infoJLabel.setFont(new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(20)));
			add(infoJLabel);
		} else {
			
			selectedList=new ArrayList<Donee>();
			
			doneesPanel = new JPanel();
			doneesPanel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(20), 
					GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(500));
			doneesPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(500)));
			doneesPanel.setOpaque(false);
			doneesPanel.setLayout(new FlowLayout(1, 0, 0));
			add(doneesPanel);
			
			
			for(int i=0;i<allCanFinishDonees.size();i++){
				FinalDealItemPanel itemPanel=new FinalDealItemPanel(allCanFinishDonees.get(i), selectedList);
				doneesPanel.add(itemPanel);
			}
			validate();
			
			checkAllLabel=new JLabel("全选",JLabel.CENTER);
			checkAllLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(540),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(20));
			checkAllLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
			checkAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			add(checkAllLabel);
			
			finishAllLabel=new JLabel("结束所选募捐事例",JLabel.CENTER);
			finishAllLabel.setBounds(GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(540),
					GetResourceClass.getRealSize(150),
					GetResourceClass.getRealSize(20));
			finishAllLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
			finishAllLabel.setForeground(Color.gray);
			finishAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			add(finishAllLabel);
			
			checkAllLabel.addMouseListener(new MouseListener() {
				
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
					if(checkAllLabel.getText().equals("全选")){
						for(int i=0;i<doneesPanel.getComponentCount();i++){
						((FinalDealItemPanel)(doneesPanel.getComponent(i))).setSelected();
						}
						selectedList=allCanFinishDonees;
						checkAllLabel.setText("全不选");
					}
					else{//全不选
						
						for(int i=0;i<doneesPanel.getComponentCount();i++){
							((FinalDealItemPanel)(doneesPanel.getComponent(i))).setUnSelected();
						}
						selectedList=new ArrayList<Donee>();
						checkAllLabel.setText("全选");
					}
				}
			});
			finishAllLabel.addMouseListener(new MouseListener() {
				
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
					if(finishAllLabel.getForeground().equals(Color.gray))
						return;
					finishAllLabel.setForeground(Color.black);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					if(finishAllLabel.getForeground().equals(Color.gray))
						return;
					finishAllLabel.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(finishAllLabel.getForeground().equals(Color.gray))
						return;
					if(DoneePresenter.updateFinish(selectedList)){
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new FinalDealPanel(),1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).validate();
					}
				}
			});
		}

	}
	public void openSitch(){
		finishAllLabel.setForeground(Color.black);
	}
	public void closeSwitch(){
		finishAllLabel.setForeground(Color.gray);
	}
}