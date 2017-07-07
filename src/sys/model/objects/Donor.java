package sys.model.objects;

import java.util.Date;

/**
 * 捐助者类
 * @author 王珂
 */
public class Donor {

	private int nationID;
	private String nation;
	private String account;
	private String password;
	private String name;
	private String mailbox;
	private float tolMoney;
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
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}

	
	
}
