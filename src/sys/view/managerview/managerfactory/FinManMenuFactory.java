package sys.view.managerview.managerfactory;

import javax.swing.JPanel;

import sys.view.managerview.finance.FinManMenuPanel;

public class FinManMenuFactory extends Factory {

	@Override
	public JPanel getMenuPanel() {
		// TODO Auto-generated method stub
		return new FinManMenuPanel();
	}

}
