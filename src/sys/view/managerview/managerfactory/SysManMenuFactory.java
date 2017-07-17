package sys.view.managerview.managerfactory;

import javax.swing.JPanel;

import sys.view.managerview.system.SysManMenuPanel;

public class SysManMenuFactory extends Factory {

	@Override
	public JPanel getMenuPanel() {
		// TODO Auto-generated method stub
		return new SysManMenuPanel();
	}
}
