package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.text.html.ImageView;

import sys.GlobalVariables;
import sys.model.objects.Donor;
import sys.model.objects.Nationality;
import sys.presenter.DonorPresenter;
import sys.presenter.NationPresenter;
import sys.view.DataVerifyTool;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
import sys.view.customview.MyComboBoxUI;
import sys.view.customview.TextInput;
/**
 * 用户点击确认按钮时，先验证要填的信息有没有空的，再验证两次密码一致否，再验证账号是否重复，再验证邮箱是否重复，如有错误，用infoLabel高亮提示，
 * 如果用户通过验证后，再弹出模式对话框，提示用户是否立即登录，
 * 用户选择是后，设置state的值为LOGIN,关闭这俩对话框。
 * 选择否，也关闭这俩对话框。
 * @author Berry
 *
 */
public class DonorRegisterDialog extends JDialog {

	public static int state=0;
	public static int Quit=0;
	public static int LOGIN=1;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	private JLabel accountLabel;
	private JTextField accountField;//账号
	private JLabel passwordLabel;
	private JTextField passwordField;//密码
	private JLabel passwordConfirmLabel;
	private JTextField passwordConfirmField;//密码确认
	private JLabel nameLabel;
	private JTextField nameField;//姓名
	private JLabel nationLabel;
	private JComboBox nationBox;//国籍
	private JLabel mailboxlLabel;
	private JTextField mailboxField;//邮箱
	private JLabel infoLabel;
	private JButton confirmButton;//确定按钮
	private JButton cancelButton;
	
//	Matcher m = p.matcher(email);
	
	public DonorRegisterDialog(Frame owner){
		super(owner);
		setModal(true);
		setTitle("捐助者注册页面");
		setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(300), 
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(400));
		setLayout(null);
		
		accountLabel=new JLabel("账户(任何长度不为零的字符串):");
		accountLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		accountLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30), 
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(20));
		add(accountLabel);
		
		accountField=new TextInput();
		accountField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		accountField.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(30), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(25));
		add(accountField);
		
		passwordLabel=new JLabel("密码(任何长度不为零的字符串):");
		passwordLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(60), 
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(20));
		passwordLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(passwordLabel);
		
		passwordField=new TextInput();
		passwordField.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(25));
		passwordField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(passwordField);
		
		passwordConfirmLabel=new JLabel("确认密码:");
		passwordConfirmLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
		passwordConfirmLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(passwordConfirmLabel);
		
		passwordConfirmField=new TextInput();
		passwordConfirmField.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(90), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(25));
		passwordConfirmField.setToolTipText("");
		passwordConfirmField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(passwordConfirmField);
		
		nameLabel=new JLabel("姓名(任何长度不为零的字符串):");
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		nameLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(120), 
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(20));
		add(nameLabel);
		
		nameField=new TextInput();
		nameField.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(120), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(25));
		nameField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(nameField);
		
		nationLabel=new JLabel("所属国籍:");
		nationLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		nationLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(150), 
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(20));
		add(nationLabel);
		
		final ArrayList<Nationality> nationsList=NationPresenter.getAll();
		String[] nations=new String[nationsList.size()];
		
		for(int i=0;i<nations.length;i++){
			nations[i]=nationsList.get(i).getNation();
		}
		nationBox = new JComboBox<>(nations);
		nationBox.setBounds(GetResourceClass.getRealSize(300),GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(150),GetResourceClass.getRealSize(20));
		nationBox.setUI((ComboBoxUI) MyComboBoxUI.createUI(nationBox));
		nationBox.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(nationBox);
		
		mailboxlLabel=new JLabel("邮箱:");
		mailboxlLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		mailboxlLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(180),
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(20));
		add(mailboxlLabel);
		
		mailboxField=new TextInput();
		mailboxField.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(180), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(25));
		mailboxField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(mailboxField);
		
		infoLabel=new JLabel("");
//		infoLabel.setBounds(460, 30, 150, 20);
		infoLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		infoLabel.setForeground(Color.red);
		add(infoLabel);
		
		confirmButton=new JButton("提交注册信息");
		confirmButton.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(240), 
				GetResourceClass.getRealSize(180), GetResourceClass.getRealSize(30));
		confirmButton.setForeground(Color.green);
		confirmButton.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(confirmButton);
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(accountField.getText().equals("")){
					infoLabel.setText("请输入账号");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(30), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(passwordField.getText().equals("")){
					infoLabel.setText("请输入密码");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(60), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(passwordConfirmField.getText().equals("")){
					infoLabel.setText("请确认密码");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(90),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(nameField.getText().equals("")){
					infoLabel.setText("请输入姓名");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(120),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(mailboxField.getText().equals("")){
					infoLabel.setText("请确认邮箱");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(180), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(!passwordField.getText().equals(passwordConfirmField.getText())){
					infoLabel.setText("两次密码不一致");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(90), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(!new DataVerifyTool().verifyMail((mailboxField.getText()))){
					infoLabel.setText("邮箱格式不正确");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(180), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(DonorPresenter.accountExisted(accountField.getText())){
					infoLabel.setText("该账号已存在");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(30), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(DonorPresenter.emailRepeated(mailboxField.getText())){
					infoLabel.setText("该邮箱已注册过");
					infoLabel.setBounds(GetResourceClass.getRealSize(460), GetResourceClass.getRealSize(180), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				
				infoLabel.setText("");
				infoLabel.repaint();
				Donor donor=new Donor();
				donor.setAccount(accountField.getText());
				donor.setName(nameField.getText());
				donor.setMailbox(mailboxField.getText());
				donor.setNationID(nationsList.get(nationBox.getSelectedIndex()).getNationID());
				donor.setPassword(passwordField.getText());
				donor.setTolMoney(0);
				if(DonorPresenter.register(donor)){
					DonorRegisterDialog.this.setVisible(false);
					JLabel label=new JLabel("恭喜注册成功！\n现在以此注册的账号登录吗？");
					label.setFont(new Font("黑体",Font.PLAIN,16));
					int n = JOptionPane.showConfirmDialog(null, label, "注册成功", JOptionPane.YES_NO_OPTION);  
			        if (n == JOptionPane.YES_OPTION) {  
			             DonorPresenter.login(donor.getAccount(), donor.getPassword());
			             state=LOGIN;
			        } else if (n == JOptionPane.NO_OPTION) {  
			             System.out.println("点击了取消按钮");
			             state=Quit;
			        }  
				}
			}
		});
	}
}
