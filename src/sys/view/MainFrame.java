package sys.view;

import java.awt.Shape;

import javax.swing.JFrame;

import sys.action.listener.FrameListener;

public class MainFrame extends JFrame{

	public MainFrame() {
		setTitle("欢迎使用慈善捐助管理系统");
		setSize(1218,847);
		setLayout(null);
		addWindowListener(new FrameListener());
	}
}
