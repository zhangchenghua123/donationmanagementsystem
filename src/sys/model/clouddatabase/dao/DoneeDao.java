package sys.model.clouddatabase.dao;

import java.util.ArrayList;

import sys.model.objects.Donee;

public interface DoneeDao {

	/**
	 * 判断一个身份证号是否存在
	 * @param objects :身份证号
	 * @return booleam: true:存在 false 不存在
	 */
	public boolean identityExisted(Object[] objects);
	
	/**
	 * 判断新发布的受助者电话是否已存在
	 * @param objects: 手机号
	 * @return boolean true:存在，false：不存在
	 */
	public boolean phoneExisted(Object[] objects);
	
	/**
	 * 判断银行卡号是否已存在
	 * @param objects:银行卡号
	 * @return  boolean true:存在，false：不存在
	 */
	public boolean cardExisted(Object[] objects);
	
	/**
	 * 插入一个受助者信息
	 * @param objects:受助者所有信息
	 * @return boolean true:成功 false：失败
	 */
	public boolean insert(Object[] objects);
	
	/**
	 * 获取一个受助者的所有信息，多表查询获取任务名称
	 * @param objects:受助者身份证号
	 * @return Donee:受助者对象
	 */
	public Donee query(Object[] objects);
	
	/**
	 * 获取所有受助者简要信息，包括姓名，性别，图片，地址，期望金额，经历，已募捐金额
	 * @return list:受助者对象集合
	 */
	public ArrayList<Donee> getAll();
	
	/**
	 * 根据身份证修改已募捐金额
	 * @param objects:身份证，新添加的金额
	 * @return boolean true:修改成功 false 修改失败
	 */
	public boolean updateDonateAmount(Object[] objects);
	
	
	
	/**
	 * 根据身份证修改已收到金额
	 * @param objects:身份证，新添加的金额
	 * @return boolean true:修改成功 false 修改失败
	 */
	public boolean updateReceivedAmount(Object[] objects);
	
	
	
	/**
	 * 更新是否继续接受援助状态为不接受
	 * @param objects:身份证
	 * @return true 更新成功；false 更新失败
	 */
	public boolean updateContinue();
	
	
	/**
	 * 根据身份证修改是否结束援助状态为已经援助
	 * @param objects:身份证
	 * @return boolean true:修改成功 false 修改失败
	 */
	public boolean updateFinish();
}
