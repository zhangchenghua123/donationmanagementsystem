package sys.presenter;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import sys.model.objects.Donee;

public class DoneePresenter {

	public static int IDENTITY_EXISTED = 0;
	public static int PHONE_EXISTED = 1;
	public static int CARD_EXISTED = 2;

	/**
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
	 * 获取所有受助者简要信息，包括姓名，性别，图片，地址，期望金额，经历，已募捐金额
	 * 
	 * @return
	 */
	public static ArrayList<Donee> getAll() {
		return null;
	}

	/**
	 * 根据身份证获取详细信息
	 * 
	 * @param identity
	 * @return
	 */
	public static Donee getDonee(String identity) {
		return null;
	}

	public static boolean updateDonateAmount(String identity, float increase) {
		return false;
	}

	public static boolean updateReceivedAmount(String identity, float increase) {
		return false;
	}

	public static boolean updateContinue() {
		return false;
	}

	public static boolean updateFinish() {
		return false;
	}
}
