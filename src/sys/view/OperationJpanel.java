package sys.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;

import sys.view.customView.ImagePanel;

public class OperationJpanel extends ModuleJPanel {

	//通用
	private JLabel nameJLabel;
	private ImagePanel updatePasswordPanel;
	private ImagePanel quitPanel;
	//捐助者
	private ImagePanel lookAreadyDonatePanel;
	//系统管理员
	private ImagePanel taskAssignPanel;
	private ImagePanel anmtPublishPanel;
	//事例管理员
	private ImagePanel fabuDoneePanel;
	private ImagePanel lookDoneeInfo;
	//财务人员
	private ImagePanel chuliDonationPanel;//处理每一次捐助的转账
	private ImagePanel finalDealPanel;//募捐事例最终处理

	public OperationJpanel() {
		setName("OperationJpanel");
		setBounds(0,  GetResourceClass.getRealSize(80),  GetResourceClass.getRealSize(300),  GetResourceClass.getRealSize(300));//不可修改
		setLayout(null);
//		 setBackground(new Color(191,223,225));
		lookAreadyDonatePanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/lookareadydonate.png")));
		lookAreadyDonatePanel.setBounds(5, 100, 290, 50);
		lookAreadyDonatePanel.setOpaque(false);
		add(lookAreadyDonatePanel);
	}
}
