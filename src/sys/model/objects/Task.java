package sys.model.objects;

/**
 * 任务类
 * 属性：任务id,任务名
 * @author 邓
 */
public class Task {

	private int taskID;
	private String task;
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
}
