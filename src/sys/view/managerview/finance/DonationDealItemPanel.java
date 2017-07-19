package sys.view.managerview.finance;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.model.objects.Donee;
import sys.presenter.DonationPresenter;
import sys.view.GetResourceClass;
import sys.view.managerview.affair.ContinueInstancePanel;

public class DonationDealItemPanel extends JPanel {

	private JCheckBox checkBox;
	private JLabel timeJLabel;
	private JLabel doneeNameJLabel;
	private JLabel donorNameJLabel;
	private JLabel moneyLabel;
	private JLabel grantLabel;
	private Donation donation;
	
	public DonationDealItemPanel(final Donation donation,final ArrayList<Donation> selectedList){
		this.donation=donation;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(80)));
		setBorder(new MatteBorder(1, 0, 1, 0, new Color(238,238,238)));
		
		checkBox=new JCheckBox("");
		checkBox.setBounds(0, GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(20));
		checkBox.setOpaque(false);
		add(checkBox);
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy/MM/dd");
		timeJLabel=new JLabel(myFmt1.format(donation.getTime()));
		timeJLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(15),
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(25));
		timeJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(timeJLabel);
		
		String s="<html>资助金额: &nbsp&nbsp&nbsp<font color='red'><b>"+donation.getAmount()+"元</b></font>";
		moneyLabel=new JLabel(s);
		moneyLabel.setBounds(GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(15),
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(16));
		moneyLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(moneyLabel);
		
		donorNameJLabel=new JLabel("捐助人:"+donation.getDonorName()+"("+donation.getDonorAccount()+")");
		donorNameJLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(25));
		donorNameJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(donorNameJLabel);
		
		doneeNameJLabel=new JLabel("受助人:"+donation.getDoneeName()+"("+donation.getDoneeIdentity()+")");
		doneeNameJLabel.setBounds(GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(25));
		doneeNameJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(doneeNameJLabel);
		
		grantLabel=new JLabel("发放捐助款");
		grantLabel.setBounds(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
		grantLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		grantLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(grantLabel);
		
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(checkBox)){
					if(checkBox.isSelected())
						selectedList.add(donation);    //勾选上，添加进集合
					else 
						selectedList.remove(donation); //从集合中移出
					if(selectedList.size()==0)         //都没选
						((DealDonationPanel)(DonationDealItemPanel.this.getParent().getParent())).closeSwitch();
					else                               //至少有一个选上了
						((DealDonationPanel)(DonationDealItemPanel.this.getParent().getParent())).openSitch();
				}
			}
		});
		
		grantLabel.addMouseListener(new MouseListener() {
			
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
				grantLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				grantLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Donation> list=new ArrayList<>();
				list.add(donation);
				if(DonationPresenter.updateState(list)){
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DealDonationPanel(),1);
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).validate();
				}
			}
		});
		
	}
	public void setSelected(){
		checkBox.setSelected(true);
	}
	public void setUnSelected(){
		checkBox.setSelected(false);
	}
}
