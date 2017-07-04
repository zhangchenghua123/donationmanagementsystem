package sys.action.listener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class AnnTableListener implements MouseListener, MouseMotionListener {

	private static int currentRow = -1;

	private JTable table;
	private RoutineColor rColor;
	public AnnTableListener(JTable table,RoutineColor rColor){
		this.table=table;
		this.rColor=rColor;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = ((JTable) e.getComponent()).rowAtPoint(e.getPoint());
//		if(currentRow!=-1&&currentRow!=row){
			currentRow=row;
			rColor.setMouseEnterRowRow(currentRow);
			table.repaint();
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		currentRow = ((JTable) e.getComponent()).rowAtPoint(e.getPoint());

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public static RoutineColor getRender(){
		return new RoutineColor();
	}

	public static class RoutineColor extends DefaultTableCellRenderer {
		int mouseEnterRow = -1;

		public void setMouseEnterRowRow(int mouseEnterRow) {
			this.mouseEnterRow = mouseEnterRow;
			System.out.println("mouseEnterRow = " + mouseEnterRow);
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component comp = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
			if (mouseEnterRow != -1 && mouseEnterRow == row) {
				System.out.println("setred");
				setForeground(Color.red); // 设置其它行
			} else {
				setForeground(Color.white); // 设置其它行
			}
			return comp;
		}


}

}
