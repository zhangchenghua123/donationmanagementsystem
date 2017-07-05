package sys.view;

import java.awt.Toolkit;

public class GetResourceClass {

	/**
	 * 获取对应的大小
	 * @param px
	 * @return
	 */
	public static int getRealSize(int px){
		int pxPerLength=Toolkit.getDefaultToolkit().getScreenResolution();
		return (int)(px/120.0*pxPerLength);
	}
}