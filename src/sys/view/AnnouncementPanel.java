package sys.view;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import sys.GetResourceClass;
import sys.action.listener.AnnTableListener;
import sys.action.listener.AnnTableListener.RoutineColor;
import sys.model.AnnValues;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.AnnounceItem;

public class AnnouncementPanel extends ImagePanel {

	private AnnValues annValues;//表格的数据适配器
	private JLabel refeshLabel;//刷新按钮
	private JLabel lastPageJLabel;//上一页
	private JLabel nextPageJLabel;//下一页
	private ArrayList<AnnounceItem> items;
	private JPanel annspJPanel;
	public AnnouncementPanel(){
		super(GetResourceClass.class.getResource("image/announcement_background.png"));
		setBounds(0, 400, 300, 400);
		setLayout(null);
		
		refeshLabel=new JLabel();
		ImageIcon icon=new ImageIcon(GetResourceClass.class.getResource("image/refresh.png"));
		icon.setImage(icon.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
		refeshLabel.setIcon(icon);
		refeshLabel.setBounds(250, 10, 30, 30);
		refeshLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		annspJPanel=new JPanel();
		annspJPanel.setBounds(5, 50, 290, 300);
		annspJPanel.setOpaque(false);
		annspJPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));
		
		annValues=new AnnValues();
		
		items=new ArrayList<AnnounceItem>();
		for(int i=0;i<annValues.getRowCountOfCurrentPage();i++){
			AnnounceItem announceItem=new AnnounceItem(annValues.getValueAt(i));
			annspJPanel.add(announceItem);
			System.out.println(annValues.getValueAt(i));
		}
		System.out.println("下一页");
		annValues.nextPage();
		for(int i=0;i<annValues.getRowCountOfCurrentPage();i++){
			AnnounceItem announceItem=new AnnounceItem(annValues.getValueAt(i));
			System.out.println(annValues.getValueAt(i));
		}
		add(refeshLabel);
		add(annspJPanel);
	}
}
