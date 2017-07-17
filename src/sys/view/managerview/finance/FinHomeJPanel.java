package sys.view.managerview.finance;

import java.awt.Color;

import javax.swing.JPanel;

import sys.view.GetResourceClass;
import sys.view.managerview.ManagerInfo;

/**
 * 财务人员的主页
 * 
 * @author Berry
 * 
 */
public class FinHomeJPanel extends JPanel {

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
	}
}
