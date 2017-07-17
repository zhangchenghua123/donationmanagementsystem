package sys.view.managerview.affair;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sys.GlobalVariables;
import sys.model.objects.AffairManager;
import sys.model.objects.Donee;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;

/**
 * 卡片二
 * @author Berry
 *
 */
public class StopInstancePanel extends JPanel {

	private ArrayList<Donee> doneesList;
	private JScrollPane scrollPane;
	private JPanel doneesPanel;
	private JLabel info;
	
	public StopInstancePanel(){
		
		setBounds(0,GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(930), GetResourceClass.getRealSize(600));
		setLayout(null);
		setOpaque(false);
		
		AffairManager affairManager=(AffairManager) GlobalVariables.userInfo.get("user");
		doneesList=DoneePresenter.getDoneeByCondition(affairManager.getTaskId(), "stop");
		if(doneesList==null||doneesList!=null&&doneesList.size()==0){
			info=new JLabel("暂无记录",JLabel.CENTER);
			info.setBounds(GetResourceClass.getRealSize(400), GetResourceClass.getRealSize(50), 
					GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
			info.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
			add(info);
		} else {
			doneesPanel = new JPanel();
			doneesPanel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(20), 
					GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(600));
			doneesPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(600)));
			doneesPanel.setOpaque(false);
			doneesPanel.setLayout(new FlowLayout(1, 0, 0));
			add(doneesPanel);
			validate();
			for (int i = 0; i < doneesList.size(); i++) {
				StopInstenceItemPanel itemPanel = new StopInstenceItemPanel(
						doneesList.get(i));
				doneesPanel.add(itemPanel);
			}
		}
	}
}

