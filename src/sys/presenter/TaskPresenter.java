package sys.presenter;

import sys.model.clouddatabase.daoimpl.TaskDaoImpl;
import sys.view.GetResourceClass;

/**
 * 
 * @author 邓
 *
 */
public class TaskPresenter {
	/**
	 * 1
	 * @param newTask
	 * @return
	 */
	public static boolean insertNewTask(String newTask){
		Object[] objects=new Object[1];
		objects[0]=newTask;
		TaskDaoImpl tdi=new TaskDaoImpl();
		boolean b=tdi.insert(objects);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * 1
	 * @param task
	 * @return
	 */
	public static int getTaskIdByName(String task){
		Object[] objects=new Object[1];
		objects[0]=task;
		TaskDaoImpl tdi=new TaskDaoImpl();
		int id=tdi.getId(objects);
		if(id!=0){
			return id;
		}
		return -1;
	}
	public static boolean taskExisted(String task){
		return new TaskDaoImpl().nameExisted(new Object[]{task});
	}
	
}
