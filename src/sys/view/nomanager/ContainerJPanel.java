package sys.view.nomanager;

import java.awt.Color;

import javax.swing.JPanel;

public class ContainerJPanel extends JPanel {

	public ContainerJPanel(){
		setOpaque(true);
		setBounds(0, 100, 1200, 650);
		setLayout(null);
		setBackground(Color.white);
		add(new AnnouncementPanel());
		add(new DoneeInfoJpanel());
		add(new DonationJpanel());
	}
}
