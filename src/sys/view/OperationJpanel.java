package sys.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;

import sys.GlobalVariables;
import sys.view.customView.ImagePanel;

public class OperationJpanel extends ModuleJPanel {

	//通用
	private JLabel nameJLabel;
	private ImagePanel backToHomePanel;
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
		
		if(GlobalVariables.userInfo.get("type").equals("系统管理员")){
			
			taskAssignPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/renwuweipai.png")));
			taskAssignPanel.setBounds(0, 50, 300, 50);
			taskAssignPanel.setOpaque(false);
			add(taskAssignPanel);
			
			anmtPublishPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/fabugonggao.png")));
			anmtPublishPanel.setBounds(0, 100, 300, 50);
			anmtPublishPanel.setOpaque(false);
			add(anmtPublishPanel);
			
		}
		else if(GlobalVariables.userInfo.get("type").equals("事例管理员")){
			fabuDoneePanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/fabushoujuan.png")));
			fabuDoneePanel.setBounds(0, 50, 300, 50);
			fabuDoneePanel.setOpaque(false);
			add(fabuDoneePanel);
			
			lookDoneeInfo=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/chakanjuanzhushili.png")));
			lookDoneeInfo.setBounds(0, 100, 300, 50);
			lookDoneeInfo.setOpaque(false);
			add(lookDoneeInfo);
			
		}
		else if(GlobalVariables.userInfo.get("type").equals("财务人员")){
			
			chuliDonationPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/chulijuanzhukuanxiang.png")));
			chuliDonationPanel.setBounds(0, 50, 300, 50);
			chuliDonationPanel.setOpaque(false);
			add(chuliDonationPanel);
			
			finalDealPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/chulishilizhuangtai.png")));
			finalDealPanel.setBounds(0, 100, 300, 50);
			finalDealPanel.setOpaque(false);
			add(finalDealPanel);
		}
		
		else if(GlobalVariables.userInfo.get("type").equals("捐助者")){
			lookAreadyDonatePanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/lookareadydonate.png")));
			lookAreadyDonatePanel.setBounds(0, 100, 300, 50);
			lookAreadyDonatePanel.setOpaque(false);
			add(lookAreadyDonatePanel);
			
			
			
		}
		
		
		updatePasswordPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/changepassword.png")));
		updatePasswordPanel.setBounds(0, 150, 300, 50);
		updatePasswordPanel.setOpaque(false);
		add(updatePasswordPanel);
		quitPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/quit.png")));
		quitPanel.setBounds(0, 200, 300, 50);
		quitPanel.setOpaque(false);
		add(quitPanel);
		backToHomePanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/backtohome.png")));
		backToHomePanel.setBounds(0, 250, 300, 50);
		backToHomePanel.setOpaque(false);
		add(backToHomePanel);
		
		quitPanel.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
//				GlobalVariables.frame.getContentPane().remove(1);
//				GlobalVariables.frame.getContentPane().add(
//					new EntranceJpanel(), 1);
//				GlobalVariables.frame.getContentPane().repaint();
			}
		});
	}
}
