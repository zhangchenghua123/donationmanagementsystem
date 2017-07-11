package sys.presenter;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import sys.model.clouddatabase.daoimpl.DoneeDaoImpl;
import sys.model.objects.Donee;
/**
 * 
 * @author 顾
 *
 */
public class DoneePresenter {

	public static int IDENTITY_EXISTED = 0;
	public static int PHONE_EXISTED = 1;
	public static int CARD_EXISTED = 2;

	/**
	 * 1
	 * 验证身份证是否存在，存在返回IDENTITY_EXISTED 否则验证手机号是否存在，存在返回PHONE_EXISTED
	 * 否则验证银行卡是否存在，存在返回CARD_EXISTED
	 * 
	 * @param identity
	 * @param phone
	 * @param card
	 * @return
	 */
	public static int validate(String identity, String phone, String card) {
		Object[] objects1 = new Object[1];
		Object[] objects2 = new Object[1];
		Object[] objects3 = new Object[1];
		objects1[0] = identity;
		objects2[0] = phone;
		objects3[0] = card;
		DoneeDaoImpl doneeDaoImpl = new DoneeDaoImpl();
		if(doneeDaoImpl.identityExisted(objects1))
			return IDENTITY_EXISTED;
		else if(doneeDaoImpl.phoneExisted(objects2))
			return PHONE_EXISTED;
		else if(doneeDaoImpl.cardExisted(objects3))
			return CARD_EXISTED;
		return -1;
	}

/**
	 * 1
	 * 获取所有受助者信息
	 * 
	 * @return
	 */
	public static ArrayList<Donee> getAll() {
		ArrayList<Donee> list = new ArrayList<Donee>();
		DoneeDaoImpl doneeDaoImpl = new DoneeDaoImpl();
		list = doneeDaoImpl.getAll();
		if(list.size() != 0)
			return list;
		else
			return null;
	}

	/**
	 * 2
	 * 根据身份证获取某一个受捐者信息
	 * 
	 * @param identity
	 * @return
	 */
	public static Donee getDonee(String identity) {
		//暂时不写
		
		return null;
	}
	/**
	 * 2
	 * @param identity
	 * @param increase
	 * @return
	 */
	public static boolean updateDonateAmount(String identity, float increase) {
		Object[] objects = new Object[]{identity,increase};
		boolean isSuccess = new DoneeDaoImpl().updateDonateAmount(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	/**
	 * 2
	 * @param identity
	 * @param increase
	 * @return
	 */
	public static boolean updateReceivedAmount(String identity, float increase) {
		Object[] objects = new Object[]{identity,increase};
		boolean isSuccess = new DoneeDaoImpl().updateReceivedAmount(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	/**
	 * 2
	 * @param identity
	 * @return
	 */
	public static boolean updateContinue(String identity) {
		Object[] objects = new Object[1];
		objects[0] = identity;
		boolean isSuccess = new DoneeDaoImpl().updateContinue(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	/**
	 * 2
	 * @param identity
	 * @return
	 */
	public static boolean updateFinish(String identity) {
		Object[] objects = new Object[1];
		objects[0] = identity;
		boolean isSuccess = new DoneeDaoImpl().updateFinish(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	/**
	 * 2
	 * @param id
	 * @return
	 */
	public static ArrayList<Donee> getDoneeByTaskId(int id){
		Object[] objects = new Object[1];
		objects[0] = id;
		ArrayList<Donee> list = new ArrayList<Donee>();
		DoneeDaoImpl doneeDaoImpl = new DoneeDaoImpl();
		list = doneeDaoImpl.getDoneeByTaskId(objects);
		if(list.size() != 0)
			return list;
		else
			return null;
	}
}
