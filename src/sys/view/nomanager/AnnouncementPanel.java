package sys.view.nomanager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;


import sys.model.AnnValues;
import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.AnnounceItemLabel;
/**
 * 主页公告面板
 * @author Berry
 *
 */
public class AnnouncementPanel extends ImagePanel {

	private JLabel lastPageJLabel;//上一页
	private JLabel nextPageJLabel;//下一页
	private ArrayList<AnnounceItemLabel> items;
	private JPanel annspJPanel;
	public AnnouncementPanel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/announcement_background.png")));
		setName("AnnouncementPanel");
		setBounds(0, GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(645));
		setLayout(null);
		setOpaque(false);
		System.out.println("gouzaokaishi");
		
		ImageIcon icon=new ImageIcon(GetResourceClass.class.getResource("image/refresh.png"));
		icon.setImage(icon.getImage().getScaledInstance(GetResourceClass.getRealSize(30),GetResourceClass.getRealSize(30),Image.SCALE_DEFAULT));
		
		annspJPanel=new JPanel();
		annspJPanel.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(300));
		annspJPanel.setOpaque(false);
		annspJPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,GetResourceClass.getRealSize(5)));
		
		achieveData();
		
		
		add(annspJPanel);
		System.out.println("构造完");
	}
	public void achieveData(){
		annspJPanel.removeAll();
		items=new ArrayList<AnnounceItemLabel>();
		for(int i=0;i<AnnValues.getRowCountOfCurrentPage();i++){
			AnnounceItemLabel announceItemLabel=new AnnounceItemLabel(AnnValues.getValueAt(i));
			annspJPanel.add(announceItemLabel);
			System.out.println(AnnValues.getValueAt(i));
		}
		System.out.println("下一页");
		AnnValues.nextPage();
		for(int i=0;i<AnnValues.getRowCountOfCurrentPage();i++){
			AnnounceItemLabel announceItemLabel=new AnnounceItemLabel(AnnValues.getValueAt(i));
			System.out.println(AnnValues.getValueAt(i));
		}
	}
	
}
