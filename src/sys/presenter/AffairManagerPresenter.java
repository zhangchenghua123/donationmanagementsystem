package sys.presenter;

import java.util.ArrayList;

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
	public boolean accountAlreadyExisted(String account){
		return false;
	}
	/**
	 * affairManager封装着账号，姓名，密码，任务ID
	 */
	public boolean register(AffairManager affairManager){
		return false;
	}
	/**
	 * 判断是否登录成功，成功后将类型，系统管理员对象保存到GlobalVariables静态变量里边
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean login(String account,String password){
		
		return false;
	}
	/**
	 * 此时登录着的事例管理员信息存在全局变量GlobalVariables静态变量里边
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */
	public static boolean updatePassword(String newPassword){
		
		return false;
	}
	/**
	 * 获取所有事例管理员,账号，姓名，任务名称。
	 * @return 
	 */
	public static ArrayList<AffairManager> getAllAffManagers(){
		
		return null;
	}
}
