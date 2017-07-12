package sys.view.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import sys.presenter.AnmtPresenter;
import sys.view.GetResourceClass;
import sys.view.customView.TextInput;
/**
 * 公告发布界面
 * @author Berry
 *
 */
public class AnmtPublishJPanel extends JPanel {

	private JLabel titleLabel;
	private JTextField titleInput;//标题
	private JLabel contentLabel;
	private JTextArea contentArea;//内容
	private JLabel submitLabel; //发布按钮
	private JLabel infoLabel;  //提示信息
	public AnmtPublishJPanel(){
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
//		setForeground(Color.white);
		
		titleLabel=new JLabel("公告标题:");
		titleLabel.setBounds(GetResourceClass.getRealSize(60),GetResourceClass.getRealSize(60) ,
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
		titleLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(titleLabel);
		
		titleInput=new JTextField();
		titleInput.setBounds(GetResourceClass.getRealSize(180),GetResourceClass.getRealSize( 60),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(25));
		titleInput.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(titleInput);
		
		contentLabel=new JLabel("公告正文:");
		contentLabel.setBounds(GetResourceClass.getRealSize(60),GetResourceClass.getRealSize(100) ,
				GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(20));
		contentLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(contentLabel);
		
		contentArea=new JTextArea();
		contentArea.setBounds(GetResourceClass.getRealSize(180),GetResourceClass.getRealSize( 100),
				GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(400));
		contentArea.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
		contentArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(contentArea);
		
		infoLabel=new JLabel("");
		infoLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(infoLabel);
		
		submitLabel=new JLabel("发布该公告",JLabel.CENTER);
		submitLabel.setBounds(GetResourceClass.getRealSize(620),GetResourceClass.getRealSize(510) ,
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
		submitLabel.setOpaque(true);
		submitLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		submitLabel.setBackground(new Color(102,205,0));
		submitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitLabel.addMouseListener(new MouseListener() {
			
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
				submitLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				submitLabel.setForeground(Color.yellow);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(titleInput.getText().equals("")){
					infoLabel.setText("标题不能为空");
					infoLabel.setBounds(GetResourceClass.getRealSize(785), GetResourceClass.getRealSize(60),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.setForeground(Color.red);
					infoLabel.repaint();
				}
				else if(contentArea.getText().equals("")){
					infoLabel.setText("内容不能为空");
					infoLabel.setBounds(GetResourceClass.getRealSize(785),GetResourceClass.getRealSize( 100), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.setForeground(Color.red);
					infoLabel.repaint();
				}
				else if(AnmtPresenter.insert(new Date(new java.util.Date().getTime()), titleInput.getText(), contentArea.getText())){
					infoLabel.setText("发布公告成功");
					infoLabel.setBounds(GetResourceClass.getRealSize(640), GetResourceClass.getRealSize(560),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.setForeground(Color.green);
					infoLabel.repaint();
				}
				else {
					infoLabel.setText("发布公告失败");
					infoLabel.setBounds(GetResourceClass.getRealSize(640), GetResourceClass.getRealSize(560),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.setForeground(Color.red);
					infoLabel.repaint();
				}
			}
		});
		add(submitLabel);
	}
}
