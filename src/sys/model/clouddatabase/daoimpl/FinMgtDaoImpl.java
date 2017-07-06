package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.FinMgtDao;
/**
 * @author 顾伟宏
 */
public class FinMgtDaoImpl implements FinMgtDao {

	private DatabaseConnection databaseConnection = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public FinMgtDaoImpl()
	{
		databaseConnection = new DatabaseConnection();
		conn = databaseConnection.getConnection();
	}
	
	@Override
	public String query(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "select * from financialManager";
		String name = null;
				try{
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						//String account = rs.getString("account");
					     name = rs.getString("name");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
		return name;
	}

	@Override
	public boolean updatePassword(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update financialManager set password = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)objects[0]);
			i = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(i == 0)
		    return false;
		else
			return true;
	}

}