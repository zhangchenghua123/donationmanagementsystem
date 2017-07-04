package sys.model.clouddatabase.dao;



public interface SysMgtDao {

	
	/**
	 * 系统管理员登录时验证身份
	 * @param objects，保存了账号和密码
	 * @return String, 返回查找到的管理员姓名,账号或密码错误则返回null
	 */
	public String query(Object[] objects);
	
	/**
	 * 系统管理员修改密码。说明：修改密码时要输入旧密码，验证旧密码正误。此时全局变量里保存着旧密码，可提前验证。此步是直接更新密码
	 * @param objects,旧密码
	 * @return b true:修改成功  ;false:修改失败
	 */
	public boolean updatePassword(Object[] objects);
}
