package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.NationDao;
import sys.model.objects.Nationality;
/**
 * @author 顾伟宏
 */
public class NationDaoImpl implements NationDao {

	private DatabaseConnection databaseConnection = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public NationDaoImpl()
	{
		databaseConnection = new DatabaseConnection();
		conn = databaseConnection.getConnection();
	}
	
	@Override
	public ArrayList<Nationality> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from nationality";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Nationality> list = new ArrayList<Nationality>();
			while(rs.next())
			{
				list.add(new Nationality(rs.getInt(1), rs.getString(2)));
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}

	@Override
	public int getId(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "select nationID from nationality where nation=?";
		int ID = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, (int) objects[1]);
			rs = pstmt.executeQuery();
			ID = rs.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return ID;
	}

}
