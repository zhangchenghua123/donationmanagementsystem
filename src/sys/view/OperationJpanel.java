package sys.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;

import sys.view.customView.ImagePanel;

public class OperationJpanel extends ModuleJPanel {

	private JLabel nameJLabel;
	private ImagePanel lookAreadyDonatePanel;
	private ImagePanel updatePasswordPanel;
	public OperationJpanel() {
		setName("OperationJpanel");
		setBounds(0,  GetResourceClass.getRealSize(85),  GetResourceClass.getRealSize(300),  GetResourceClass.getRealSize(300));//不可修改
		setLayout(null);
		lookAreadyDonatePanel=new ImagePanel(GetResourceClass.class.getResource("image/lookareadydonate.png"));
		lookAreadyDonatePanel.setBounds(0, 0, 300, 50);
		add(lookAreadyDonatePanel);
	}
}
