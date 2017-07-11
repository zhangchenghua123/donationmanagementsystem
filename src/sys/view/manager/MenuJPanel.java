package sys.view.manager;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sys.GlobalVariables;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.MenuItemJlabel;

public class MenuJPanel extends JPanel {

	// 通用
	private MenuItemJlabel homelabel;
	private MenuItemJlabel quitlabel;
	// 系统管理员
	private MenuItemJlabel taskAssignlabel;
	private MenuItemJlabel anmtPublishlabel;
	// 事例管理员
	private MenuItemJlabel fabuDoneelabel;
	private MenuItemJlabel lookDoneeInfolabel;
	// 财务人员
	private MenuItemJlabel chuliDonationlabel;// 处理每一次捐助的转账
	private MenuItemJlabel finalDeallabel;// 募捐事例最终处理
	
	private MenuItemJlabel lastActiveItem;
	
	private String type; 
	private Object user;
	public MenuJPanel(){
		setBounds(15, 30, 240, 400);
		setLayout(new FlowLayout(1,0,0));
		setBorder(new LineBorder(new Color(228,228,228),2));
		setBackground(new Color(250,250,250));
		homelabel=new MenuItemJlabel("主页"); 
		homelabel.setForeground(Color.orange);
		lastActiveItem=homelabel;
		add(homelabel);
		
//		type=(String) GlobalVariables.userInfo.get("type");
//		if(type.equals("系统管理员")){
//			user=GlobalVariables.userInfo.get("user");
			
			taskAssignlabel=new MenuItemJlabel("任务新建及委派");
			add(taskAssignlabel);
			
			anmtPublishlabel=new MenuItemJlabel("发布公告");
			add(anmtPublishlabel);
			
//		}
		
		
		quitlabel=new MenuItemJlabel("退出");
		add(quitlabel);
		
		
	}
}
