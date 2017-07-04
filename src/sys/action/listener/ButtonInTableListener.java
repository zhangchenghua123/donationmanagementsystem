package sys.action.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class ButtonInTableListener implements ActionListener{

	 @Override
     public void actionPerformed(ActionEvent e) {
     	System.out.println("eeeee");
     	String label=((JButton)e.getSource()).getText();
     	JTable table=(JTable)((JButton)e.getSource()).getParent();
     	System.out.println("点击按钮名称："+label+",所在行:"+table.getSelectedRow()+",所在列:"+table.getSelectedColumn());
     }

}
