package sys.action;

import java.awt.Container;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import sys.GetResourceClass;
import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.daoimpl.DonationDaoImpl;
import sys.model.clouddatabase.daoimpl.Test;
import sys.view.AnnouncementPanel;
import sys.view.EntranceJpanel;
import sys.view.HeadPanel;
import sys.view.MainFrame;


public class Main {

	public static Font font;
	public static void main(String[] args){
		Map map=new HashMap<>();
		map.put(TextAttribute.SIZE, 20);
		font=new Font(map);
		JFrame frame=new MainFrame();
		HeadPanel headPanel=new HeadPanel(GetResourceClass.class.getResource("image/head_bg.png"));
		frame.getContentPane().add(headPanel);
		frame.getContentPane().add(new EntranceJpanel());
		frame.getContentPane().add(new AnnouncementPanel());
		//测试数据库
				new Test().test();
		frame.setVisible(true);
		System.out.println("用户区宽："+frame.getContentPane().getWidth()+",高："+frame.getContentPane().getHeight());
		
		
	}
}
