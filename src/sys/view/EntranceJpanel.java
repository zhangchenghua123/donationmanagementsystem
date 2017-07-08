package sys.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import sys.GlobalVariables;
import sys.model.AnnValues;
import sys.presenter.LoginPresenter;
import sys.presenter.Main;
import sys.view.customView.ImagePanel;
import sys.view.customView.MyComboBoxUI;
import sys.view.customView.TextInput;

public class EntranceJpanel extends JPanel {

	private boolean loginstate=false;
	private ImagePanel joinInDonorPanel;
	private JLabel loginJLabel;
	private JLabel passwordJLabel;
	private JLabel loginTypeJLabel;
	private JTextField accountField;// 输入的账户
	private JTextField passwordField;// 输入的密码
	private JComboBox type;
	// private ImagePanel loginPanel;
	private JButton loginButton;
	Font font1 = new Font("隶书", Font.PLAIN, GetResourceClass.getRealSize(30));
	Font font2 = new Font("隶书", Font.PLAIN, GetResourceClass.getRealSize(25));

	String[] types = new String[] { "系统管理员", "事例管理员", "财务人员", "伟大的捐助者" };

	public EntranceJpanel() {
		setBounds(0, GetResourceClass.getRealSize(85),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(300));// 不可修改

		
		setLayout(null);

		joinInDonorPanel = new ImagePanel(new ImageIcon(
				GetResourceClass.class.getResource("image/donor_register.png")));
		joinInDonorPanel.setBounds(0, 0, GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(80));
		joinInDonorPanel.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		loginJLabel = new JLabel("账号:");
		loginJLabel.setBounds(GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(80),
				GetResourceClass.getRealSize(80),
				GetResourceClass.getRealSize(50));
		loginJLabel.setFont(font1);

		accountField = new TextInput();
		accountField.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(85),
				GetResourceClass.getRealSize(190),
				GetResourceClass.getRealSize(40));
		accountField.setFont(font2);

		passwordJLabel = new JLabel("密码:");
		passwordJLabel.setBounds(GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(130),
				GetResourceClass.getRealSize(80),
				GetResourceClass.getRealSize(50));
		passwordJLabel.setFont(font1);

		passwordField = new TextInput();
		passwordField.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(135),
				GetResourceClass.getRealSize(190),
				GetResourceClass.getRealSize(40));
		passwordField.setFont(font2);

		loginTypeJLabel = new JLabel("您是:");
		loginTypeJLabel.setBounds(GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(185),
				GetResourceClass.getRealSize(80),
				GetResourceClass.getRealSize(50));
		loginTypeJLabel.setFont(font1);

		type = new JComboBox<>(types);
		type.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(185),
				GetResourceClass.getRealSize(195),
				GetResourceClass.getRealSize(50));
		type.setUI((ComboBoxUI) MyComboBoxUI.createUI(type));
		type.setFont(font2);

		// loginPanel=new ImagePanel(new
		// ImageIcon(GetResourceClass.class.getResource("image/login.png")));
		// loginPanel.setBounds(5, GetResourceClass.getRealSize(240),
		// GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(50));
		// loginPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		loginButton = new JButton("登录");
		loginButton.setBounds(5, GetResourceClass.getRealSize(240),
				GetResourceClass.getRealSize(290),
				GetResourceClass.getRealSize(50));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		joinInDonorPanel.addMouseListener(new MouseListener() {

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

				DonorRegisterDialog dialog = new DonorRegisterDialog(
						GlobalVariables.frame);
				dialog.setVisible(true);

			}
		});

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
				System.out.println(userType + userAccount + password);
				/**
				 * 判断用户名和密码是否为空，为空以对话框形式提示用户，都不为空将执行权交给LoginPresenter,
				 * LoginPresenter验证失败后提示用户，成功调用LoginPresenter的切换页面。
				 */
//				if (userAccount.equals("")) {
//					JOptionPane.showMessageDialog(
//							GlobalVariables.frame.getContentPane(), "账户不能为空!",
//							"系统信息", JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				else if(password.equals("")){
//					JOptionPane.showMessageDialog(
//							GlobalVariables.frame.getContentPane(), "密码不能为空!",
//							"系统信息", JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				
//				loginButton.setText("正在登录");
//				new Timer().schedule(new TimerTask() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						if(!loginstate){
							GlobalVariables.frame.getContentPane().remove(1);
							GlobalVariables.frame.getContentPane().add(
								new OperationJpanel(), 1);
							GlobalVariables.frame.getContentPane().repaint();
//						}
//					}
//				}, 2000);
//				if (LoginPresenter.login(userType, userAccount, password)) {
//					System.out.println(userType + "登录成功！账号是:" + userAccount
//							+ ",密码是:" + password);
//					loginstate=true;
//				} else {
//					JOptionPane.showMessageDialog(
//							GlobalVariables.frame.getContentPane(), "账号或密码错误!",
//							"系统信息", JOptionPane.INFORMATION_MESSAGE);
//					loginButton.setText("重新登录");
//					return;
//				}
//
			}
		});
		add(joinInDonorPanel);
		add(loginJLabel);
		add(accountField);
		add(passwordJLabel);
		add(passwordField);
		add(loginTypeJLabel);
		add(type);
		add(loginButton);

	}
}
