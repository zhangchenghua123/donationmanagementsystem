package sys.presenter;

import java.util.ArrayList;

import java.sql.Date;

import sys.model.objects.Donation;

/**
 * 
 * @author 珂
 *
 */
public class DonationPresenter {

	/**
	 * 1
	 * 按时间正序获取所有捐助记录
	 */
	public static ArrayList<Donation> getAll(){
		
		return null;
	}
	/**
	 * 1
	 * 获取总的捐助次数
	 */
	public static int getCount(){
		return -1;
	}
	/**
	 * 1
	 * 插入一条捐助记录
	 */
	public static boolean insert(Donation donation){
		
		return false;
	}
	/**
	 * 1
	 * 根据捐助者账号查找捐助记录
	 */
	public static ArrayList<Donation> getDonationsByDonor(String account){
		
		return null;
	}
	/**
	 * 1
	 * 根据受捐者身份证号查找捐助记录
	 */
	public static ArrayList<Donation> getDonationsByDonee(String identity){
		
		return null;
	}
	/**
	 * 1
	 * 修改捐助记录状态为已打款
	 */
	public static boolean updateState(Date data,String account,String identity){
		return false;
	}
	/**
	 * 获取所有未打款的捐助记录
	 * @return
	 */
	public ArrayList<Donation> getAllNotPaid() {
		
		return null;
	}
}
