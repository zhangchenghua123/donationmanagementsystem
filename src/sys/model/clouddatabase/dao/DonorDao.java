package sys.model.clouddatabase.dao;

import sys.model.objects.Donor;

public interface DonorDao {

	/**
	 * 判断一个账号是否存在
	 * @param objects:账号
	 * @return　boolean true:存在 ，false 不存在
	 */
	public boolean accountExisted(Object[] objects);
	/**
	 * 判断一个邮箱是否存在
	 * @param objects:邮箱
	 * @return boolean true:存在 ，false 不存在
	 */
	public boolean mailboxExisted(Object[] objects);
	/**
	 * 插入一个捐助者
	 * @param objects:账号，密码，国籍id，姓名，邮箱，捐助总额
	 * @return boolean true:插入成功 false：插入失败
	 */
	public boolean insert(Object[] objects);
	/**
	 * 修改密码
	 * @param objects:账号，新密码
	 * @return boolean 	 true:成功  false：失败
	 */
	public boolean updatePassword(Object[] objects);
	
	/**
	 * 修改捐助总额，SQL语句中用原来的加上新捐助额。
	 * 不用写
	 * 此过程在触发器中进行
	 * @param objects:账号，新捐助额
	 */
	public boolean updateTolMoney(Object[] objects);
	
	/**
	 * 根据账号获得整条记录,多表查询，连接上国籍名称
	 * @param objects:账号,密码
	 * @return donor:捐助者对象
	 */
	public Donor query(Object[] objects);
	/**
	 * 获取捐助者的数量
	 */
	public int getCount();
}
