package sys.view.managerview.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sys.GlobalVariables;
import sys.model.objects.AffairManager;
import sys.presenter.AffairManagerPresenter;
import sys.presenter.TaskPresenter;
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
	
	ArrayList<AffairManager> list;
	
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
		
		confirmLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(taskField.getText().equals("")){
					infoJLabel.setText("请输入任务名");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(160), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return;
				}
				else if(affNameField.getText().equals("")){
					infoJLabel.setText("请输入姓名");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(240), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return;
				}
				else if(affAccountField.getText().equals("")){
					infoJLabel.setText("请输入账号");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(200), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return ;
				}
				else if(affPasswordField.getText().equals("")){
					infoJLabel.setText("请输入密码");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(280), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return;
				}
				else if(TaskPresenter.taskExisted(taskField.getText())){
								infoJLabel.setText("任务已存在");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(160), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return;
				}
				else if(AffairManagerPresenter.accountAlreadyExisted(affAccountField.getText())){
					infoJLabel.setText("账号已存在");
					infoJLabel.setBounds(GetResourceClass.getRealSize(605), GetResourceClass.getRealSize(200), 
							GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
					infoJLabel.setForeground(Color.red);
					infoJLabel.repaint();
					return;
				}
				else {
					TaskPresenter.insertNewTask(taskField.getText());//在task表中插入任务
					int taskid=TaskPresenter.getTaskIdByName(taskField.getText());//获取任务ID
					AffairManager affairManager=new AffairManager();//新建一个事例管理员
					affairManager.setAccount(affAccountField.getText());
					affairManager.setName(affNameField.getText());
					affairManager.setTaskId(taskid);
					affairManager.setPassword(affPasswordField.getText());
					if(AffairManagerPresenter.register(affairManager)){//在事例管理员表中插入数据
						
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new TaskDelegateJPanel(),1);
						((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).validate();
					}
					else{
						infoJLabel.setText("委派失败");
						infoJLabel.setBounds(GetResourceClass.getRealSize(520), GetResourceClass.getRealSize(320), 
								GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(25));
						infoJLabel.setForeground(Color.green);
						infoJLabel.repaint();
					}
				}
			}
		
			
		});
		
		list=AffairManagerPresenter.getAllAffManagers();
		table=new JTable();
		table.setOpaque(false);
		table.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(30+40*list.size()));
		table.setRowHeight(GetResourceClass.getRealSize(40));
		table.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		table.setEnabled(false);
		table.getTableHeader().setPreferredSize(new Dimension(GetResourceClass.getRealSize(100), 
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
		scrollPane.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(400),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(200));
//		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.setBackground(Color.white);
		add(scrollPane);
	}
}
