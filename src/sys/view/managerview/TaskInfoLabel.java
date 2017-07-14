package sys.view.managerview;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
/**
 * 系统管理员主页上的任务委托情况
 * @author Berry
 *
 */
public class TaskInfoLabel extends ImagePanel {

	public TaskInfoLabel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/taskinfo.png")));
		setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(260), 
				GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(300));
		setOpaque(false);
	}
}
