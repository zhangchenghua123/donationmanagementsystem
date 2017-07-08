package sys.presenter;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sys.GlobalVariables;
import sys.view.MainFrame;

public class Main {

	public static Font font;

	public static void main(String[] args) {

		// 单元测试
		System.out.println("单元测试开始");
		UnitTest.test();

		// 显示主界面
		Map map = new HashMap<>();
		map.put(TextAttribute.SIZE, 20);
		font = new Font(map);
		GlobalVariables.frame = new MainFrame();
		GlobalVariables.frame.setVisible(true);

		// 显示当前时间
		Date date = new Date(new java.util.Date().getTime());
		DateFormat df2 = DateFormat.getDateTimeInstance();// 可以精确到时分秒
		System.out.println(df2.format(date));
		System.out.println();

	}
}
