package sys.model.objects;

/**
 * 事例管理员类
 * 属性：账号，姓名，密码，任务名称,任务ID
 * @author 邓
 *
 */
public class AffairManager {

	private String account;//账号
	private String name;//姓名
	private String password;//密码
	private String task;//任务名称
	private int taskId;//任务ID

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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
