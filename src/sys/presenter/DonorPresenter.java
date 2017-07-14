package sys.presenter;

import java.util.HashMap;

import sys.GlobalVariables;
import sys.model.clouddatabase.daoimpl.DonorDaoImpl;
import sys.model.objects.Donor;
/**
 * 
 * @author 珂
 *
 */
public class DonorPresenter {

	/**    
	 * 1
	 * 判断是否登录成功，成功后将类型"捐助者"，系统管理员对象保存到GlobalVariables静态变量里边
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean login(String account,String password){
		Object []object=new Object[2];
		object[0]=account;
		object[1]=password;
		DonorDaoImpl don=new DonorDaoImpl();
		Donor donor=don.query(object);
		if(donor!=null){
			//将affair存储至GlobalVariables静态变量中
			GlobalVariables.userInfo = new HashMap<String, Object>();
			GlobalVariables.userInfo.put("type", "捐助者");
			GlobalVariables.userInfo.put("user", donor);
			return true;
		}
		else
			return false;
	}
	/**
	 * 2
	 * 此时登录着的捐助者信息存在全局变量GlobalVariables静态变量里边
	 * 同时修改全局变量里保存的对象的密码
	 * @param newPassword
	 * @return
	 */ 
	public static boolean updatePassword(String newPassword){
		Object []object=new Object[2];
		object[1]=newPassword;
		Donor don=(Donor) GlobalVariables.userInfo.get("user");
		object[0]=don.getAccount();
		DonorDaoImpl donor=new DonorDaoImpl();
		boolean i=donor.updatePassword(object);
		if(i){
			//修改全局变量里保存的对象的密码
			don.setPassword(newPassword);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 1
	 * @param account
	 * @return
	 */
	public static boolean accountExisted(String account){
		Object[] objects=new Object[]{account};
		return new DonorDaoImpl().accountExisted(objects);
	}
	/**
	 * 1
	 * @param email
	 * @return
	 */
	public static boolean emailRepeated(String email){
		Object[] objects=new Object[]{email};
		return new DonorDaoImpl().mailboxExisted(objects);
	}
	/**
	 * 1
	 * @param donor
	 * @return
	 */
	public static boolean register(Donor donor){
		DonorDaoImpl don=new DonorDaoImpl();
		Object []object=new Object[6];
		object[0]=donor.getAccount();
		object[1]=donor.getPassword();
		object[2]=donor.getNationID();
		object[3]=donor.getName();
		object[4]=donor.getMailbox();
		object[5]=donor.getTolMoney();
		boolean b=don.insert(object);
		if(b){
			return true;
		}
		return false;
	}
	public static boolean updateTolMoney(String account,float increase){
		Object[] objects=new Object[]{account,increase};
		return new DonorDaoImpl().updateTolMoney(objects);
	}
	
}
