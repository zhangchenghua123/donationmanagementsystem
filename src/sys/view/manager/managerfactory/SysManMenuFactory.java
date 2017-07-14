package sys.view.manager.managerfactory;

import javax.swing.JPanel;

import sys.view.manager.managerproduct.SysManMenuPanel;

public class SysManMenuFactory extends Factory {

	@Override
	public JPanel getMenuPanel() {
		// TODO Auto-generated method stub
		return new SysManMenuPanel();
	}
}
