package sys.view.nomanagerview;

import java.awt.Color;

import javax.swing.JPanel;

import sys.view.GetResourceClass;
/**
 * 系统捐助
 * @author Berry
 *
 */
public class DonationJpanel extends JPanel {

	public DonationJpanel(){
		setBounds(GetResourceClass.getRealSize(955),GetResourceClass.getRealSize(5),GetResourceClass.getRealSize(240),GetResourceClass.getRealSize(640));//不可修改
//		setBackground(Color.gray);
		setOpaque(false);
	}
}
