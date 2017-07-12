package sys.view.customView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import sys.view.GetResourceClass;
/**
 * 美化原生的输入框，添加内边距，文字不顶着紧左边
 * @author Berry
 *
 */
public class TextInput extends JTextField {

	private URL imgurl=GetResourceClass.class.getResource("image/inputbg_unactive.png");
	public TextInput(){
//		setMargin(new Insets(0,30, 0, 0));
		setBorder(new EmptyBorder(GetResourceClass.getRealSize(1), GetResourceClass.getRealSize(10),GetResourceClass.getRealSize(1),GetResourceClass.getRealSize(1)));
//		EmptyBorder empty = new EmptyBorder(0, 20, 0, 0);
//		CompoundBorder border = new CompoundBorder(getBorder(), empty);
//		setBorder(border);

	}
	
}
