package sys.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Label;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.view.customView.ImagePanel;

public class HeadPanel extends ImagePanel{

	public HeadPanel(URL imageUrl) {
		
		super(new ImageIcon(imageUrl));
		setBounds(0,0, GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(80));
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(1200), GetResourceClass.getRealSize(80)));
		setLayout(null);
		
		
		JLabel label=new JLabel("疑难解答");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBounds( GetResourceClass.getRealSize(840), 0,  GetResourceClass.getRealSize(60),  GetResourceClass.getRealSize(30));
		add(label);
		
		JLabel label1=new JLabel("留言");
		label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label1.setBounds( GetResourceClass.getRealSize(900),0, GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(30));
		add(label1);
		
		
		JLabel label2=new JLabel("登录");
		label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label2.setBounds( GetResourceClass.getRealSize(940),0,  GetResourceClass.getRealSize(40),  GetResourceClass.getRealSize(30));
		add(label2);

		
	}

}
