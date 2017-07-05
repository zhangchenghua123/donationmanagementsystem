package sys.view;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import sys.model.AnnValues;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.AnnounceItem;

public class AnnouncementPanel extends ImagePanel {

	private JLabel refeshLabel;//刷新按钮
	private JLabel lastPageJLabel;//上一页
	private JLabel nextPageJLabel;//下一页
	private ArrayList<AnnounceItem> items;
	private JPanel annspJPanel;
	public AnnouncementPanel(){
		super(GetResourceClass.class.getResource("image/announcement_background.png"));
		System.out.println("gouzaokaishi");
		setBounds(0, GetResourceClass.getRealSize(400), GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(400));
		setLayout(null);
		
		refeshLabel=new JLabel();
		ImageIcon icon=new ImageIcon(GetResourceClass.class.getResource("image/refresh.png"));
		icon.setImage(icon.getImage().getScaledInstance(GetResourceClass.getRealSize(30),GetResourceClass.getRealSize(30),Image.SCALE_DEFAULT));
		refeshLabel.setIcon(icon);
		refeshLabel.setBounds(GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(10), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30));
		refeshLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		annspJPanel=new JPanel();
		annspJPanel.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(300));
		annspJPanel.setOpaque(false);
		annspJPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,GetResourceClass.getRealSize(5)));
		
		achieveData();
		
		add(refeshLabel);
		add(annspJPanel);
		System.out.println("构造完");
	}
	public void achieveData(){
		annspJPanel.removeAll();
		items=new ArrayList<AnnounceItem>();
		for(int i=0;i<AnnValues.getRowCountOfCurrentPage();i++){
			AnnounceItem announceItem=new AnnounceItem(AnnValues.getValueAt(i));
			annspJPanel.add(announceItem);
			System.out.println(AnnValues.getValueAt(i));
		}
		System.out.println("下一页");
		AnnValues.nextPage();
		for(int i=0;i<AnnValues.getRowCountOfCurrentPage();i++){
			AnnounceItem announceItem=new AnnounceItem(AnnValues.getValueAt(i));
			System.out.println(AnnValues.getValueAt(i));
		}
	}
	
}
