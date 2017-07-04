package sys.view;

import javax.swing.JPanel;

import sys.GetResourceClass;
import sys.view.customView.ImagePanel;

public class AnnouncementPanel extends ImagePanel {

	public AnnouncementPanel(){
		super(GetResourceClass.class.getResource("image/announcement_background.png"));
		setBounds(0, 400, 300, 400);
	}
}
