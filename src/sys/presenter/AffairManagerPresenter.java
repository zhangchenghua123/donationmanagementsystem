package sys.presenter;
/**
 * 
 * @author 邓
 *
 */
public class AffairManagerPresenter {

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
	 * 获取所有事例管理员
	 * @return 多行三列数组，每一行有事例管理员账号，姓名，任务名
	 */
	public static String[][] getAllAffManagers(){
		
		return null;
	}
}
