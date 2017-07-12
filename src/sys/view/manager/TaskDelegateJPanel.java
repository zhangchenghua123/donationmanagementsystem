package sys.view.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sys.model.objects.AffairManager;
import sys.presenter.AffairManagerPresenter;
import sys.view.GetResourceClass;
/**
 * 任务委派页
 * @author Berry
 *
 */
public class TaskDelegateJPanel extends JLabel {

	private JLabel taskLabel;
	private JTextField taskField;
	private JLabel affAccountLabel;
	private JTextField affAccountField;
	private JLabel affNameLabel;
	private JTextField affNameField;
	private JLabel affPasswordLabel;
	private JTextField affPasswordField;
	private JLabel infoJLabel;
	private JLabel confirmLabel;
	
	private JLabel yiyouLabel;
	private JTable table;
	
	public TaskDelegateJPanel(){
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
//		setForeground(Color.white);
		
		
		
		taskLabel=new JLabel("新建任务名称：");
		taskLabel.setBounds(GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(160),
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		taskLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(taskLabel);
		
		taskField=new JTextField();
		taskField.setBounds(GetResourceClass.getRealSize(350), GetResourceClass.getRealSize(160), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		taskField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(taskField);
		
		affAccountLabel=new JLabel("事例管理员账号：");
		affAccountLabel.setBounds(GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(200), 
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		affAccountLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(affAccountLabel);
		
		affAccountField=new JTextField();
		affAccountField.setBounds(GetResourceClass.getRealSize(350), GetResourceClass.getRealSize(200), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		affAccountField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(affAccountField);
		
		affNameLabel=new JLabel("事例管理员姓名：");
		affNameLabel.setBounds(GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(240), 
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		affNameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(affNameLabel);
		
		affNameField=new JTextField();
		affNameField.setBounds(GetResourceClass.getRealSize(350), GetResourceClass.getRealSize(240), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		affNameField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(affNameField);
		
		affPasswordLabel=new JLabel("事例管理员密码：");
		affPasswordLabel.setBounds(GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(280), 
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		affPasswordLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(affPasswordLabel);
		
		affPasswordField=new JTextField();
		affPasswordField.setBounds(GetResourceClass.getRealSize(350), GetResourceClass.getRealSize(280), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		affPasswordField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(affPasswordField);
		
		confirmLabel=new JLabel("确认委派",JLabel.CENTER);
		confirmLabel.setBounds(GetResourceClass.getRealSize(350),GetResourceClass.getRealSize(320) ,
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
		confirmLabel.setOpaque(true);
		confirmLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		confirmLabel.setBackground(new Color(102,205,0));
		confirmLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(confirmLabel);
		
		infoJLabel=new JLabel("");
		infoJLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(infoJLabel);
		
		yiyouLabel=new JLabel("已委派任务:");
		yiyouLabel.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(370), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		yiyouLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		add(yiyouLabel);
		
		table=new JTable();
		table.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(200));
		table.setRowHeight(GetResourceClass.getRealSize(40));
		table.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		table.setEnabled(false);
		table.getTableHeader().setPreferredSize(new Dimension(GetResourceClass.getRealSize(100), 
				GetResourceClass.getRealSize(30)));
		String[] tableHeads=new String[]{"任务","事例管理员账号","事例管理员姓名"};
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		ArrayList<AffairManager> list=AffairManagerPresenter.getAllAffManagers();
		for(int i=0;i<list.size();i++){
			Vector<String> vector=new Vector<>();
			vector.add(list.get(i).getTask());
			vector.add(list.get(i).getAccount());
			vector.add(list.get(i).getName());
			dtm.addRow(vector);
		}
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(200));
		add(scrollPane);
	}
}
