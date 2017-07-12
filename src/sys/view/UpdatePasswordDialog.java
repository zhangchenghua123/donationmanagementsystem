package sys.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.omg.CORBA.PUBLIC_MEMBER;

import sys.GlobalVariables;
import sys.presenter.AffairManagerPresenter;
import sys.presenter.DonorPresenter;
import sys.presenter.FinManagerPresenter;
import sys.presenter.LoginPresenter;
import sys.presenter.SystemManagerPresenter;
import sys.view.customView.TextInput;

public class UpdatePasswordDialog extends JDialog {

	private JLabel label1;
	private JLabel label2;
	private TextInput newPsd;
	private TextInput confirm;
	private JLabel info;
	private JButton queding;
	Font font1 = new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(16));
	Font font2 = new Font("黑体", Font.PLAIN, GetResourceClass.getRealSize(20));
	String userType = (String) GlobalVariables.userInfo.get("type");
	boolean result=false;
	public UpdatePasswordDialog() {
		setModal(true);
		setBounds(300, GetResourceClass.getRealSize(200),
				GetResourceClass.getRealSize(360),
				GetResourceClass.getRealSize(240));// 不可修改

		setLayout(null);

		label1 = new JLabel("新密码:");
		label1.setBounds(GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(20));
		label1.setFont(font1);
		add(label1);

		newPsd = new TextInput();
		newPsd.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(25));
		newPsd.setFont(font2);
		add(newPsd);
		label2 = new JLabel("再输一遍:");
		label2.setBounds(GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(20));
		label2.setFont(font1);
		add(label2);

		confirm = new TextInput();
		confirm.setBounds(GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(25));
		confirm.setFont(font2);
		add(confirm);
		
		queding = new JButton("确定");
		queding.setBounds(GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(100),
				GetResourceClass.getRealSize(40));
		queding.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(queding);
		
		info=new JLabel("");
		info.setForeground(Color.red);
		add(info);
		
		
		queding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

				String userType = (String) GlobalVariables.userInfo.get("type");
				String newpsd = newPsd.getText();
				String confirmpsd = confirm.getText();
				/**
				 * 判断用户名和密码是否为空，为空以对话框形式提示用户，都不为空将执行权交给LoginPresenter,
				 * LoginPresenter验证失败后提示用户，成功调用LoginPresenter的切换页面。
				 */
				if (newpsd.equals("")) {
					info.setText("请输入新密码");
					info.setBounds(200, 30, 150, 20);
					info.repaint();
					return;
				} else if (confirmpsd.equals("")) {
					info.setText("请输入密码");
					info.setBounds(200, 60, 150, 20);
					info.repaint();
					return;
				}
				else if(!newpsd.equals(confirmpsd)){
					info.setText("两次密码不一致");
					info.setBounds(5, 5, 150, 20);
					info.repaint();
					return;
				}
				queding.setText("正在修改");
				if (userType.equals("系统管理员")){
					result=SystemManagerPresenter.updatePassword(newpsd);
				}
				else if(userType.equals("事例管理员")){
					result=AffairManagerPresenter.updatePassword(newpsd);
				}
				else if(userType.equals("财务人员")){
					result=FinManagerPresenter.updatePassword(newpsd);
				}
				else if(userType.equals("捐助者")){
					result=DonorPresenter.updatePassword(newpsd);
				}
				queding.setText("确定");
				if(result){
					info.setText("密码修改成功！");
					info.setBounds(5, 5, 150, 20);
					info.repaint();
					return;
				}
				else {
					info.setText("密码修改失败！");
					info.setBounds(5, 5, 150, 20);
					info.repaint();
					return;
				}
			}
		});
		
	}

}
