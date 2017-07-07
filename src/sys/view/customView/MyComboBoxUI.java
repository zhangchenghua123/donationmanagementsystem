package sys.view.customView;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;


public class MyComboBoxUI extends BasicComboBoxUI {
    public static ComponentUI createUI(JComponent c) {
	      return new MyComboBoxUI();
	    }

	    protected JButton createArrowButton() {
	      JButton button = new BasicArrowButton(BasicArrowButton.SOUTH);
	      return button;
	    }
	  }