package sys.presenter;

import sys.model.clouddatabase.daoimpl.BankCardDaoImpl;
import sys.model.objects.PlatformBankCard;

/**
 * 
 * @author 顾
 *
 */
public class BankCardPresenter {

	/**
	 * 2
	 * 获取平台银行卡所有信息
	 */
	public static PlatformBankCard getCard(){
		PlatformBankCard platformBankCard = new PlatformBankCard();
		platformBankCard.getCardNo();
		platformBankCard.getBalance();
		platformBankCard.getTolDonation();
			return platformBankCard;
	}
	/**
	 * 2
	 * 更新余额，newBalance是更新后的余额，不是添加的。
	 */
	public static boolean updateBalance(float newBalance){
		Object[] objects = new Object[1];
		objects[0] = newBalance;
		boolean isSuccess = new BankCardDaoImpl().updateBalance(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	/**
	 * 2
	 * 添加捐助总额，这个是要增加的捐助额。
	 */
	public static boolean addTolDanotion(float donation){
		Object[] objects = new Object[1];
		objects[0] = donation;
		boolean isSuccess = new BankCardDaoImpl().updateTolDonation(objects);
		if(isSuccess)
			return true;
		else
			return false;
	}
	
}
