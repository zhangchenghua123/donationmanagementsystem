package sys.presenter;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

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
		return -1;
	}

	/**
	 * 1
	 * 获取所有受助者信息
	 * 
	 * @return
	 */
	public static ArrayList<Donee> getAll() {
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
		return false;
	}
	/**
	 * 2
	 * @param identity
	 * @param increase
	 * @return
	 */
	public static boolean updateReceivedAmount(String identity, float increase) {
		return false;
	}
	/**
	 * 2
	 * @param identity
	 * @return
	 */
	public static boolean updateContinue(String identity) {
		return false;
	}
	/**
	 * 2
	 * @param identity
	 * @return
	 */
	public static boolean updateFinish(String identity) {
		return false;
	}
}
