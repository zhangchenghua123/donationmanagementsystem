package sys.model.objects;

import java.util.Date;

/**
 * 公告类
 * 属性：时间，标题，内容
 * @author 凯
 *
 */
public class Announcement {
	private Date time;
	private String title;
	private String content;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
