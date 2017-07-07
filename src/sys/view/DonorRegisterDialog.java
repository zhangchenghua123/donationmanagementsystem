package sys.view;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sys.view.customView.MyComboBoxUI;
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
	private MyComboBoxUI nationBox;//国籍
	private JLabel mailboxlLabel;
	private JTextField mailboxField;//邮箱
	private JLabel infoLabel;
	private JButton confirmButton;//确定按钮
	private JButton cancelButton;
	
	public DonorRegisterDialog(Frame owner){
		super(owner);
		setModal(true);
		setTitle("捐助者注册页面");
		setBounds(300, 300, 600, 400);
		
	}
}
