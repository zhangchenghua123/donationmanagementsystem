package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.DonorDao;
import sys.model.objects.Donor;

/**
 * @author 王珂
 */
public class DonorDaoImpl implements DonorDao {
	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public DonorDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}

	@Override
	public boolean accountExisted(Object[] objects) {
		
		String sql = "select * from donor";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String account = rs.getString("account");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean mailboxExisted(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "select * from donor";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String account = rs.getString("mailbox");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub

		  try{		String sql = "select * from donor";//生成SQL语句
		ResultSet rs = pstmt.executeQuery(sql);//获取数据表结果集
		if(rs.next()){
		  rs.updateString(2,(String) objects[0]);
			  rs.updateRow();
			  }
		}catch(Exception e){e.printStackTrace();}
		  
		return false;
	}

	@Override
	public boolean updatePassword(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTolMoney(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Donor query(Object[] objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
