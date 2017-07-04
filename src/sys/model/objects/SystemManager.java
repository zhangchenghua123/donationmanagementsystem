package sys.model.objects;

/**
 * 系统管理员类
 * 属性：账户，姓名，密码
 * @author 华
 */
public class SystemManager {

	private String account;
	private String name;
	private String password;
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
