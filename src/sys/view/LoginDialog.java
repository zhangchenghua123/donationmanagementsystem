package sys.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;

import sys.GlobalVariables;
import sys.presenter.LoginPresenter;
import sys.view.customview.ImagePanel;
import sys.view.customview.MyComboBoxUI;
import sys.view.customview.TextInput;

public class LoginDialog extends JDialog {

	private JLabel loginJLabel;
	private JTextField accountField;// 输入的账户
	private JLabel passwordJLabel;
	private JTextField passwordField;// 输入的密码
	private JLabel loginTypeJLabel;
	private JComboBox type;
	private JButton loginButton;
	private JLabel infoLabel;
	public static boolean loginState=false;
	
	public static int MANAGER_LOGIN=1;
	public static int DONOR_LOGIN=2;
	public static int WHO=0;

	
	Font font1 = new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(16));
	Font font2 = new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(20));

	String[] types = new String[] { "系统管理员", "事例管理员", "财务人员", "捐助者" };

	public LoginDialog() {
		setModal(true);
		setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(200),
				GetResourceClass.getRealSize(360),
				GetResourceClass.getRealSize(240));// 不可修改

		setLayout(null);
		setTitle("登录");
		
		loginJLabel = new JLabel("账号:");
		loginJLabel.setBounds(GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(20));
		loginJLabel.setFont(font1);
		add(loginJLabel);

		accountField = new TextInput();
		accountField.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(25));
		accountField.setFont(font2);

		passwordJLabel = new JLabel("密码:");
		passwordJLabel.setBounds(GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(20));
		passwordJLabel.setFont(font1);

		passwordField = new TextInput();
		passwordField.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(25));
		passwordField.setFont(font2);

		loginTypeJLabel = new JLabel("您是:");
		loginTypeJLabel.setBounds(GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(20));
		loginTypeJLabel.setFont(font1);

		type = new JComboBox<>(types);
		type.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(25));
		type.setUI((ComboBoxUI) MyComboBoxUI.createUI(type));
		type.setFont(font2);


		loginButton = new JButton("登录");
		loginButton.setBounds(GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(40));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		infoLabel=new JLabel("");
		infoLabel.setForeground(Color.red);
		add(infoLabel);
		
		loginButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// ignore
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ignore
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// ignore
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// ignore
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				String userType = type.getSelectedItem().toString();
				String userAccount = accountField.getText();
				String password = passwordField.getText();
				if (userAccount.equals("")) {
					infoLabel.setText("请输入用户名");
					infoLabel.setBounds(GetResourceClass.getRealSize(255), GetResourceClass.getRealSize(30),
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				} else if (password.equals("")) {
					infoLabel.setText("请输入密码");
					infoLabel.setBounds(GetResourceClass.getRealSize(255), GetResourceClass.getRealSize(60), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				loginButton.setText("正在登录");
				if(LoginPresenter.login(userType, userAccount, password)) {
					WHO=userType.equals("捐助者")?DONOR_LOGIN:MANAGER_LOGIN;
					loginSuccess();
				}
				else {
					infoLabel.setText("账号或密码错误");
					infoLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(5),
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					loginButton.setText("登录");
				}
			}
		});
		add(loginJLabel);
		add(accountField);
		add(passwordJLabel);
		add(passwordField);
		add(loginTypeJLabel);
		add(type);
		add(loginButton);

	}
	private void loginSuccess(){
		loginState=true;
		this.setVisible(false);
	}
}
