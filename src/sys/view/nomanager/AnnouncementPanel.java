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

import sys.model.objects.Announcement;
import sys.presenter.AnmtPresenter;
import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.AnnounceItemLabel;

/**
 * 主页公告面板
 * 
 * @author Berry
 * 
 */
public class AnnouncementPanel extends ImagePanel {

	private JLabel lastPageJLabel;// 上一页
	private JLabel nextPageJLabel;// 下一页
	private ArrayList<AnnounceItemLabel> labelList;
	private ArrayList<Announcement> anmtList;
	private JPanel annspJPanel;

	public static int currentPage = 0;// 当前的页码
	public static int maxPage;// 最大页数,从0开始

	public AnnouncementPanel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/announcement_background.png")));
		setBounds(0, GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(645));
		setLayout(null);
		setOpaque(false);
		
		
		annspJPanel=new JPanel();
		annspJPanel.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(540));
		annspJPanel.setOpaque(false);
		annspJPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,GetResourceClass.getRealSize(5)));
		
		anmtList=AnmtPresenter.getAll();
		labelList=new ArrayList<AnnounceItemLabel>();
		maxPage=anmtList.size()/18;
		for(int i=0;i<getRowCountOfCurrentPage();i++){
			AnnounceItemLabel announceItemLabel=new AnnounceItemLabel(getValueAt(i));
			annspJPanel.add(announceItemLabel);
		}
		add(annspJPanel);
		System.out.println("构造完");
	}

	public int getRowCountOfCurrentPage() {
		return (anmtList.size() - currentPage * 18) >= 18 ? 18
				: (anmtList.size() - currentPage * 18);
	}

	public Announcement getValueAt(int rowIndex) {

		return anmtList.get(currentPage * 18 + rowIndex);

	}

}
