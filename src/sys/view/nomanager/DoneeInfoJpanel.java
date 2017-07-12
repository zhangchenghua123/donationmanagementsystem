package sys.view.nomanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sys.model.clouddatabase.daoimpl.DoneeDaoImpl;
import sys.model.objects.Donee;
import sys.view.GetResourceClass;
import sys.view.customView.ImagePanel;
import sys.view.tableitem.DoneeItemPanel;

public class DoneeInfoJpanel extends JPanel {

	private ImagePanel headPanel;
	public DoneeInfoJpanel(){
		setBounds(GetResourceClass.getRealSize(300),GetResourceClass.getRealSize(5),GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(640));//不可修改
		//setBackground(Color.blue);
		setLayout(new FlowLayout(1,0,1));
		
		headPanel=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/donation_head.png")));
		headPanel.setPreferredSize(new Dimension(650, 50));
		add(headPanel);
		ArrayList<Donee> list=new DoneeDaoImpl().getAll();
		setOpaque(true);
		DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel1=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel2=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel3=new DoneeItemPanel(list.get(0));
		add(doneeItemPanel);
		add(doneeItemPanel1);
		add(doneeItemPanel2);
		add(doneeItemPanel3);
		
		
	}
}
