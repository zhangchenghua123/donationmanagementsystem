package sys.presenter;

import java.sql.Date;
import java.util.ArrayList;

import sys.model.clouddatabase.daoimpl.AnmtDaoImpl;
import sys.model.objects.AffairManager;
import sys.model.objects.Announcement;

/**
 * 
 * @author 邓
 *
 */
public class AnmtPresenter {

	/**
	 * 插入一个公告
	 */
	public static boolean insert(Date time,String title,String content){
		Object []objects=new Object[3];
		objects[0]=time;
		objects[1]=title;
		objects[2]=content;
		AnmtDaoImpl anmt=new AnmtDaoImpl();
		boolean b=anmt.insert(objects);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * 获取所有公告
	 */
	public static ArrayList<Announcement> getAll(){
		AnmtDaoImpl anmt=new AnmtDaoImpl();
		ArrayList<Announcement> list=new ArrayList<Announcement>();
		list = anmt.queryAll();
		if(list!=null){
			return list;
		}
		return null;
	}
}
