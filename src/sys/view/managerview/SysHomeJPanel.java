package sys.view.managerview;

import java.awt.Color;

import javax.swing.JLabel;

import sys.view.GetResourceClass;

public class SysHomeJPanel extends JLabel {

	public SysHomeJPanel(){

		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setForeground(Color.white);
		add(new ManagerInfo());
		add(new TaskInfoLabel());
	}
	
}
