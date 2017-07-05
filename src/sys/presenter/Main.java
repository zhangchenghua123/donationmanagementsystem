package sys.presenter;


import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import sys.GlobalVariables;
import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.daoimpl.DonationDaoImpl;
import sys.model.clouddatabase.daoimpl.Test;
import sys.view.AnnouncementPanel;
import sys.view.DonationJpanel;
import sys.view.DoneeInfoJpanel;
import sys.view.EntranceJpanel;
import sys.view.GetResourceClass;
import sys.view.HeadPanel;
import sys.view.LogoJpanel;
import sys.view.MainFrame;


public class Main {

	public static Font font;
	
	public static void main(String[] args){
		Map map=new HashMap<>();
		map.put(TextAttribute.SIZE, 20);
		font=new Font(map);
		GlobalVariables.frame=new MainFrame();
		//测试数据库
		System.out.println(Toolkit.getDefaultToolkit().getScreenResolution());
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		new Test().test();
		GlobalVariables.frame.setVisible(true);
		System.out.println("用户区宽："+GlobalVariables.frame.getContentPane().getWidth()+",高："+GlobalVariables.frame.getContentPane().getHeight());
		
		
	}
}
