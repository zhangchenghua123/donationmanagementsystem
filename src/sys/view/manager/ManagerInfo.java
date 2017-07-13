package sys.view.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sys.GlobalVariables;
import sys.model.objects.AffairManager;
import sys.model.objects.SystemManager;
import sys.view.GetResourceClass;
import sys.view.UpdatePasswordDialog;
import sys.view.customView.ImagePanel;
/**
 * 管理人员登陆后主页上的个人信息板块
 * @author Berry
 *
 */
public class ManagerInfo extends ImagePanel {

	private JLabel accountLabel;
	private JLabel nameLabel;
	private JLabel positionLabel;
	private JLabel taskLabel;
	private JLabel updatePasswordLabel;
	public ManagerInfo() {
		super(new ImageIcon(GetResourceClass.class.getResource("image/personinfo.png")));
		setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(20), 
				GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(200));
		setOpaque(false);
		setLayout(null);
		
		accountLabel=new JLabel();
		accountLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(180), GetResourceClass.getRealSize(30));
		accountLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(accountLabel);
		
		nameLabel=new JLabel();
		nameLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(180), GetResourceClass.getRealSize(30));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(nameLabel);
		
		positionLabel=new JLabel();
		positionLabel.setBounds(GetResourceClass.getRealSize(20), GetResourceClass.getRealSize(110), 
				GetResourceClass.getRealSize(180), GetResourceClass.getRealSize(30));
		positionLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(positionLabel);
		
		updatePasswordLabel=new JLabel("修改密码");
		updatePasswordLabel.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(150), 
				GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(20));
		updatePasswordLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(14)));
		updatePasswordLabel.setForeground(Color.green);
		updatePasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updatePasswordLabel.addMouseListener(new MouseListener() {
			
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
				updatePasswordLabel.setForeground(Color.green);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				updatePasswordLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				new UpdatePasswordDialog().setVisible(true);					
			}
		});
		add(updatePasswordLabel);
		
		if(GlobalVariables.userInfo.get("type").equals("系统管理员")){
			
			accountLabel.setText("账  号: "+((SystemManager)GlobalVariables.userInfo.get("user")).getAccount());
			nameLabel.setText("姓  名: "+((SystemManager)GlobalVariables.userInfo.get("user")).getName());
			positionLabel.setText("管理员: 系统管理员");
		}
		else if(GlobalVariables.userInfo.get("type").equals("事例管理员")){
			
			accountLabel.setText("账  号: "+((AffairManager)GlobalVariables.userInfo.get("user")).getAccount());
			nameLabel.setText("姓  名: "+((AffairManager)GlobalVariables.userInfo.get("user")).getName());
			positionLabel.setText("管理员/任务: 事例管理员/"+((AffairManager)GlobalVariables.userInfo.get("user")).getTask());
		}
	}

}
