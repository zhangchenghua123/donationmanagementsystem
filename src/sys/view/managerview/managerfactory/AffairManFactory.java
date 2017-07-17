package sys.view.managerview.managerfactory;

import javax.swing.JPanel;

import sys.view.managerview.affair.AffairManMenuPanel;

public class AffairManFactory extends Factory {

	@Override
	public JPanel getMenuPanel() {
		// TODO Auto-generated method stub
		return new AffairManMenuPanel();
	}

}
