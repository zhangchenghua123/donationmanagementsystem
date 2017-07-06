package sys.presenter;

import sys.model.clouddatabase.daoimpl.DonorDaoImpl;
import sys.model.objects.Donor;
/**
 * 
 * @author 珂
 *
 */
public class DonorPresenter {

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
	 * 此时登录着的捐助者信息存在全局变量GlobalVariables静态变量里边
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */
	public static boolean updatePassword(String newPassword){
		
		return false;
	}
	
	public static boolean accountExisted(String account){
		Object[] objects=new Object[]{account};
		return new DonorDaoImpl().accountExisted(objects);
	}
	
	public static boolean emailRepeated(String email){
		
		return false;
	}
	public static boolean register(Donor donor){
		
		return false;
	}
	
	public static Donor getDonorByAccount(String account){
		
		return null;
	}
	
}
