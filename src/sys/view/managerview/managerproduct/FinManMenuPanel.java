package sys.view.managerview.managerproduct;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sys.view.GetResourceClass;
import sys.view.tableitem.MenuItemJlabel;

public class FinManMenuPanel extends JPanel{

	// 财务人员
		private MenuItemJlabel homelabel;
		private MenuItemJlabel chuliDonationlabel;// 处理每一次捐助的转账
		private MenuItemJlabel finalDeallabel;// 募捐事例最终处理
		private MenuItemJlabel lastActiveItem;
		
		public FinManMenuPanel(){
			setLayout(new FlowLayout(1,0,0));
			setBounds(GetResourceClass.getRealSize(15), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
			
			
			setBorder(new LineBorder(new Color(228,228,228),2));
			setBackground(new Color(250,250,250));
			
			homelabel=new MenuItemJlabel("主页"); 
			homelabel.setForeground(Color.orange);
			lastActiveItem=homelabel;
			chuliDonationlabel=new MenuItemJlabel("处理捐助款项");
			finalDeallabel=new MenuItemJlabel("处理援助状态");
			
			add(homelabel);
			add(chuliDonationlabel);
			add(finalDeallabel);
		}
}
