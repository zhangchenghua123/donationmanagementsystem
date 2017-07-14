package sys.view.nomanagerview;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sys.model.objects.Announcement;
import sys.presenter.AnmtPresenter;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
import sys.view.tableitem.AnnounceItemLabel;

/**
 * 主页公告面板
 * 
 * @author Berry
 * 
 */
public class AnnouncementPanel extends ImagePanel {

	private ArrayList<Announcement> anmtList;
	private JPanel annspJPanel;
	private JScrollPane scrollPane;
	public AnnouncementPanel(){
		super(new ImageIcon(GetResourceClass.class.getResource("image/announcement_background.png")));
		setBounds(0, GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(645));
		setLayout(null);
		setOpaque(false);
		
		
		annspJPanel=new JPanel();
		annspJPanel.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(280), GetResourceClass.getRealSize(540));
		annspJPanel.setOpaque(false);
		annspJPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,GetResourceClass.getRealSize(5)));
		annspJPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(580)));
		anmtList=AnmtPresenter.getAll();
		for(int i=0;i<anmtList.size();i++){
			AnnounceItemLabel announceItemLabel=new AnnounceItemLabel(anmtList.get(i));
			annspJPanel.add(announceItemLabel);
		}
		
		scrollPane=new JScrollPane(annspJPanel);
		scrollPane.setBounds(GetResourceClass.getRealSize(5), GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(290), GetResourceClass.getRealSize(540));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
	}
}
