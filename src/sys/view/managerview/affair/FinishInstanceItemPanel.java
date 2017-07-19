package sys.view.managerview.affair;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import sys.model.objects.Donee;
import sys.view.GetResourceClass;
/**
 * 卡片三中的募捐事例条目
 * @author Berry
 *
 */
public class FinishInstanceItemPanel extends JPanel {

	private JLabel nameLabel;//姓名
	private JLabel genderLabel;
	private JLabel birthdataLabel;
	private JLabel expectedLabel;
	private JLabel receivedLabel;
	private JLabel jinduLabel;
	private JPanel jindutiaoPanel;
	private JLabel baifenbiLabel;

	private Donee donee;
	
	public FinishInstanceItemPanel(final Donee donee){
		this.donee=donee;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(80)));
		setBorder(new MatteBorder(1, 0, 1, 0, new Color(238,238,238)));
		
		
		
		nameLabel=new JLabel(donee.getName()+"("+donee.getIdentity()+")");
		nameLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(15),
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(25));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(nameLabel);
		String experience=donee.getExperience();
		
		
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
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(20));
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
		jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.green));
		add(jindutiaoPanel);
//		
		int baifenbi=(int) (donee.getDonatedamount()*100/donee.getExpectedamount());
		if(baifenbi>100)
			baifenbi=100;
		baifenbiLabel=new JLabel(baifenbi+"%");
		baifenbiLabel.setBounds(GetResourceClass.getRealSize(515), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(16));
		baifenbiLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(baifenbiLabel);
//		
	}
}
