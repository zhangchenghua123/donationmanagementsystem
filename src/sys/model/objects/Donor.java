package sys.model.objects;

import java.util.Date;

/**
 * 捐助者类
 * @author 王珂
 */
public class Donor {

	public int getNationID() {
		return nationID;
	}
	public void setNationID(int nationID) {
		this.nationID = nationID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public float getTolMoney() {
		return tolMoney;
	}
	public void setTolMoney(float tolMoney) {
		this.tolMoney = tolMoney;
	}
	private int nationID;
	private String account;
	private String password;
	private String name;
	private String mailbox;
	private float tolMoney;
	public Donor(int nationID, String account, String password, String name, String mailbox, float tolMoney) {
		//super();
		this.nationID = nationID;
		this.account = account;
		this.password = password;
		this.name = name;
		this.mailbox = mailbox;
		this.tolMoney = tolMoney;
	}
}
