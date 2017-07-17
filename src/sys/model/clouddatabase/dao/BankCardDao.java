package sys.model.clouddatabase.dao;

import sys.model.objects.PlatformBankCard;

public interface BankCardDao {

	/**
	 * 查询平台银行卡
	 * @return PlatformBankCard对象,查不到返回null
	 */
	public PlatformBankCard query();
	
	/**
	 * 修改余额
	 * 不用写
	 * 此过程在触发器中进行
	 * @param float:新余额
	 * @return Boolean true：修改成功 false：修改失败
	 */
	public boolean updateBalance(Object[] objects);
	
	/**
	 * 修改总捐助金额
	 * 不用写
	 * 此过程在触发器中进行
	 * @param objects:新添加的捐助金额
	 * @return boolean true 修改成功，false 修改失败
	 */
	public boolean updateTolDonation(Object[] objects);
}
