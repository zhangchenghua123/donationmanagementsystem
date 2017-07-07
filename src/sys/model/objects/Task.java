package sys.model.objects;

/**
 * 任务类
 * 属性：属性ID，任务名
 * @author 邓
 */
public class Task {

	private int taskId;
	private String task;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
}
