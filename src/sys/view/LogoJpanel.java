package sys.view;

import java.awt.Color;

import javax.swing.JPanel;

public class LogoJpanel extends JPanel {

	public LogoJpanel(){
		setBounds( GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(80), GetResourceClass.getRealSize(900), GetResourceClass.getRealSize(150));
		setBackground(Color.black);
	}
}