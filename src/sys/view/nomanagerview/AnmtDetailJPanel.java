package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import sun.security.jca.GetInstance;
import sys.GlobalVariables;
import sys.model.objects.Announcement;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;

public class AnmtDetailJPanel extends JPanel {

	//单例
	private static AnmtDetailJPanel anmtDetailJPanel;
	
	private JLabel titleLabel;
	private JLabel timeLabel;
	private JTextArea contentArea;
	private JLabel quitLabel;
	//隐藏构造函数
	private AnmtDetailJPanel(){
		setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(895),
				GetResourceClass.getRealSize(640));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(160,160,160)));
		setBackground(Color.white);
		
		titleLabel=new JLabel("",JLabel.CENTER);
		titleLabel.setBounds(0, GetResourceClass.getRealSize(40), GetResourceClass.getRealSize(895),
				GetResourceClass.getRealSize(30));
		titleLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(25)));
		add(titleLabel);
		
		timeLabel=new JLabel("");
		timeLabel.setBounds(GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(80), 
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		timeLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(timeLabel);
		
		contentArea=new JTextArea();
		contentArea.setBounds(GetResourceClass.getRealSize(100), GetResourceClass.getRealSize(140), 
				GetResourceClass.getRealSize(700), GetResourceClass.getRealSize(500));
		contentArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		contentArea.setEditable(false);
		contentArea.setOpaque(false);
		contentArea.setLineWrap(true);
		add(contentArea);
		
		quitLabel=new JLabel("关闭",JLabel.CENTER);
		quitLabel.setBounds(GetResourceClass.getRealSize(10),GetResourceClass.getRealSize(10) ,
				GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(30));
		quitLabel.setOpaque(false);
		quitLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		quitLabel.setForeground(Color.blue);
		quitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		quitLabel.addMouseListener(new MouseListener() {
			
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
				Container container=(Container)GlobalVariables.frame.getContentPane().getComponent(1);
				container.remove(2);
				container.getComponent(1).setVisible(true);
				
				((Container)GlobalVariables.frame.getContentPane()).repaint();
			}
		});
		add(quitLabel);
		
	}
	public static AnmtDetailJPanel getInstance(){
		if(anmtDetailJPanel!=null)
			return anmtDetailJPanel;
		else {
			anmtDetailJPanel=new AnmtDetailJPanel();
			return anmtDetailJPanel;
		}
			 
	}
	public void setData(Announcement announcement){
		
		titleLabel.setText(announcement.getTitle());
		timeLabel.setText(announcement.getTime().toString());
		contentArea.setText(announcement.getContent());
	}
}
