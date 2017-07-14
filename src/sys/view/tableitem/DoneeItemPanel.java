package sys.view.tableitem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import sys.GlobalVariables;
import sys.model.objects.Donee;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
import sys.view.nomanagerview.DoneeDetailJPanel;

public class DoneeItemPanel extends JPanel{

	private int id;
	private ImagePanel picturePanel;//头像
	private JLabel nameLabel;//姓名
	private JLabel lookDetailLabel;//查看详情
	private JTextArea experienceArea;//经历
	private JLabel genderLabel;
	private JLabel birthdataLabel;
	private JLabel expectedLabel;
	private JLabel jinduLabel;
	private JPanel jindutiaoPanel;
	private JLabel baifenbiLabel;
	private JLabel haixujuanzhuLabel;
	
	private Donee donee;
	
	public DoneeItemPanel(Donee donee){
		this.donee=donee;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(140)));
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(238,238,238), new Color(238,238,238)));
		
		picturePanel=new ImagePanel((ImageIcon) donee.getPic());
		picturePanel.setBounds(GetResourceClass.getRealSize(10), GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(90),GetResourceClass.getRealSize(120));
		add(picturePanel);
		
		nameLabel=new JLabel(donee.getName());
		nameLabel.setBounds(GetResourceClass.getRealSize(120), GetResourceClass.getRealSize(15),
				GetResourceClass.getRealSize( 75), GetResourceClass.getRealSize(25));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(25)));
		add(nameLabel);
		
		lookDetailLabel=new JLabel("查看详情 >>");
		lookDetailLabel.setBounds(GetResourceClass.getRealSize(400), GetResourceClass.getRealSize(15), 
				GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(18));
		lookDetailLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		lookDetailLabel.setForeground(Color.black);
		lookDetailLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(lookDetailLabel);
		
		String experience=donee.getExperience();
		experienceArea=new JTextArea(experience.length()>60?experience.substring(0, 61)+"...":experience);
		experienceArea.setBounds(GetResourceClass.getRealSize(120), GetResourceClass.getRealSize(50), 
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(30));
		experienceArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		experienceArea.setRows(2);
		experienceArea.setEditable(false);
		experienceArea.setOpaque(false);
		experienceArea.setLineWrap(true);
		add(experienceArea);
		
		genderLabel=new JLabel("性别:"+donee.getGender());
		genderLabel.setBounds(GetResourceClass.getRealSize(120), GetResourceClass.getRealSize(90), 
				GetResourceClass.getRealSize(60), GetResourceClass.getRealSize(14));
		genderLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(genderLabel);
		
		String year=donee.getIdentity().substring(6, 10);
		String month=donee.getIdentity().substring(10,12);
		String day=donee.getIdentity().substring(12,14);
		birthdataLabel=new JLabel("出生年月:"+year+"-"+month+"-"+day);
		birthdataLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		birthdataLabel.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(90), 
				GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(14));
		add(birthdataLabel);
		
		String s="<html>需要资助:&nbsp&nbsp&nbsp<font color='red'><b>"+donee.getExpectedamount()+"元</b></font>";
		expectedLabel=new JLabel(s);
		expectedLabel.setBounds(GetResourceClass.getRealSize(400), GetResourceClass.getRealSize(90), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		expectedLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(expectedLabel);
		
		jinduLabel=new JLabel("进度:");
		jinduLabel.setBounds(GetResourceClass.getRealSize(120),GetResourceClass.getRealSize(112), 
				GetResourceClass.getRealSize(52), GetResourceClass.getRealSize(14));
		jinduLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(jinduLabel);
		
		jindutiaoPanel=new JPanel();
		jindutiaoPanel.setOpaque(false);
		jindutiaoPanel.setBounds(GetResourceClass.getRealSize(170), GetResourceClass.getRealSize(112), 
				GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(15));
		int jindu=(int) (donee.getDonatedamount()/donee.getExpectedamount()*80);
		jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.green));
		add(jindutiaoPanel);
		
		baifenbiLabel=new JLabel((int)(donee.getDonatedamount()*100/donee.getExpectedamount())+"%");
		baifenbiLabel.setBounds(GetResourceClass.getRealSize(255), GetResourceClass.getRealSize(112),
				GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(14));
		baifenbiLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(baifenbiLabel);
		
		float haixu=donee.getExpectedamount()-donee.getDonatedamount();
		String  s1="<html>还需资助:&nbsp&nbsp&nbsp<font color='red'><b>"+haixu+"元</b></font>";
		haixujuanzhuLabel=new JLabel(s1);
		haixujuanzhuLabel.setBounds(GetResourceClass.getRealSize(320), GetResourceClass.getRealSize(112), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		haixujuanzhuLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(haixujuanzhuLabel);
		
		setVisible(true);
		
		lookDetailLabel.addMouseListener(new MouseListener() {
			
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
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DoneeDetailJPanel(DoneeItemPanel.this.donee.getIdentity()),1);
			}
		});
	}
}
