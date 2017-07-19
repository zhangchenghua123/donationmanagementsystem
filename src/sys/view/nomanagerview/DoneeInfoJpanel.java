package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sys.model.clouddatabase.daoimpl.DoneeDaoImpl;
import sys.model.objects.Donee;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;

public class DoneeInfoJpanel extends JPanel {

	private ImagePanel headPanel;
	private JPanel doneesPanel;
	private JLabel nextPageLabel;
	private JLabel lastPageLabel;
	private JLabel currentPageLabel;
	private JLabel tolPageLabel;
	private ArrayList<Donee> list;
	private int tolCount;
	private int currentPage=1;
	private int tolPage;
	public DoneeInfoJpanel(){
		setBounds(GetResourceClass.getRealSize(300),GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(640));//不可修改
		setLayout(null);
		
		headPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/donation_head.png")));
		headPanel.setBounds(GetResourceClass.getRealSize(0),GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(50));
		add(headPanel);
		
		doneesPanel=new JPanel();
		doneesPanel.setBounds(GetResourceClass.getRealSize(0),GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(560));
		doneesPanel.setLayout(new FlowLayout(1,0,1));
		doneesPanel.setOpaque(false);
		add(doneesPanel);
		
		currentPageLabel=new JLabel("当前页数:1",JLabel.CENTER);
		currentPageLabel.setBounds(GetResourceClass.getRealSize(200),GetResourceClass.getRealSize(615) ,
				GetResourceClass.getRealSize(90), GetResourceClass.getRealSize(20));
		currentPageLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(currentPageLabel);
		
		lastPageLabel=new JLabel("上一页",JLabel.CENTER);
		lastPageLabel.setBounds(GetResourceClass.getRealSize(320), GetResourceClass.getRealSize(615), 
				GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(20));
		lastPageLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(lastPageLabel);
		
		nextPageLabel=new JLabel("下一页",JLabel.CENTER);
		nextPageLabel.setBounds(GetResourceClass.getRealSize(380), GetResourceClass.getRealSize(615), 
				GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(20));
		nextPageLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(nextPageLabel);
		
		tolCount=DoneePresenter.getAllCount();
		tolPage=tolCount%4==0?tolCount/4:(tolCount/4+1);
		tolPageLabel=new JLabel("总页数:"+tolPage,JLabel.CENTER);
		tolPageLabel.setBounds(GetResourceClass.getRealSize(440), GetResourceClass.getRealSize(615), 
				GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(20));
		tolPageLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(tolPageLabel);
		
		list=new DoneeDaoImpl().getOnePage(getFirstIndexOfPage(currentPage));
		setOpaque(false);
		for(int i=0;i<list.size();i++){
			DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(i));
			
			doneesPanel.add(doneeItemPanel);
		}
		lastPageLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lastPageLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(currentPage==1)
					return;
				lastPageLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(currentPage==1)
					return;
				currentPage--;
				doneesPanel.removeAll();
				list=new DoneeDaoImpl().getOnePage(getFirstIndexOfPage(currentPage));
				tolCount=DoneePresenter.getAllCount();
				for(int i=0;i<list.size();i++){
					DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(i));
					
					doneesPanel.add(doneeItemPanel);
				}
				currentPageLabel.setText("当前页数:"+currentPage);
				tolPageLabel.setText("总页数:"+(tolCount%4==0?tolCount/4:(tolCount/4+1)));
				doneesPanel.repaint();
				
			}
		});
		nextPageLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				nextPageLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(currentPage==tolPage)
					return;
				nextPageLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(currentPage==tolPage)
					return;
				currentPage++;
				doneesPanel.removeAll();
				list=new DoneeDaoImpl().getOnePage(getFirstIndexOfPage(currentPage));
				tolCount=DoneePresenter.getAllCount();
				for(int i=0;i<list.size();i++){
					DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(i));
					doneesPanel.add(doneeItemPanel);
				}
				currentPageLabel.setText("当前页数:"+currentPage);
				tolPage=tolCount%4==0?tolCount/4:(tolCount/4+1);
				tolPageLabel.setText("总页数:"+tolPage);
				doneesPanel.repaint();
			}
		});
	}
	public int getFirstIndexOfPage(int page){
		return (page-1)*4;
	}
}
