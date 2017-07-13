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

	public static  final int IDENTITY_EXISTED = 0;
	public static final int PHONE_EXISTED = 1;
	public static final int CARD_EXISTED = 2;

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
			return list;
	}

	/**
	 * 2
	 * 根据身份证获取某一个受捐者信息
	 * 
	 * @param identity
	 * @return
	 */
	public static Donee getDonee(String identity) {
		Donee donee = new Donee();
		Object[] objects = new Object[1];
		objects[0] = identity;
		System.out.println(1111);
		donee = new DoneeDaoImpl().query(objects);
		System.out.println(222);
		return donee;
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
	public static boolean updateFinish(ArrayList<String> identities) {
		
		boolean isSuccess = new DoneeDaoImpl().updateFinish(identities);
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
			return list;

	}
	/**
	 * 获取属于某一taskid的受助者人数
	 */
	public static int getCountByTaskId(int taskid){
		Object[] objects = new Object[1];
		objects[0] = taskid;
		int count = new DoneeDaoImpl().getCountByTaskId(objects);
		return count;
	}
	/**
	 * 获取属于某一taskid的总期望金额
	 */
	public static float getTolExpectedAmountByTaskId(int taskid){
		Object[] objects = new Object[1];
		objects[0] = taskid;
		float total = new DoneeDaoImpl().getTolExpectedAmountByTaskId(objects);
		return total;
	}
	/**
	 * 获取属于某一taskid的总募捐金额
	 */
	public static float getTolDonatedAmountByTaskId(int taskid){
		Object[] objects = new Object[1];
		objects[0] = taskid;
		float total = new DoneeDaoImpl().getTolDonatedAmountByTaskId(objects);
		return total;
	}
	/**
	 * 插入一条受捐者记录
	 */
	public static boolean insert(Donee donee){
		Object[] objects=new Object[]{donee.getIdentity(),donee.getName(),donee.getGender(),donee.getFilePath(),donee.getPhone(),
				donee.getAddress(),donee.getBank(),donee.getTaskID(),donee.getReleaseTime(),donee.getExpectedamount(),
				donee.getExperience()};
		return new DoneeDaoImpl().insert(objects);
	}
}
