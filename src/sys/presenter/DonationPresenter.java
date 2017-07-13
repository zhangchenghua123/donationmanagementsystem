package sys.presenter;

import java.util.ArrayList;

import java.sql.Date;

import sys.model.clouddatabase.daoimpl.AffMgtDaoImpl;
import sys.model.clouddatabase.daoimpl.DonationDaoImpl;
import sys.model.clouddatabase.daoimpl.DonorDaoImpl;
import sys.model.objects.AffairManager;
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
		return new DonationDaoImpl().getAll();
	}
	/**
	 * 1
	 * 获取总的捐助次数
	 */
	public static int getCount(){
		return new DonationDaoImpl().getCount();
	}
	/**
	 * 1
	 * 插入一条捐助记录
	 */
	public static boolean insert(Donation donation){
		Object[] object=new Object[]{donation.getTime(),donation.getDonorAccount(),donation.getDoneeIdentity(),
				donation.getAmount(),0};
		return new DonationDaoImpl().insert(object);
	}
	/**
	 * 1
	 * 根据捐助者账号查找捐助记录
	 */
	public static ArrayList<Donation> getDonationsByDonor(String account){
		Object[] object=new Object[]{account};
		return new DonationDaoImpl().getDonationsByDonor(object);
	}
	/**
	 * 1
	 * 根据受捐者身份证号查找捐助记录
	 */
	public static ArrayList<Donation> getDonationsByDonee(String identity){
		Object[] object=new Object[]{identity};
		return new DonationDaoImpl().getDonationByDonee(object);
	}
	/**
	 * 1
	 * 修改捐助记录状态为已打款
	 */
	public static boolean updateState(Date data,String account,String identity){
		//Object[] object=new Object[3];
		Object[] object=new Object[]{data,account,identity};
		DonationDaoImpl dntd=new DonationDaoImpl();
		boolean dnt=dntd.updateState(object);
		return dnt;
	}
	/**
	 * 获取所有未打款的捐助记录
	 * @return
	 */
	public ArrayList<Donation> getAllNotPaid() {
		return new DonationDaoImpl().getAllNotPaid();
	}
}
