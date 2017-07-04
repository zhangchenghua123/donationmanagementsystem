package sys.model.objects;

import java.util.Date;

/**
 * 捐助类
 * 属性：时间，捐助者账号，捐助者姓名，受捐者身份证号，受捐者姓名，捐助金额，是否已打款，
 * 
 * @author 华
 *
 */
public class Donation {

	private Date time;
	private String donorAccount;
	private String donorName;
	private String doneeIdentity;
	private String doneeName;
	private float amount;
	private String hasPaid;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDonorAccount() {
		return donorAccount;
	}
	public void setDonorAccount(String donorAccount) {
		this.donorAccount = donorAccount;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDoneeIdentity() {
		return doneeIdentity;
	}
	public void setDoneeIdentity(String doneeIdentity) {
		this.doneeIdentity = doneeIdentity;
	}
	public String getDoneeName() {
		return doneeName;
	}
	public void setDoneeName(String doneeName) {
		this.doneeName = doneeName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getHasPaid() {
		return hasPaid;
	}
	public void setHasPaid(String hasPaid) {
		this.hasPaid = hasPaid;
	}
	
	
}
