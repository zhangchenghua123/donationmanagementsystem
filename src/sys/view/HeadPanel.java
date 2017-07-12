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

import sys.GlobalVariables;
import sys.model.objects.Donor;
import sys.view.customView.ImagePanel;
import sys.view.manager.ContainerJPanel;
import sys.view.nomanager.DonorRegisterDialog;

public class HeadPanel extends ImagePanel{

	private JLabel loginLabel;
	private JLabel registerLabel;
	private JLabel usernameLabel;
	private JLabel logoffLabel;
	
	public HeadPanel(URL imageUrl) {
		
		super(new ImageIcon(imageUrl));
		setBounds(0,0, GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(100));
		setLayout(null);
		
		
		loginLabel=new JLabel("登录");
		loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		loginLabel.setBounds( GetResourceClass.getRealSize(1000), GetResourceClass.getRealSize(70), 
				GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(20));
		add(loginLabel);
		
		registerLabel=new JLabel("注册");
		registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		registerLabel.setBounds( GetResourceClass.getRealSize(1060),GetResourceClass.getRealSize(70),
				GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(20));
		add(registerLabel);
		
		usernameLabel=new JLabel("");
		usernameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		usernameLabel.setBounds( GetResourceClass.getRealSize(1000), GetResourceClass.getRealSize(70),  
				GetResourceClass.getRealSize(60),  GetResourceClass.getRealSize(20));
		add(usernameLabel);
		usernameLabel.setVisible(false);
		
		logoffLabel=new JLabel("注销");
		logoffLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		logoffLabel.setBounds( GetResourceClass.getRealSize(1080), GetResourceClass.getRealSize(70), 
				GetResourceClass.getRealSize(60),  GetResourceClass.getRealSize(20));
		logoffLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoffLabel.addMouseListener(new MouseListener() {
			
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
				logoffLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				logoffLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				GlobalVariables.userInfo=null;
				loginLabel.setVisible(true);
				registerLabel.setVisible(true);
				logoffLabel.setVisible(false);
				usernameLabel.setVisible(false);
				GlobalVariables.frame.getContentPane().remove(1);
				GlobalVariables.frame.getContentPane().add(new sys.view.nomanager.ContainerJPanel());
				GlobalVariables.frame.getContentPane().repaint();
				GlobalVariables.frame.repaint();
				
			}
		});
		
		add(logoffLabel);
		logoffLabel.setVisible(false);
		
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
				if(LoginDialog.loginState){
					if(LoginDialog.WHO==LoginDialog.MANAGER_LOGIN){
						//系统人员登录
						loginLabel.setVisible(false);
						registerLabel.setVisible(false);
						logoffLabel.setVisible(true);
						GlobalVariables.frame.getContentPane().remove(1);
						GlobalVariables.frame.getContentPane().add(new sys.view.manager.ContainerJPanel());
						GlobalVariables.frame.getContentPane().repaint();
						GlobalVariables.frame.repaint();
					}
					else{
						//捐助者登录
						Donor donor=(Donor) GlobalVariables.userInfo.get("user");
						loginLabel.setVisible(false);
						registerLabel.setVisible(false);
						usernameLabel.setText(donor.getName());
						usernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						usernameLabel.addMouseListener(new MouseListener() {
							
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
								usernameLabel.setForeground(Color.black);
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								usernameLabel.setForeground(Color.blue);
							}
							
							
							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
						
						usernameLabel.setVisible(true);
						logoffLabel.setVisible(true);
;					}
					
				}
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
				new DonorRegisterDialog(GlobalVariables.frame).setVisible(true);
				if(DonorRegisterDialog.state==DonorRegisterDialog.LOGIN){
					//捐助者登录
					Donor donor=(Donor) GlobalVariables.userInfo.get("user");
					loginLabel.setVisible(false);
					registerLabel.setVisible(false);
					usernameLabel.setText(donor.getName());
					usernameLabel.setVisible(true);
					logoffLabel.setVisible(true);
					
				}
			}
		});
	}

}
