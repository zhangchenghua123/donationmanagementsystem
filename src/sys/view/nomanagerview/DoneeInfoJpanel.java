package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sys.model.clouddatabase.daoimpl.DoneeDaoImpl;
import sys.model.objects.Donee;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
import sys.view.tableitem.DoneeItemPanel;

public class DoneeInfoJpanel extends JPanel {

	private ImagePanel headPanel;
	private JPanel doneesPanel;
	private JScrollPane scrollPane;
	public DoneeInfoJpanel(){
		setBounds(GetResourceClass.getRealSize(300),GetResourceClass.getRealSize(5),
				GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(640));//不可修改
//		setBackground(Color.blue);
		setLayout(null);
		
		headPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/donation_head.png")));
		headPanel.setBounds(GetResourceClass.getRealSize(0),GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(50));
		add(headPanel);
		
		doneesPanel=new JPanel();
		
		doneesPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(591)));//不可修改
		doneesPanel.setLayout(new FlowLayout(1,0,1));
		doneesPanel.setOpaque(false);
		
		
		ArrayList<Donee> list=new DoneeDaoImpl().getAll();
		setOpaque(false);
		for(int i=0;i<list.size();i++){
			DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(i));
			
			doneesPanel.add(doneeItemPanel);
		}
		doneesPanel.setBounds(GetResourceClass.getRealSize(0),GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(140*list.size()));
		doneesPanel.setPreferredSize(new Dimension(GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(140*list.size())));//不可修改
		scrollPane=new JScrollPane(doneesPanel);
		scrollPane.setBounds(GetResourceClass.getRealSize(0),GetResourceClass.getRealSize(50),
				GetResourceClass.getRealSize(650), GetResourceClass.getRealSize(590));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		
	}
}
