package sys.view.manager;

import java.awt.Color;

import javax.swing.JPanel;

public class ContainerJPanel extends JPanel {

	public ContainerJPanel(){
		setBounds(0, 100, 1200, 650);
		setLayout(null);
		setOpaque(true);
		setBackground(new Color(239,239,239));
		add(new MenuJPanel());
//		add(new OperationJpanel());
		
		
	}
}
