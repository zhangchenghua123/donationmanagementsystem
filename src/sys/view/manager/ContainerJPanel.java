package sys.view.manager;

import java.awt.Color;

import javax.swing.JPanel;

import sys.GlobalVariables;
import sys.view.tableitem.MenuItemJlabel;

public class ContainerJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ContainerJPanel(){
		setBounds(0, 100, 1200, 650);
		setLayout(null);
		setOpaque(true);
		setBackground(new Color(239,239,239));
		add(new MenuJPanel());
		String type=(String) GlobalVariables.userInfo.get("type");
		if(type.equals("系统管理员")){
			
			add(new SysHomeJPanel());
			
		}
		else if (type.equals("事例管理员")) {
			
			add(new AffairHomeJpanel());
		}
		else if(type.equals("财务人员")){
			
			add(new FinHomeJPanel());
		}
		
		
		setVisible(true);
	}
}
