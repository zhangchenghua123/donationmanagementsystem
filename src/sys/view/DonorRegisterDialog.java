package sys.view;

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
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.text.html.ImageView;

import sys.GlobalVariables;
import sys.model.objects.Nationality;
import sys.presenter.NationPresenter;
import sys.view.customView.ImagePanel;
import sys.view.customView.MyComboBoxUI;
import sys.view.customView.TextInput;
/**
 * 用户点击确认按钮时，先验证要填的信息有没有空的，再验证两次密码一致否，再验证账号是否重复，再验证邮箱是否重复，如有错误，用infoLabel高亮提示，
 * 如果用户通过验证后，再弹出模式对话框，提示用户是否立即登录，
 * 用户选择是后，设置state的值为LOGIN,关闭这俩对话框。
 * 选择否，也关闭这俩对话框。
 * @author Berry
 *
 */
public class DonorRegisterDialog extends JDialog {

	private int state=0;
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
	String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	Pattern p = Pattern.compile(str);
//	Matcher m = p.matcher(email);
	
	public DonorRegisterDialog(Frame owner){
		super(owner);
		setModal(true);
		setTitle("捐助者注册页面");
		setBounds(300, 300, 600, 400);
		setLayout(null);
		
		accountLabel=new JLabel("账户(任何长度不为零的字符串):");
		accountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		accountLabel.setBounds(30, 30, 300, 20);
		add(accountLabel);
		
		accountField=new TextInput();
		accountField.setFont(new Font("黑体",Font.PLAIN,20));
		accountField.setBounds(300, 30, 150, 25);
		add(accountField);
		
		passwordLabel=new JLabel("密码(任何长度不为零的字符串):");
		passwordLabel.setBounds(30, 60, 300, 20);
		passwordLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(passwordLabel);
		
		passwordField=new TextInput();
		passwordField.setBounds(300, 60, 150, 25);
		passwordField.setFont(new Font("黑体",Font.PLAIN,20));
		add(passwordField);
		
		passwordConfirmLabel=new JLabel("确认密码:");
		passwordConfirmLabel.setBounds(30, 90, 100, 20);
		passwordConfirmLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(passwordConfirmLabel);
		
		passwordConfirmField=new TextInput();
		passwordConfirmField.setBounds(300, 90, 150, 25);
		passwordConfirmField.setToolTipText("");
		passwordConfirmField.setFont(new Font("黑体",Font.PLAIN,20));
		add(passwordConfirmField);
		
		nameLabel=new JLabel("姓名(任何长度不为零的字符串):");
		nameLabel.setFont(new Font("黑体",Font.PLAIN,16));
		nameLabel.setBounds(30, 120, 300, 20);
		add(nameLabel);
		
		nameField=new TextInput();
		nameField.setBounds(300, 120, 150, 25);
		nameField.setFont(new Font("黑体",Font.PLAIN,20));
		add(nameField);
		
		nationLabel=new JLabel("所属国籍:");
		nationLabel.setFont(new Font("黑体",Font.PLAIN,16));
		nationLabel.setBounds(30, 150, 300, 20);
		add(nationLabel);
		
		ArrayList<Nationality> nationsList=new NationPresenter().getAll();
//		String[] nations=new String[nationsList.size()];
		
//		for(int i=0;i<nations.length;i++){
//			nations[i]=nationsList.get(i).getNation();
//		}
//		nationBox = new JComboBox<>(nations);
//		nationBox.setBounds(300,150,150,20);
//		nationBox.setUI((ComboBoxUI) MyComboBoxUI.createUI(nationBox));
//		nationBox.setFont(new Font("黑体",Font.PLAIN,20));
//		add(nationBox);
		
		mailboxlLabel=new JLabel("邮箱:");
		mailboxlLabel.setFont(new Font("黑体",Font.PLAIN,16));
		mailboxlLabel.setBounds(30, 180, 300, 20);
		add(mailboxlLabel);
		
		mailboxField=new TextInput();
		mailboxField.setBounds(300, 180, 150, 25);
		mailboxField.setFont(new Font("黑体",Font.PLAIN,20));
		add(mailboxField);
		
		infoLabel=new JLabel("");
//		infoLabel.setBounds(460, 30, 150, 20);
		infoLabel.setFont(new Font("黑体",Font.PLAIN,16));
		infoLabel.setForeground(Color.red);
		add(infoLabel);
		
		confirmButton=new JButton("提交注册信息");
		confirmButton.setBounds(200, 240, 180, 30);
		confirmButton.setForeground(Color.green);
		confirmButton.setFont(new Font("黑体",Font.PLAIN,20));
		add(confirmButton);
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(accountField.getText().equals("")){
					infoLabel.setText("请输入账号");
					infoLabel.setBounds(460, 30, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(passwordField.getText().equals("")){
					infoLabel.setText("请输入密码");
					infoLabel.setBounds(460, 60, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(passwordConfirmField.getText().equals("")){
					infoLabel.setText("请确认密码");
					infoLabel.setBounds(460, 90, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(nameField.getText().equals("")){
					infoLabel.setText("请确认姓名");
					infoLabel.setBounds(460, 120, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(mailboxField.getText().equals("")){
					infoLabel.setText("请确认邮箱");
					infoLabel.setBounds(460, 180, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(!passwordField.getText().equals(passwordConfirmField.getText())){
					infoLabel.setText("两次密码不一致");
					infoLabel.setBounds(460, 90, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(!p.matcher(mailboxField.getText()).matches()){
					infoLabel.setText("邮箱格式不正确");
					infoLabel.setBounds(460, 180, 150, 20);
					infoLabel.repaint();
					return;
				}
				infoLabel.setText("");
				infoLabel.repaint();
				
				
				
			}
		});
	}
}
