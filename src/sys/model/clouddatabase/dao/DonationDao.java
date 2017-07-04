package sys.model.clouddatabase.dao;

import java.util.ArrayList;

import sys.model.objects.Donation;

public interface DonationDao {

	/**
	 * 添加一条捐助记录
	 * @param objects:时间，捐助者账号，受捐者身份证号，捐助额，是否已打款给受助者
	 * @return boolean:true 成功 false 失败
	 */
	public boolean insert(Object[] objects);
	
	/**
	 * 修改打款状态
	 * @return boolean true 成功 false 失败
	 */
	public boolean updateState();
	
	/**
	 * 根据捐助者账户查找，多表查询 捐助表，受捐者表
	 * @param objects:捐助者账户
	 * @return list:捐助历史集合
	 */
	public ArrayList<Donation> getDonationsByDonor(Object[] objects);
	
	
	/**
	 * 根据受捐者身份证查找，多表查询 捐助表，受捐者表
	 * @param objects：受助者身份证号
	 * @return list:捐助历史集合
	 */
	public ArrayList<Donation> getDonationByDonee(Object[] objects);
	
	/**
	 * 获取总的捐助额
	 * @return :float
	 */
	public float getAllAmount();
	
}
