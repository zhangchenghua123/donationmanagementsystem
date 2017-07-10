package sys.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.view.customView.ImagePanel;

public class HeadPanel extends ImagePanel{

	private JLabel loginLabel;
	private JLabel registerLabel;
	
	public HeadPanel(URL imageUrl) {
		
		super(new ImageIcon(imageUrl));
		setBounds(0,0, GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(150));
		setLayout(null);
		
		
		loginLabel=new JLabel("登录");
		loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginLabel.setFont(new Font("黑体",Font.PLAIN,16));
		loginLabel.setBounds( GetResourceClass.getRealSize(1000), 120,  GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(20));
		add(loginLabel);
		
		registerLabel=new JLabel("注册");
		registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerLabel.setFont(new Font("黑体",Font.PLAIN,16));
		registerLabel.setBounds( GetResourceClass.getRealSize(1060),120, GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(20));
		add(registerLabel);
		
		loginLabel.addMouseListener(new MouseListener() {
			
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
				loginLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				loginLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new LoginDialog().setVisible(true);
				System.out.println("dddddddddddddddddddddddddddddddddd");
			}
		});
		registerLabel.addMouseListener(new MouseListener() {
			
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
				registerLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				registerLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
