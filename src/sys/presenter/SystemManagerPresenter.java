package sys.presenter;

import sys.model.clouddatabase.daoimpl.SysMgtDaoImpl;
import sys.model.objects.SystemManager;

/**
 * 
 * @author 邓
 *
 */
public class SystemManagerPresenter {

	/**
	 * 1
	 * 判断是否登录成功，成功后要将类型"系统管理员"，系统管理员对象保存到GlobalVariables静态变量里边
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean login(String account,String password){
		Object[] object=new Object[2];
		object[0]=account;
		object[1]=password;
		//SystemManager sys=new SystemManager();
		SysMgtDaoImpl sys=new SysMgtDaoImpl();
		String s=sys.query(object);
		if(s!=null){
			//将对象保存到GlobalVariables静态变量里边
			return true;
		}
		return false;
	}
	/**
	 * 2
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */
	public static boolean updatePassword(String newPassword){
		Object[] object=new Object[2];
		object[0]=newPassword;
		SysMgtDaoImpl sys=new SysMgtDaoImpl();
		boolean b=sys.updatePassword(object);
		if(b){
			return true;
		}
		return false;
	}
}
