package sys.view.nomanagerview;

import java.awt.Color;

import javax.swing.JPanel;

import sys.view.GetResourceClass;

public class ContainerJPanel extends JPanel {

	public ContainerJPanel(){
		setOpaque(true);
		setBounds(0, GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(650));
		setLayout(null);
		setBackground(Color.white);
		add(new AnnouncementPanel());
		add(new DoneeInfoJpanel());
		add(new DonationJpanel());
	}
}
