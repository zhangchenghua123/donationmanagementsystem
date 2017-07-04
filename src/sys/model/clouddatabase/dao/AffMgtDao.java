package sys.model.clouddatabase.dao;

import java.util.ArrayList;

import sys.model.objects.AffairManager;


public interface AffMgtDao {

	
	/**
	 * 添加一个事例管理员前验证账号是否重复
	 * @param objects: 保存了事例管理员的账号
	 * @return b true:已有该账号 false 没重复的。
	 */
	public boolean accountAlreadyExisted(Object[] objects);
	
	
	/**
	 * 验证账号不重复后，添加至数据库
	 * @param objects:保存了事例管理员的账号，姓名，密码，任务id
	 * @return b true:添加成功 false:添加失败
	 */
	public boolean insert(Object[] objects);
	
	
	/**
	 * 登录时，验证账号和密码
	 * @param objects:保存着输入的账号，密码。
	 * @return AffairManager:返回对应的管理员,AffairManager的任务名称属性由事例管理员表和任务表的自然连接获得，如果账户或密码错误，没找到，返回null
	 */
	public AffairManager query(Object[] objects);
	
	
	
	/**
	 * 修改密码。说明：修改密码时要输入旧密码，验证旧密码正误。此时全局变量里保存着旧密码，可提前验证。此步是直接更新密码
	 * @param objects,保存着要修改的事例管理员的账号,新密码
	 * @return b true:修改成功  ;false:修改失败
	 */
	public boolean updatePassword(Object[] objects);
	
	/**
	 * 查询所有的事例管理人员。多表查询，AffairManager的任务名称属性由事例管理员表和任务表的自然连接获得
	 * @return list:管理员集合
	 */
	public ArrayList<AffairManager> queryAll();
}
