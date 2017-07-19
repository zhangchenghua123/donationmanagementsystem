package sys.view.managerview.finance;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.model.objects.PlatformBankCard;
import sys.presenter.BankCardPresenter;
import sys.view.GetResourceClass;
import sys.view.managerview.ManagerInfo;

/**
 * 财务人员的主页
 * 
 * @author Berry
 * 
 */
public class FinHomeJPanel extends JPanel {

	private JLabel cardnoJLabel;
	private JLabel balanceLabel;
	private JLabel tolDonationLabel;
	
	private PlatformBankCard card;
	public FinHomeJPanel() {
		
		setBounds(GetResourceClass.getRealSize(270),
				GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setForeground(Color.white);
		add(new ManagerInfo());
		
		card=BankCardPresenter.getCard();
		
		cardnoJLabel=new JLabel("平台银行卡卡号:"+card.getCardNo());
		cardnoJLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(60),
				GetResourceClass.getRealSize(500),
				GetResourceClass.getRealSize(25));
		cardnoJLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(cardnoJLabel);
		
		balanceLabel=new JLabel("平台银行卡余额:"+card.getBalance()+"元");
		balanceLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(90),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		balanceLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(balanceLabel);
		
		tolDonationLabel=new JLabel("总捐助金额:"+card.getTolDonation()+"元");
		tolDonationLabel.setBounds(GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(120),
				GetResourceClass.getRealSize(300),
				GetResourceClass.getRealSize(25));
		tolDonationLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(tolDonationLabel);
		
	}
}




















