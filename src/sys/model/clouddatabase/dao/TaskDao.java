package sys.model.clouddatabase.dao;

public interface TaskDao {

	/**
	 * 添加任务时检查任务名是否重复
	 * @param objects:要添加的任务名
	 * @return boolean true:重复 false：不重复
	 */
	public boolean nameExisted(Object[] objects);
	
	/**
	 * 插入一个任务
	 * @param objects:任务名
	 * @return boolean true:成功 false 失败
	 */
	public boolean insert(Object[] objects);
	
	/**
	 * 返回一个任务名对应的ID
	 * @param objects:名称
	 * @return int :id
	 */
	public int getId(Object[] objects);
}
