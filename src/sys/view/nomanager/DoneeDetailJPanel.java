package sys.view.nomanager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import sys.model.objects.Donee;
import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;

public class DoneeDetailJPanel extends JPanel{

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
	private JLabel tuijianrenyijianLabel;
	private JLabel shenhejieguoLabel;
	
	private Donee donee;
	
	public DoneeDetailJPanel(Donee donee){
		setBounds(300, 5, 895, 640);
		setLayout(null);
		setOpaque(false);
		
		picturePanel=new ImagePanel((ImageIcon) donee.getPic());
		picturePanel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(90),GetResourceClass.getRealSize(120));
		add(picturePanel);
		
		nameLabel=new JLabel(donee.getName());
		nameLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(35),GetResourceClass.getRealSize( 75), GetResourceClass.getRealSize(25));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(25)));
		add(nameLabel);
		
		jinduLabel=new JLabel("进度:");
		jinduLabel.setBounds(GetResourceClass.getRealSize(140),GetResourceClass.getRealSize(70), GetResourceClass.getRealSize(52), GetResourceClass.getRealSize(14));
		jinduLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(jinduLabel);
		
		jindutiaoPanel=new JPanel();
		jindutiaoPanel.setOpaque(false);
		jindutiaoPanel.setBounds(GetResourceClass.getRealSize(190), GetResourceClass.getRealSize(70), GetResourceClass.getRealSize(112), GetResourceClass.getRealSize(15));
		int jindu=(int) (donee.getDonatedamount()/donee.getExpectedamount())*112;
		jindutiaoPanel.setBorder(BorderFactory.createMatteBorder(1, GetResourceClass.getRealSize(jindu+1), 1, 1, Color.green));
		add(jindutiaoPanel);
		
		baifenbiLabel=new JLabel((int)(donee.getDonatedamount()*100/donee.getExpectedamount())+"%");
		baifenbiLabel.setBounds(GetResourceClass.getRealSize(307), GetResourceClass.getRealSize(70), GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(14));
		baifenbiLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(baifenbiLabel);
		
		genderLabel=new JLabel("性别:"+donee.getGender());
		genderLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(94), GetResourceClass.getRealSize(60), GetResourceClass.getRealSize(14));
		genderLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(genderLabel);
		
		String year=donee.getIdentity().substring(6, 10);
		String month=donee.getIdentity().substring(10,12);
		String day=donee.getIdentity().substring(12,14);
		birthdataLabel=new JLabel("出生年月:"+year+"-"+month+"-"+day);
		birthdataLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		birthdataLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(94), GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(14));
		add(birthdataLabel);
		
		String s="<html>需要资助:&nbsp&nbsp&nbsp<font color='red'><b>"+donee.getExpectedamount()+"元</b></font>";
		expectedLabel=new JLabel(s);
		expectedLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(118), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		expectedLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(expectedLabel);
		
		float haixu=donee.getExpectedamount()-donee.getDonatedamount();
		String  s1="<html>还需资助:&nbsp&nbsp&nbsp<font color='red'><b>"+haixu+"元</b></font>";
		haixujuanzhuLabel=new JLabel(s1);
		haixujuanzhuLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(118), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		haixujuanzhuLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(haixujuanzhuLabel);
		
		float yijingjuanzhu=donee.getDonatedamount();
		String  s2="<html>还需资助:&nbsp&nbsp&nbsp<font color='red'><b>"+yijingjuanzhu+"元</b></font>";
		areadyjuanzhuLabel=new JLabel(s1);
		areadyjuanzhuLabel.setBounds(GetResourceClass.getRealSize(140), GetResourceClass.getRealSize(144), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		areadyjuanzhuLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(areadyjuanzhuLabel);
		
		addressJLabel=new JLabel("家庭住址："+donee.getAddress());
		addressJLabel.setBounds(GetResourceClass.getRealSize(340), GetResourceClass.getRealSize(144), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(16));
		addressJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(addressJLabel);
		
		mainexperienceLabel=new JLabel("主要经历：");
		mainexperienceLabel.setBounds(GetResourceClass.getRealSize(25), GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(50));
		mainexperienceLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		mainexperienceLabel.setBorder(new MatteBorder(1, 1, 0, 0, new Color(150,241,241)));
		add(mainexperienceLabel);
		
		String experience=donee.getExperience();
		experienceArea=new JTextArea("  "+experience);
		experienceArea.setBounds(GetResourceClass.getRealSize(175), GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(50));
		experienceArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		experienceArea.setEditable(false);
		experienceArea.setOpaque(false);
		experienceArea.setLineWrap(true);
		System.out.println(experience.length()+"aaaaasss");
		add(experienceArea);
		
		
		
	}
}
