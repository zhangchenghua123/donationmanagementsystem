package sys.presenter;

public class LoginPresenter {

	/**
	 * 登录失败直接返回false，登录成功先添加用户信息至GlobalVriable类中，返回true。
	 * @param userType
	 * @param userAccount
	 * @param password
	 * @return
	 */
	public static boolean login(String userType,String userAccount,String password){
		
		if(userType.equals("系统管理员"))
			return SystemManagerPresenter.login(userAccount, password);
		else if(userType.equals("事例管理员"))
			return AffairManagerPresenter.login(userAccount, password);
		else if(userType.equals("财务人员"))
			return FinManagerPresenter.login(userAccount, password);
		else 
			return DonorPresenter.login(userAccount, password);
	}
}
