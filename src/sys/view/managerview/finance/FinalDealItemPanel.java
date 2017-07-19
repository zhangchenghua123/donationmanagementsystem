package sys.view.managerview.finance;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.model.objects.Donee;
import sys.presenter.DonationPresenter;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;

public class FinalDealItemPanel extends JPanel {

	private JCheckBox checkBox;
	private JLabel nameLabel;//姓名
	private JLabel genderLabel;
	private JLabel birthdataLabel;
	private JLabel expectedLabel;
	private JLabel receivedLabel;
	private JLabel jinduLabel;
	private JPanel jindutiaoPanel;
	private JLabel baifenbiLabel;
	
	private JLabel finishLabel;
	private Donee donee;
	
	public FinalDealItemPanel(final Donee donee,final ArrayList<Donee> selectedList){
		this.donee=donee;
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
		
		nameLabel=new JLabel(donee.getName()+"("+donee.getIdentity()+")");
		nameLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(15),
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(25));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(nameLabel);
		
		genderLabel=new JLabel("性别:"+donee.getGender());
		genderLabel.setBounds(GetResourceClass.getRealSize(350), GetResourceClass.getRealSize(15), 
				GetResourceClass.getRealSize(60), GetResourceClass.getRealSize(20));
		genderLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(15)));
		add(genderLabel);
		
		String year=donee.getIdentity().substring(6, 10);
		String month=donee.getIdentity().substring(10,12);
		String day=donee.getIdentity().substring(12,14);
		birthdataLabel=new JLabel("出生年月:"+year+"-"+month+"-"+day);
		birthdataLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(15)));
		birthdataLabel.setBounds(GetResourceClass.getRealSize(420), GetResourceClass.getRealSize(15), 
				GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(20));
		add(birthdataLabel);
//		
		String s="<html>需要资助:&nbsp&nbsp&nbsp<font color='red'><b>"+donee.getExpectedamount()+"元</b></font>";
		expectedLabel=new JLabel(s);
		expectedLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(50), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		expectedLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(expectedLabel);
		
		String s1="<html>已发放资金:&nbsp&nbsp&nbsp<font color='red'><b>"+donee.getReceivedamount()+"元</b></font>";
		receivedLabel=new JLabel(s1);
		receivedLabel.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(50), 
				GetResourceClass.getRealSize(170), GetResourceClass.getRealSize(16));
		receivedLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(receivedLabel);
		
		jinduLabel=new JLabel("进度:");
		jinduLabel.setBounds(GetResourceClass.getRealSize(370),GetResourceClass.getRealSize(50), 
				GetResourceClass.getRealSize(52), GetResourceClass.getRealSize(16));
		jinduLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(jinduLabel);
//		
		jindutiaoPanel=new JPanel();
		jindutiaoPanel.setOpaque(false);
		jindutiaoPanel.setBounds(GetResourceClass.getRealSize(430), GetResourceClass.getRealSize(50), 
				GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(16));
		int jindu=(int) (donee.getDonatedamount()/donee.getExpectedamount()*80);
		if(donee.getReceivedamount()<donee.getExpectedamount())
			jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.yellow));
		else
			jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.green));
		add(jindutiaoPanel);
//		
		baifenbiLabel=new JLabel((int)(donee.getDonatedamount()*100/donee.getExpectedamount())+"%");
		baifenbiLabel.setBounds(GetResourceClass.getRealSize(515), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(16));
		baifenbiLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(baifenbiLabel);
		
		finishLabel=new JLabel("结束募捐事例");
		finishLabel.setBounds(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
		finishLabel.setFont(new Font("黑体",Font.PLAIN,16));
		finishLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(finishLabel);
		
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(checkBox)){
					if(checkBox.isSelected()){
						selectedList.add(donee);
					}
					else {
						selectedList.remove(donee);
					}
					
					
					System.out.println("复选框变化了");
					for(int i=0;i<selectedList.size();i++){
						
						System.out.println("选中项"+i+"  "+ selectedList.get(i).getExpectedamount());
					}
				
					if(selectedList.size()==0)
						((FinalDealPanel)(FinalDealItemPanel.this.getParent().getParent())).closeSwitch();
					else
						((FinalDealPanel)(FinalDealItemPanel.this.getParent().getParent())).openSitch();
				}
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
				finishLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				finishLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				selectedList.add(donee);
				if(DoneePresenter.updateFinish(selectedList)){
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
					((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new FinalDealPanel(),1);
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