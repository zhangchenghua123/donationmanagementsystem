package sys.model.objects;

import java.sql.Date;

/**
 * 受捐者类
 * 属性：身份证号，姓名，性别，图片，电话，地址，银行卡号，任务名称，发布时间，期望金额，经历，已募捐金额，已收到金额，是否继续，是否已结束
 * @author 凯
 */
public class Donee {

	private static String identity;
	private static String name;
	private String gender;
	private byte[] bytes;
	private String phone;
	private String address;
	private String bank;
	private int taskID;
	private Date releaseTime;
	private float expectedamount;
	private String experience;
	private float donatedamount;
	private float receivedamount;
	private static int isContinue;
	private static int finish;
	
	
	public Donee(String identity, String name, String gender, byte[] bytes, String phone, String address, String bank,
			int taskID, Date releaseTime, float expectedamount, String experience, float donatedamount,
			float receivedamount, int isContinue, int finish) {
		this.identity = identity;
		this.name = name;
		this.gender = gender;
		this.bytes = bytes;
		this.phone = phone;
		this.address = address;
		this.bank = bank;
		this.taskID = taskID;
		this.releaseTime = releaseTime;
		this.expectedamount = expectedamount;
		this.experience = experience;
		this.donatedamount = donatedamount;
		this.receivedamount = receivedamount;
		this.isContinue = isContinue;
		this.finish = finish;
	}
	public static String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public float getExpectedamount() {
		return expectedamount;
	}
	public void setExpectedamount(float expectedamount) {
		this.expectedamount = expectedamount;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public float getDonatedamount() {
		return donatedamount;
	}
	public void setDonatedamount(float donatedamount) {
		this.donatedamount = donatedamount;
	}
	public float getReceivedamount() {
		return receivedamount;
	}
	public void setReceivedamount(float receivedamount) {
		this.receivedamount = receivedamount;
	}
	public static int getIsContinue() {
		return isContinue;
	}
	public void setIsContinue(int isContinue) {
		this.isContinue = isContinue;
	}
	public static int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
}
