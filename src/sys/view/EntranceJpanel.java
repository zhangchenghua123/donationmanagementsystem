package sys.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;


import sys.GetResourceClass;
import sys.action.Main;
import sys.view.customView.ImagePanel;
import sys.view.customView.TextInput;

public class EntranceJpanel extends JPanel{

	private ImagePanel joinInDonorPanel;
	private JLabel loginJLabel;
	private JLabel passwordJLabel;
	private JLabel donorLoginJLabel;
	private JLabel loginTypeJLabel;
	private JTextField accountField;
	private JTextField passwordField;
	private JComboBox type;
	private ImagePanel loginPanel;
	Font font1=new Font("宋体", Font.PLAIN, 30);
	Font font2=new Font("宋体", Font.PLAIN, 25);
	
	String[] types=new String[]{"系统管理员","事例管理员","财务人员","伟大的捐助者"};
	
	public EntranceJpanel() {
		setBounds(0, 85, 300, 300);
		
//		setBackground(new Color(32,137,202));
		setLayout(null);
		
		joinInDonorPanel=new ImagePanel(GetResourceClass.class.getResource("image/donor_register.png"));
		joinInDonorPanel.setBounds(0, 0, 300, 80);
		joinInDonorPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		loginJLabel=new JLabel("账号:");
		loginJLabel.setBounds(5, 80, 80, 50);
		loginJLabel.setFont(font1);
		
		accountField=new TextInput();
		accountField.setBounds(100, 85, 200, 40);
		accountField.setFont(font2);
		
		passwordJLabel=new JLabel("密码:");
		passwordJLabel.setBounds(5, 130, 80, 50);
		passwordJLabel.setFont(font1);
		
		passwordField=new TextInput();
		passwordField.setBounds(100, 135, 200, 40);
		passwordField.setFont(font2);
		
		loginTypeJLabel=new JLabel("您是:");
		loginTypeJLabel.setBounds(5, 185, 80, 50);
		loginTypeJLabel.setFont(font1);
		
		type=new JComboBox<>(types);
		type.setBounds(100, 185, 195, 50);
		type.setUI((ComboBoxUI) MyComboBoxUI.createUI(type));
		type.setFont(font2);
		
		loginPanel=new ImagePanel(GetResourceClass.class.getResource("image/login.png"));
		loginPanel.setBounds(0, 240, 300, 50);
		add(joinInDonorPanel);
		add(loginJLabel);
		add(accountField);
		add(passwordJLabel);
		add(passwordField);
		add(loginTypeJLabel);
		add(type);
		add(loginPanel);
		
	}
	static class MyComboBoxUI extends BasicComboBoxUI {
	    public static ComponentUI createUI(JComponent c) {
	      return new MyComboBoxUI();
	    }

	    protected JButton createArrowButton() {
	      JButton button = new BasicArrowButton(BasicArrowButton.SOUTH);
	      return button;
	    }
	  }
}
