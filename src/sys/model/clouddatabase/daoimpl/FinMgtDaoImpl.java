package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.FinMgtDao;
import sys.model.objects.FinancialManager;
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
				try{
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						String account = rs.getString("account");
					    String name = rs.getString("name");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
	}

	@Override
	public boolean updatePassword(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update financialManager set password=?";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, (String)objects[2]);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
