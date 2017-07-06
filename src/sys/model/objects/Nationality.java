package sys.model.objects;

/**
 * 国籍类
 * @author 王珂
 */
public class Nationality {
	
	public int getNationID() {
		return nationID;
	}
	public void setNationID(int nationID) {
		this.nationID = nationID;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	private int nationID;
	private String nation;
	public Nationality(int nationID, String nation) {
		//super();
		this.nationID = nationID;
		this.nation = nation;
	} 
	

}
