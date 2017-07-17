package sys.model.clouddatabase.dao;
/**
 * 操作财务人员表的dao
 * @author Berry
 *
 */
public interface FinMgtDao {
	/**
	 * 验证财务人员身份
	 * @param objects:保存着输入的财务人员的账号，密码
	 * @return String: 返回查找到的姓名，如没找到，返回null
	 */
	public String query(Object[] objects);
	/**
	 * 修改密码
	 * @param objects:保存着新密码
	 * @return b true:修改密码成功 ,false:修改失败
	 */
	public boolean updatePassword(Object[] objects);
	
}
