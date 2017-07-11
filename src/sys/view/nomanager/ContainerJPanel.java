package sys.view.nomanager;

import javax.swing.JPanel;

public class ContainerJPanel extends JPanel {

	public ContainerJPanel(){
		setOpaque(false);
		setBounds(0, 100, 1200, 650);
		setLayout(null);
		add(new AnnouncementPanel());
		add(new DoneeInfoJpanel());
		add(new DonationJpanel());
	}
}
