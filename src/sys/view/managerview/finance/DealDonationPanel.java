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

import sun.net.www.content.image.jpeg;
import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.presenter.DonationPresenter;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;
/**
 * 
 * @author Berry
 *
 */
public class DealDonationPanel extends JPanel {

	private JLabel checkAllLabel;
	private JLabel grantAllDonationLabel;
	private JLabel infoJLabel;
	private JPanel donationsPanel;
	
	private ArrayList<Donation> allNotPaidDonations;
	private ArrayList<Donation> selectedList;
	public DealDonationPanel(){
		
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));  //设置jpanel区域
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		
		allNotPaidDonations=DonationPresenter.getAllNotPaid();
		if(allNotPaidDonations==null||allNotPaidDonations!=null&&allNotPaidDonations.size()==0){
			infoJLabel=new JLabel("暂无数据");
			infoJLabel.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(30));
			infoJLabel.setFont(new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(20)));
			add(infoJLabel);
		} else {
			
			selectedList=new ArrayList<Donation>();
			
			donationsPanel = new JPanel();
			donationsPanel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(20), 
					GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(500));
			donationsPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(800), 
					GetResourceClass.getRealSize(500)));
			donationsPanel.setOpaque(false);
			donationsPanel.setLayout(new FlowLayout(1, 0, 0));
			add(donationsPanel);
			
			
			for(int i=0;i<allNotPaidDonations.size();i++){
				DonationDealItemPanel itemPanel=new DonationDealItemPanel(allNotPaidDonations.get(i), selectedList);
				donationsPanel.add(itemPanel);
			}
			validate();
			
			checkAllLabel=new JLabel("全选",JLabel.CENTER);
			checkAllLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(540),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(20));
			checkAllLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
			checkAllLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			add(checkAllLabel);
			
			grantAllDonationLabel=new JLabel("落实所有选中项",JLabel.CENTER);
			grantAllDonationLabel.setBounds(GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(540),
					GetResourceClass.getRealSize(150),
					GetResourceClass.getRealSize(20));
			grantAllDonationLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
			grantAllDonationLabel.setForeground(Color.gray);
			grantAllDonationLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			add(grantAllDonationLabel);
			
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
						for(int i=0;i<donationsPanel.getComponentCount();i++){
						((DonationDealItemPanel)(donationsPanel.getComponent(i))).setSelected();
						}
						selectedList=allNotPaidDonations;
						checkAllLabel.setText("全不选");
					}
					else{//全不选
						
						for(int i=0;i<donationsPanel.getComponentCount();i++){
							((DonationDealItemPanel)(donationsPanel.getComponent(i))).setUnSelected();
						}
						selectedList=new ArrayList<Donation>();
						checkAllLabel.setText("全选");
					}
				}
			});
			grantAllDonationLabel.addMouseListener(new MouseListener() {
				
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
					if(grantAllDonationLabel.getForeground().equals(Color.gray))
						return;
					grantAllDonationLabel.setForeground(Color.black);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					if(grantAllDonationLabel.getForeground().equals(Color.gray))
						return;
					grantAllDonationLabel.setForeground(Color.blue);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(grantAllDonationLabel.getForeground().equals(Color.gray))
						return;
					if(DonationPresenter.updateState(selectedList)){
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DealDonationPanel(),1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).validate();
					}
				}
			});
		}

	}
	public void openSitch(){
		grantAllDonationLabel.setForeground(Color.black);
	}
	public void closeSwitch(){
		grantAllDonationLabel.setForeground(Color.gray);
	}
}
