package sys.presenter;

import sys.GlobalVariables;
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
		String name=sys.query(object);
		if(name!=null){
			SystemManager sysMan=new SystemManager();
			sysMan.setAccount(account);
			sysMan.setName(name);
			sysMan.setPassword(password);
			//将对象保存到GlobalVariables静态变量里边
			//GlobalVariables glovar=new GlobalVariables();
			GlobalVariables.userInfo.put("type","系统管理员");
			GlobalVariables.userInfo.put("user",sysMan);
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
		Object[] object=new Object[1];
		object[0]=newPassword;
		SysMgtDaoImpl sys=new SysMgtDaoImpl();
		boolean b=sys.updatePassword(object);
		if(b){
			//修改全局变量里保存的对象的密码
			SystemManager sysNam=new SystemManager();
			sysNam=(SystemManager) GlobalVariables.userInfo.get("user");
			sysNam.setPassword(newPassword);
			GlobalVariables.userInfo.put("type","系统管理员");
			GlobalVariables.userInfo.put("user",sysNam);
			return true;
		}
		return false;
	}
}
