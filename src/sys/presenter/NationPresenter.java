package sys.presenter;

import java.util.ArrayList;

import sys.model.clouddatabase.daoimpl.NationDaoImpl;
import sys.model.objects.Nationality;
/**
 * 
 * @author 顾
 *
 */
public class NationPresenter {

	/**
	 * 1
	 * @return
	 */
	public static ArrayList<Nationality> getAll(){
		ArrayList<Nationality> list = new ArrayList<Nationality>();
		NationDaoImpl nationDaoImpl = new NationDaoImpl();
		list = nationDaoImpl.getAll();
		if(list.size() != 0)
			return list;
		else
			return null;
	}
}
