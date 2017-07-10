package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.AnmtDao;
import sys.model.objects.AffairManager;
import sys.model.objects.Announcement;

/**
 * @author 王靖凯
 */
public class AnmtDaoImpl implements AnmtDao {
	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public AnmtDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	
	@Override
	public boolean insert(Object[] objects) {
		// 插入一个公告
		try{
			pstmt=conn.prepareStatement("insert into announcement values(?,?,?)");
			pstmt.setDate(1,(Date)objects[0]);
			pstmt.setString(2, (String) objects[1]);
			pstmt.setString(3,(String) objects[2]);
			int i=pstmt.executeUpdate();
			if(i>0){
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Announcement> queryAll() {
		// 获取所有公告
		ArrayList<Announcement> list=new ArrayList<Announcement>();
		try{
			pstmt=conn.prepareStatement("select * "
										+ "from announcement");
			rs=pstmt.executeQuery();
			while(rs.next()){
				Announcement ann=new Announcement();
				ann.setTime(rs.getDate(1));
				ann.setTitle(rs.getString(2));
				ann.setContent(rs.getString(3));
	            list.add(ann);
	        }
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
