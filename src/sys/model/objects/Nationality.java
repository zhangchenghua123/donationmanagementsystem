package sys.model.objects;

/**
 * 国籍类
 * @author 王珂
 */
public class Nationality {
	
	private int nationID;
	public Nationality(int nationID, String nation) {
		this.nationID = nationID;
		this.nation = nation;
	}
	private String nation;
	
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
 

}
