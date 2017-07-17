package sys.model.objects;

/**
 * 财务人员
 * 属性：账户，姓名，密码
 * @author 宏
 */
public class FinancialManager {

	private String account;    //账户
	private String name;        //名字
	private String password;    //密码
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
