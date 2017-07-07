package sys.view.customView;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sys.view.GetResourceClass;
import sys.view.ModuleJPanel;


/**
 * 图标类的按钮
 * 
 * 鼠标指向时，显示img_active_url路径下的图片，否则显示img_unactive_url下的图片
 * 点击时，根据设置的固有ID，在ChangeIconBGlistener的点击监听器中根据ID执行任务
 */
public class ImagePanel extends ModuleJPanel {
	

	private URL imageUrl;
	public ImagePanel(URL imageUrl) {
		this.imageUrl=imageUrl;
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0, y = 0;
		ImageIcon icon;
		icon=new ImageIcon(imageUrl);
		System.out.println(GetResourceClass.getRealSize(getSize().width));
		((Graphics2D)g).drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);// 图片会自动缩�?
	}

}
