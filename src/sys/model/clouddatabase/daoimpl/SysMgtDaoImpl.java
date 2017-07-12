package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.SysMgtDao;
import sys.model.objects.PlatformBankCard;

/**
 * @author 张成华
 */
public class SysMgtDaoImpl implements SysMgtDao {

	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public SysMgtDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	
	@Override
	public String query(Object[] objects) {
		
		String name=null;
		try {
			pstmt=conn.prepareStatement("select * from systemmanager where account=? and password=?");
			pstmt.setString(1, (String) objects[0]);
			pstmt.setString(2, (String) objects[1]);
			rs=pstmt.executeQuery();
			if(rs.next()){
				name=rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	
	@Override
	public boolean updatePassword(Object[] objects) {
		int row=0;
		try {
			pstmt=conn.prepareStatement("update systemmanager set password=?");
			pstmt.setString(1, (String) objects[0]);
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row==0)
			return false;
		else {
			return true;
		}
	}

}
