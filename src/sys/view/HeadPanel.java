package sys.view;

import java.awt.Cursor;
import java.awt.Label;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.GetResourceClass;
import sys.view.customView.ImagePanel;

public class HeadPanel extends ImagePanel{

	public HeadPanel(URL imageUrl) {
		
		super(imageUrl);
		setBounds(0,0,1200,80);
		setLayout(null);
		
		
		JLabel label=new JLabel("疑难解答");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBounds(840, 0, 60, 30);
		add(label);
		
		JLabel label1=new JLabel("留言");
		label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label1.setBounds(900,0,40, 30);
		add(label1);
		
		
		JLabel label2=new JLabel("登录");
		label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label2.setBounds(940,0, 40, 30);
		add(label2);

		
	}

}
