package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.model.objects.Donor;
import sys.presenter.DonationPresenter;
import sys.view.GetResourceClass;
import sys.view.UpdatePasswordDialog;
import sys.view.tableitem.DonationHistoryItemPanel;

public class PersonalInfoPanel extends JPanel {

	private JLabel nameJLabel;
	private JLabel accountLabel;
	private JLabel maiLabel;
	private JLabel tolAmountLabel;
	private JLabel updatePasswordLabel;
	private JLabel quitLabel;
	private JPanel donationsPanel;
	private JScrollPane scrollPane;
	private ArrayList<Donation> list;
	private Donor donor;
	public PersonalInfoPanel(){
		setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(895),
				GetResourceClass.getRealSize(640));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(160,160,160)));
		setBackground(Color.white);
		
		donor=(Donor) GlobalVariables.userInfo.get("user");
		list=DonationPresenter.getDonationsByDonor(donor.getAccount());
		nameJLabel=new JLabel("姓  名: "+donor.getName());
		nameJLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(200),
				GetResourceClass.getRealSize(25));
		nameJLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(nameJLabel);
		
		accountLabel=new JLabel("账  号: "+donor.getAccount());
		accountLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(200),
				GetResourceClass.getRealSize(25));
		accountLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(accountLabel);
		
		maiLabel=new JLabel("邮  箱: "+donor.getMailbox());
		maiLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		maiLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(maiLabel);
		
		tolAmountLabel=new JLabel("总捐助金额: "+donor.getTolMoney()+"元");
		tolAmountLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		tolAmountLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(tolAmountLabel);
		
		updatePasswordLabel=new JLabel("修改密码",JLabel.CENTER);
		updatePasswordLabel.setBounds(GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(25));
		updatePasswordLabel.setFont(new Font("黑体",Font.PLAIN,20));
		updatePasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(updatePasswordLabel);
		
		System.out.println(list.size());
		donationsPanel=new JPanel();
		donationsPanel.setOpaque(false);
		donationsPanel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(180), 
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(list.size()*40));
		donationsPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(list.size()*40)));
		for(int i=0;i<list.size();i++){
			
			DonationHistoryItemPanel itemPanel=new DonationHistoryItemPanel(list.get(i));
			donationsPanel.add(itemPanel);
		}
		scrollPane=new JScrollPane(donationsPanel);
		scrollPane.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(180), 
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(300));
		scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
//		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		add(scrollPane);
		updatePasswordLabel.addMouseListener(new MouseListener() {
			
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
				updatePasswordLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				updatePasswordLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new UpdatePasswordDialog().setVisible(true);
			}
		});
	}
}
