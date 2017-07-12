package sys.presenter;

import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

import sys.GlobalVariables;
import sys.model.clouddatabase.daoimpl.FinMgtDaoImpl;
import sys.model.objects.FinancialManager;

/**
 * 
 * @author 顾
 *
 */
public class FinManagerPresenter {

	/**
	 * 1
	 * 判断是否登录成功，成功后要将类型"财务人员"，财务人员对象保存到GlobalVariables静态变量里边
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean login(String account,String password){
		Object[] objects = new Object[]{account,password};
		String name = new FinMgtDaoImpl().query(objects);
		if(name == null)
			return false;
		else{
			GlobalVariables.userInfo = new HashMap<>();
			GlobalVariables.userInfo.put("type", "财务人员");
			FinancialManager f = new FinancialManager();
			f.setAccount(account);
			f.setPassword(password);
			f.setName(name);
			GlobalVariables.userInfo.put("user",f);
			return true;
		}	
	}
	/**
	 * 2
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */
	public static boolean updatePassword(String newPassword){
		Object[] object = new Object[1];
		object[0] = newPassword;
		FinMgtDaoImpl finMgtDaoImpl = new FinMgtDaoImpl();
		boolean isSuccess = finMgtDaoImpl.updatePassword(object);
		if(isSuccess)
		{
			FinancialManager financialManager = new FinancialManager();
			financialManager = (FinancialManager) GlobalVariables.userInfo.get("user");
			financialManager.setPassword(newPassword);
			return true;
		}
		else
			return false;
	}
}
