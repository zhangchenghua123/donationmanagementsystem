package sys.model.objects;

import java.sql.Date;

import javax.swing.Icon;

/**
 * 受捐者类
 * 属性：身份证号，姓名，性别，年龄，图片路径（添加受助者时从文件中选择）图片icon（获取受助者时从数据库二进制形成imageicon）
 * ，电话，地址，银行卡号，任务id，发布时间，期望金额，经历，已募捐金额，已收到金额，是否继续，是否已结束
 * @author 凯
 */
public class Donee {

	private  String identity;
	private  String name;
	private String gender;
	private int age;
	private String filePath;
	private Icon pic;
	private String phone;
	private String address;
	private String bank;
	private int taskID;
	private Date releaseTime;
	private float expectedamount;
	private String experience;
	private float donatedamount;
	private float receivedamount;
	private  int isContinue;
	private  int finish;
	
	
	
	public  String getIdentity() {
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Icon getPic() {
		return pic;
	}
	public void setPic(Icon pic) {
		this.pic = pic;
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
	public  int getIsContinue() {
		return isContinue;
	}
	public void setIsContinue(int isContinue) {
		this.isContinue = isContinue;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
}
