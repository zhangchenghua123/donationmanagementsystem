package sys.view.nomanager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.model.objects.Donee;
import sys.model.objects.Donor;
import sys.presenter.BankCardPresenter;
import sys.presenter.DonationPresenter;
import sys.presenter.DoneePresenter;
import sys.presenter.DonorPresenter;
import sys.view.GetResourceClass;
import sys.view.LoginDialog;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.DoneeItemPanel;

public class DoneeDetailJPanel extends JPanel{

	private JLabel quitLabel;
	
	private ImagePanel picturePanel;//头像
	private JLabel nameLabel;//姓名
	private JLabel genderLabel;
	private JLabel birthdataLabel;
	private JLabel expectedLabel;
	private JLabel jinduLabel;
	private JPanel jindutiaoPanel;
	private JLabel baifenbiLabel;
	private JLabel haixujuanzhuLabel;
	private JLabel areadyjuanzhuLabel;
	private JLabel addressJLabel;
	
	private JLabel mainexperienceLabel;
	private JTextArea experienceArea;//经历
	private JScrollPane experienceScrollPane;
	
	private JLabel juanzhujiluLabel;
	private JTextArea jiluArea;//经历
	private JScrollPane jiluScrollPane;
	
	private JLabel donateLabel;
	
	private JLabel amountLabel;
	private JTextField amountField;
	private boolean isDonating=false;
	
	private ArrayList<Donation> donationList;
	private Donee donee;
	
	public DoneeDetailJPanel(String identity){
		setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(5), 
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(640));
		setLayout(null);
		setOpaque(false);
		System.out.println(identity);
		donee=DoneePresenter.getDonee(identity);
		
		quitLabel=new JLabel("关闭");
		quitLabel.setBounds(GetResourceClass.getRealSize(590), GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize( 40), GetResourceClass.getRealSize(20));
		quitLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		quitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(quitLabel);
		
		picturePanel=new ImagePanel(donee.getPic());
		picturePanel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30), 
				GetResourceClass.getRealSize(90),GetResourceClass.getRealSize(120));
		add(picturePanel);
		
		nameLabel=new JLabel(donee.getName());
		nameLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(35),
				GetResourceClass.getRealSize( 75), GetResourceClass.getRealSize(25));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(25)));
		add(nameLabel);
		
		jinduLabel=new JLabel("进度:");
		jinduLabel.setBounds(GetResourceClass.getRealSize(140),GetResourceClass.getRealSize(70), 
				GetResourceClass.getRealSize(52), GetResourceClass.getRealSize(14));
		jinduLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(jinduLabel);
		
		jindutiaoPanel=new JPanel();
		jindutiaoPanel.setOpaque(false);
		jindutiaoPanel.setBounds(GetResourceClass.getRealSize(190), GetResourceClass.getRealSize(70),
				GetResourceClass.getRealSize(112), GetResourceClass.getRealSize(15));
		int jindu=(int) (donee.getDonatedamount()/donee.getExpectedamount()*112);
		jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.green));
		add(jindutiaoPanel);
		
		baifenbiLabel=new JLabel((int)(donee.getDonatedamount()*100/donee.getExpectedamount())+"%");
		baifenbiLabel.setBounds(GetResourceClass.getRealSize(307), GetResourceClass.getRealSize(70), GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(14));
		baifenbiLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(baifenbiLabel);
		
		genderLabel=new JLabel("性别:"+donee.getGender());
		genderLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(94), 
				GetResourceClass.getRealSize(60), GetResourceClass.getRealSize(14));
		genderLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(genderLabel);
		
		String year=donee.getIdentity().substring(6, 10);
		String month=donee.getIdentity().substring(10,12);
		String day=donee.getIdentity().substring(12,14);
		birthdataLabel=new JLabel("出生年月:"+year+"-"+month+"-"+day);
		birthdataLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		birthdataLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(94), 
				GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(14));
		add(birthdataLabel);
		
		String s="<html>需要资助:&nbsp&nbsp&nbsp<font color='red'><b>"+donee.getExpectedamount()+"元</b></font>";
		expectedLabel=new JLabel(s);
		expectedLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(118), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		expectedLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(expectedLabel);
		
		float haixu=donee.getExpectedamount()-donee.getDonatedamount();
		String  s1="<html>还需资助:&nbsp&nbsp&nbsp<font color='red'><b>"+haixu+"元</b></font>";
		haixujuanzhuLabel=new JLabel(s1);
		haixujuanzhuLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(118), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		haixujuanzhuLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(haixujuanzhuLabel);
		
		float yijingjuanzhu=donee.getDonatedamount();
		String  s2="<html>已经资助:&nbsp&nbsp&nbsp<font color='red'><b>"+yijingjuanzhu+"元</b></font>";
		areadyjuanzhuLabel=new JLabel(s2);
		areadyjuanzhuLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(144),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		areadyjuanzhuLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(areadyjuanzhuLabel);
		
		addressJLabel=new JLabel("家庭住址："+donee.getAddress());
		addressJLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(144),
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(16));
		addressJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(addressJLabel);
		
		mainexperienceLabel=new JLabel("主要经历：",JLabel.CENTER);
		mainexperienceLabel.setBounds(GetResourceClass.getRealSize(25), GetResourceClass.getRealSize(200),
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(100));
		mainexperienceLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		mainexperienceLabel.setBorder(new MatteBorder(1, 1, 0, 0, new Color(150,241,241)));
		add(mainexperienceLabel);
		
		String experience=donee.getExperience();
		experienceArea=new JTextArea("  "+experience);
		experienceArea.setBounds(GetResourceClass.getRealSize(125), GetResourceClass.getRealSize(200), 
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		experienceArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		experienceArea.setEditable(false);
		experienceArea.setOpaque(true);
		experienceArea.setBackground(Color.white);
		experienceArea.setLineWrap(true);
		experienceArea.setBorder(new EmptyBorder(15, 15, 0, 15));
		experienceScrollPane=new JScrollPane(experienceArea);
		experienceScrollPane.setBounds(GetResourceClass.getRealSize(125), GetResourceClass.getRealSize(200), 
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		experienceScrollPane.setOpaque(false);
		experienceScrollPane.setForeground(Color.white);
		experienceScrollPane.setBorder(new MatteBorder(1, 1, 0, 1, new Color(150,241,241)));
		add(experienceScrollPane);
		
		juanzhujiluLabel=new JLabel("受助记录：",JLabel.CENTER);
		juanzhujiluLabel.setBounds(GetResourceClass.getRealSize(25), GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(100));
		juanzhujiluLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		juanzhujiluLabel.setBorder(new MatteBorder(1, 1, 1, 0, new Color(150,241,241)));
		add(juanzhujiluLabel);
		
		donationList=DonationPresenter.getDonationsByDonee(donee.getIdentity());
		jiluArea=new JTextArea();
		jiluArea.setBounds(GetResourceClass.getRealSize(125), GetResourceClass.getRealSize(300), 
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		jiluArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		jiluArea.setEditable(false);
		jiluArea.setOpaque(true);
		jiluArea.setBackground(Color.white);
		jiluArea.setLineWrap(true);
		jiluArea.setBorder(new EmptyBorder(15, 15, 0, 15));
		jiluScrollPane=new JScrollPane(jiluArea);
		jiluScrollPane.setBounds(GetResourceClass.getRealSize(125), GetResourceClass.getRealSize(300), 
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		jiluScrollPane.setOpaque(false);
		jiluScrollPane.setForeground(Color.white);
		jiluScrollPane.setBorder(new MatteBorder(1, 1, 1, 1, new Color(150,241,241)));
		add(jiluScrollPane);
		if(donationList.size()==0)
			jiluArea.setText("暂无记录");
		else{
			for(int i=0;i<donationList.size();i++){
				SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy/MM/dd");
				jiluArea.append("资助时间:"+myFmt1.format(donationList.get(i).getTime())+
						"   资助人:"+donationList.get(i).getDonorName()+
						"   资助金额："+donationList.get(i).getAmount()+"\n");
			}
		}
		donateLabel=new JLabel("我要捐助！",JLabel.CENTER);
		donateLabel.setBounds(GetResourceClass.getRealSize(245),GetResourceClass.getRealSize(440) ,
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
		donateLabel.setOpaque(true);
		donateLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		donateLabel.setBackground(new Color(102,205,0));
		donateLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //移上手型
		add(donateLabel);
		
		if(donee.getIsContinue()==0)
			donateLabel.setVisible(false);
		
		amountLabel=new JLabel("请输入捐助金额:");
		amountLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(440), 
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(25));
		amountLabel.setFont(new Font("黑体",Font.PLAIN,20));
		amountLabel.setVisible(false);
		add(amountLabel);
		
		amountField=new JTextField();
		amountField.setBounds(GetResourceClass.getRealSize(220), GetResourceClass.getRealSize(440), 
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(25));
		amountField.setVisible(false);
		add(amountField);
		
		quitLabel.addMouseListener(new MouseListener() {
			
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
				quitLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				quitLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DoneeInfoJpanel(),1);
			}
		});
		
		donateLabel.addMouseListener(new MouseListener() {
			
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
				if(GlobalVariables.userInfo==null){
					JOptionPane.showMessageDialog(null,"登陆后才能捐助");  
					return;
				}
				if(!isDonating){
					isDonating=true;
					amountLabel.setVisible(true);
					amountField.setVisible(true);
					donateLabel.setText("确定捐助");
					donateLabel.setBounds(GetResourceClass.getRealSize(400),GetResourceClass.getRealSize(432) ,
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
				}
				else{//此处应有数据验证
					
					Donation donation=new Donation();
					donation.setTime(new Date(new java.util.Date().getTime()));
					Donor donor=(Donor) GlobalVariables.userInfo.get("user");
					donation.setDonorAccount(donor.getAccount());
					donation.setDoneeIdentity(donee.getIdentity());
					donation.setAmount(Float.parseFloat(amountField.getText()));
					if(DonationPresenter.insert(donation)//插入捐助表
							){//平台银行卡余额
						System.out.println("捐助成功");
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DoneeDetailJPanel(donee.getIdentity()),1);
					}
				}
			}
		});
	}
}
