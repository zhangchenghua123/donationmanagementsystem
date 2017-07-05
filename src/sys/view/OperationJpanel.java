package sys.view;

import java.awt.Color;

import javax.swing.JPanel;

public class OperationJpanel extends JPanel {

	public OperationJpanel() {
		setBounds(0,  GetResourceClass.getRealSize(85),  GetResourceClass.getRealSize(300),  GetResourceClass.getRealSize(300));//不可修改
		
		setBackground(new Color(32,137,202));
		setLayout(null);
	}
}
