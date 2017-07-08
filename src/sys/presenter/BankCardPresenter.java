package sys.presenter;

import sys.model.objects.PlatformBankCard;

/**
 * 
 * @author 顾
 *
 */
public class BankCardPresenter {

	/**
	 * 获取平台银行卡所有信息
	 */
	public PlatformBankCard getCard(){
		return null;
	}
	/**
	 * 更新余额，newBalance是更新后的余额，不是添加的。
	 */
	public boolean updateBalance(float newBalance){
		return false;
	}
	/**
	 * 添加捐助总额，这个是要增加的捐助额。
	 */
	public boolean addTolDanotion(float donation){
		return false;
	}
	
}
