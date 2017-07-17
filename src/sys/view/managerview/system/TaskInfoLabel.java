package sys.view.managerview.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sys.model.objects.AffairManager;
import sys.presenter.AffairManagerPresenter;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
/**
 * 系统管理员主页上的任务委托情况
 * @author Berry
 *
 */
public class TaskInfoLabel extends ImagePanel {

	private JTable table;
	
	public TaskInfoLabel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/taskinfo.png")));
		setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(260), 
				GetResourceClass.getRealSize(800), GetResourceClass.getRealSize(300));
		setOpaque(false);
		setLayout(null);
		
		ArrayList<AffairManager> list=AffairManagerPresenter.getAllAffManagers();
		table=new JTable();
		table.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(790), GetResourceClass.getRealSize(30+40*list.size()));
		table.setRowHeight(GetResourceClass.getRealSize(40));
		table.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		table.setEnabled(false);
		table.setFillsViewportHeight(false);
		table.setOpaque(true);
		table.setBackground(Color.white);
		table.getTableHeader().setPreferredSize(new Dimension(GetResourceClass.getRealSize(790), 
				GetResourceClass.getRealSize(30)));
		String[] tableHeads=new String[]{"任务","事例管理员账号","事例管理员姓名"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		for(int i=0;i<list.size();i++){
			Vector<String> vector=new Vector<>();
			vector.add(list.get(i).getTask());
			vector.add(list.get(i).getAccount());
			vector.add(list.get(i).getName());
			dtm.addRow(vector);
		}
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setOpaque(true);
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setBackground(Color.white);
		scrollPane.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(790), GetResourceClass.getRealSize(245));
		add(scrollPane);
		
		
	}
}
