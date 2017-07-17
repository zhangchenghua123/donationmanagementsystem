package sys.presenter;

import java.util.ArrayList;
import java.util.HashMap;

import sys.GlobalVariables;
import sys.model.clouddatabase.daoimpl.AffMgtDaoImpl;
import sys.model.objects.AffairManager;

/**
 * 
 * @author 邓
 *
 */
public class AffairManagerPresenter {

	/**
	 * 
	 */
	public static boolean accountAlreadyExisted(String account){
		AffMgtDaoImpl aff=new AffMgtDaoImpl();
		Object []object=new Object[1];
		object[0]=account;
		boolean b=aff.accountAlreadyExisted(object);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * 1
	 * 事例管理员注册，affairManager封装着账号，姓名，密码，任务ID
	 */
	public static boolean register(AffairManager affairManager){
		AffMgtDaoImpl aff=new AffMgtDaoImpl();
		Object []object=new Object[4];
		object[0]=affairManager.getAccount();
		object[1]=affairManager.getName();
		object[2]=affairManager.getPassword();
		object[3]=affairManager.getTaskId();
		boolean b=aff.insert(object);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * 1
	 * 判断是否登录成功，成功后将类型"事例管理员"，系统管理员对象保存到GlobalVariables静态变量里边
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean login(String account,String password){
		Object []object=new Object[2];
		object[0]=account;
		object[1]=password;
		AffMgtDaoImpl aff=new AffMgtDaoImpl();
		AffairManager affair=aff.query(object);
		if(affair!=null){
			//将affair存储至GlobalVariables静态变量中
			GlobalVariables.userInfo = new HashMap<String, Object>();
			GlobalVariables.userInfo.put("type", "事例管理员");
			GlobalVariables.userInfo.put("user", affair);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 2
	 * 此时登录着的事例管理员信息存在全局变量GlobalVariables静态变量里边，从中获取account
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */
	public static boolean updatePassword(String newPassword){
		Object []object=new Object[2];
		object[1]=newPassword;
		AffairManager affMan=new AffairManager();
		affMan=(AffairManager) GlobalVariables.userInfo.get("user");
		object[0]=affMan.getAccount();
		AffMgtDaoImpl aff=new AffMgtDaoImpl();
		boolean i=aff.updatePassword(object);
		if(i){
			//修改全局变量里保存的对象的密码
			affMan.setPassword(newPassword);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 1
	 * 获取所有事例管理员,账号，姓名，任务名称。
	 * @return 
	 */
	public static ArrayList<AffairManager> getAllAffManagers(){
		AffMgtDaoImpl aff=new AffMgtDaoImpl();
		ArrayList<AffairManager> list=new ArrayList<AffairManager>();
		list=aff.queryAll();
		if(list!=null){
			return list;
		}
		return null;
	}
}
