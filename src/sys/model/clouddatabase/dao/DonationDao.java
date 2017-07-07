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
	 * 修改打款状态为已打款
	 * @param objects: 时间，捐助者账号，受捐者身份证号
	 * @return boolean true 成功 false 失败
	 */
	public boolean updateState(Object[] objects);
	
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
	 * 获取所有捐助历史记录,按时间排序，最新的在最前边
	 * @return list：捐助历史集合
	 */
	public ArrayList<Donation> getAll();
	/**
	 * 获取捐助总人次
	 */
	public int getCount();
}
