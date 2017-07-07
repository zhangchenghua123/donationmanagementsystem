package sys.model.objects;

/**
 * 事例管理员类
 * 属性：账号，姓名，密码，任务名称
 * @author 邓
 *
 */
public class AffairManager {

	private String account;
	private String name;
	private String password;
	private String task;
	public AffairManager(String account,String name,String password, String task){
		this.account=account;
		this.name=name;
		this.password=password;
		this.task = task;
	}
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public AffairManager() {
		// TODO 自动生成的构造函数存根
	}
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
