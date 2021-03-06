package sys.view;

import java.awt.Color;
import java.awt.Shape;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import sys.view.nomanagerview.ContainerJPanel;


public class MainFrame extends JFrame{

	public MainFrame() {
		setTitle("欢迎使用慈善捐助管理系统");
		setSize( GetResourceClass.getRealSize(1218), GetResourceClass.getRealSize(797));
		setLayout(null);
		getContentPane().setBackground(Color.white);
		getContentPane().setForeground(Color.white);
		HeadPanel headPanel=new HeadPanel(GetResourceClass.class.getResource("image/head_bg.png"));
		getContentPane().add(headPanel);
		getContentPane().add(new ContainerJPanel());
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//做关闭前工作
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
