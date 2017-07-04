package sys.model.objects;

/**
 * 平台银行卡类
 * 属性：卡号，余额，总的捐助金额
 * @author 华
 */
public class PlatformBankCard {

	private String cardNo;
	private float balance;
	private float tolDonation;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getTolDonation() {
		return tolDonation;
	}
	public void setTolDonation(float tolDonation) {
		this.tolDonation = tolDonation;
	}
	
	
}
