package sys.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import sys.model.clouddatabase.daoimpl.DoneeDaoImpl;
import sys.model.objects.Donee;
import sys.view.tableitem.DoneeItemPanel;

public class DoneeInfoJpanel extends JPanel {

	public DoneeInfoJpanel(){
		setBounds(GetResourceClass.getRealSize(300),GetResourceClass.getRealSize(235),GetResourceClass.getRealSize(650),GetResourceClass.getRealSize(560));//不可修改
		//setBackground(Color.blue);
		setLayout(new FlowLayout());
		ArrayList<Donee> list=new DoneeDaoImpl().getAll();
		setOpaque(true);
		DoneeItemPanel doneeItemPanel=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel1=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel2=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel3=new DoneeItemPanel(list.get(0));
		DoneeItemPanel doneeItemPanel4=new DoneeItemPanel(list.get(0));
		add(doneeItemPanel);
		add(doneeItemPanel1);
		add(doneeItemPanel2);
		add(doneeItemPanel3);
		add(doneeItemPanel4);
		System.out.println(getComponentCount()+"aa");
	}
}
