package sys.view.managerview.managerfactory;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sys.view.GetResourceClass;

public class MenuProduct extends JPanel {

	public MenuProduct(){
		setLayout(new FlowLayout(1,0,0));
		setBounds(GetResourceClass.getRealSize(15), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(240), GetResourceClass.getRealSize(200));
		setBorder(new LineBorder(new Color(228,228,228),2));
		setBackground(new Color(250,250,250));
	}
}
