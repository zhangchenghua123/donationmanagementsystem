package sys.view.managerview.affair;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import sys.GlobalVariables;
import sys.model.objects.AffairManager;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;
import sys.view.managerview.ManagerInfo;
/**
 * 事例管理员登录进去后的主页
 * @author Berry
 *
 */
public class AffairHomeJpanel extends JLabel {
	
	private JLabel tolDoneeNoLabel;
	private JLabel tolExpectedAmountLabel;
	private JLabel tolDonationAmountLabel;
	private JLabel continueCountLabel;
	private JLabel stopCountLabel;
	private JLabel finishCountLabel;
	private int taskId;
	
	public AffairHomeJpanel(){
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setForeground(Color.white);
		add(new ManagerInfo());
		taskId=((AffairManager)(GlobalVariables.userInfo.get("user"))).getTaskId();
		tolDoneeNoLabel=new JLabel("总发布受捐者人数: "+DoneePresenter.getCountByTaskId(taskId));
		tolDoneeNoLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(30),
				GetResourceClass.getRealSize(500),
				GetResourceClass.getRealSize(25));
		tolDoneeNoLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(tolDoneeNoLabel);
		
		tolExpectedAmountLabel=new JLabel("总期望金额: "+DoneePresenter.getTolExpectedAmountByTaskId(taskId)+"元");
		tolExpectedAmountLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		tolExpectedAmountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(tolExpectedAmountLabel);
		
		tolDonationAmountLabel=new JLabel("总捐助金额:"+DoneePresenter.getTolDonatedAmountByTaskId(taskId)+"元");
		tolDonationAmountLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		tolDonationAmountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(tolDonationAmountLabel);
		
		continueCountLabel=new JLabel("正在募捐中人数: "+DoneePresenter.getDoneeByCondition(taskId, "continue").size());
		continueCountLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		continueCountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(continueCountLabel);
		
		stopCountLabel=new JLabel("募捐已停止人数: "+DoneePresenter.getDoneeByCondition(taskId, "stop").size());
		stopCountLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		stopCountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(stopCountLabel);
		
		finishCountLabel=new JLabel("已成功援助人数: "+DoneePresenter.getDoneeByCondition(taskId, "finish").size());
		finishCountLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(180),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		finishCountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(finishCountLabel);
	}
}
