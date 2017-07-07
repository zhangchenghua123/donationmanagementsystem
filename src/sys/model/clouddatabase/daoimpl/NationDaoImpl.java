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
				Nationality nationality=new Nationality();
				nationality.setNationID(rs.getInt(1));
				nationality.setNation(rs.getString(2));
				list.add(nationality);
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
			pstmt.setString(1, (String) objects[0]);
			rs = pstmt.executeQuery();
			ID = rs.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return ID;
	}

}