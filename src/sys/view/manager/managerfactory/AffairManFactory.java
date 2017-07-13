package sys.view.manager.managerfactory;

import javax.swing.JPanel;

import sys.view.manager.managerproduct.AffairManMenuPanel;

public class AffairManFactory extends Factory {

	@Override
	public JPanel getMenuPanel() {
		// TODO Auto-generated method stub
		return new AffairManMenuPanel();
	}

}
