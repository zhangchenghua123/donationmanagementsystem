package sys.view.manager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;
/**
 * 系统管理员主页上的任务委托情况
 * @author Berry
 *
 */
public class TaskInfoLabel extends ImagePanel {

	public TaskInfoLabel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/taskinfo.png")));
		setBounds(20, 260, 800, 300);
		setOpaque(false);
	}
}
