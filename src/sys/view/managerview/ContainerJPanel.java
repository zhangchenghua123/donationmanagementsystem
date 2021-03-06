package sys.view.managerview;

import java.awt.Color;

import javax.swing.JPanel;

import sys.GlobalVariables;
import sys.view.GetResourceClass;
import sys.view.managerview.affair.AffairHomeJpanel;
import sys.view.managerview.finance.FinHomeJPanel;
import sys.view.managerview.managerfactory.AffairManFactory;
import sys.view.managerview.managerfactory.FinManMenuFactory;
import sys.view.managerview.managerfactory.SysManMenuFactory;
import sys.view.managerview.system.SysHomeJPanel;
/**
 * 管理人员登录后，根据存储的静态用户信息，显示页面
 * @author Berry
 *
 */
public class ContainerJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ContainerJPanel(){
		setBounds(0, GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(650));
		setLayout(null);
		setOpaque(true);
		setBackground(new Color(239,239,239));
		
		//根据类型，选择对应的菜单栏和主页
		String type=(String) GlobalVariables.userInfo.get("type");
		if(type.equals("系统管理员")){
			add(new SysManMenuFactory().getMenuPanel());
			add(new SysHomeJPanel());
			
		}
		else if (type.equals("事例管理员")) {
			add(new AffairManFactory().getMenuPanel());
			add(new AffairHomeJpanel());
		}
		else if(type.equals("财务人员")){
			add(new FinManMenuFactory().getMenuPanel());
			add(new FinHomeJPanel());
		}
		setVisible(true);
	}
}
