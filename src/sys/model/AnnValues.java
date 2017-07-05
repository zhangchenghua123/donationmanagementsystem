package sys.model;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import sys.model.objects.Announcement;

/**
 * 公告数据与table之间的桥梁
 * 
 * @author Berry
 * 
 */
public class AnnValues {

	public ArrayList<Ann> allAnnouncements;
	public int currentPage=0;
	public int maxPage;
	public AnnValues(){
		allAnnouncements=new ArrayList<Ann>();
		for(int i=0;i<8;i++){
			Ann announcement=new Ann();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			announcement.setTime(new Date());
			announcement.setTitle("这是标题"+i+"hhhhhhhhhhhhhhhhh");
			announcement.setContent("\t人都说，爱上一座城，是因为城中住着你爱的人。爱屋及乌自是不言而喻，每个人的生命中都会出现这样一个人，纵使尘满面，鬓如霜，也想要和他相伴到岁末晚景。我深信此画面曾被无数人精心描摹过，因为它是人们心里憧憬的最美的爱相逢。这个浪漫的“版图”，也是温暖与真挚包裹的纯粹感情，所刻画的一幅朴素人生。" +
					"\t世间最理想的爱情，当然是两颗同心，一生相濡以沫。擦肩而过，只能说彼此情深缘浅。放手成全，可能给人感觉言过凄美，听着有些颇为冷情，可谁也不能否认这不是因为爱情。" +
					"\t爱情是什么？我只能说是一种忘我的感觉，一种怡然心扉的情愫，它体现着爱情的完美纯度。 “遇一人白首，择一城终老”，人人心期遇见这样的尘缘，从此守候这种温暖。可生活并非是你以为的那么顺然，爱情也有难违的宿命。" +
					"");
			allAnnouncements.add(announcement);
		}
		maxPage=allAnnouncements.size();
	}
	public int getColumnCount() {
		return 1;
	}

	public int getRowCountOfCurrentPage() {
		return (allAnnouncements.size()-currentPage*5)>=5?5:(allAnnouncements.size()-currentPage*5);
	}

	public String getValueAt(int rowIndex) {
		
		return 	allAnnouncements.get(currentPage*5+rowIndex).getTitle();
		
	}
	public void nextPage(){
		currentPage++;
	}

	
	public static class Ann{
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
}
