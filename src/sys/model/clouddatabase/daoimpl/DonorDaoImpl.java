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
		
		String sql = "select * from donor where account=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) objects[0]);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean mailboxExisted(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "select * from donor where mailbox=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) objects[0]);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Object[] objects) {
		
		String sql = "Insert into donor Values(?,?,?,?,?,?)";//生成SQL语句
			
		try {
		//给？赋值
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, (String) objects[0]);
		pstmt.setString(2, (String) objects[1]);
		pstmt.setInt(3, (int) objects[2]);
		pstmt.setString(4, (String) objects[3]);
		pstmt.setString(5, (String) objects[4]);
		pstmt.setFloat(6, 0);
				int i=pstmt.executeUpdate();
					pstmt.close();
					databaseConnection.closeConnection();
					if(i==1)
					return true;
					else
						return false;
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//执行SQL语句
		return false;
	
	}
	

	@Override
	public boolean updatePassword(Object[] objects) {
		// TODO Auto-generated method stub
		String sql="update donor set password=? where account=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) objects[1]);
			pstmt.setString(2, (String) objects[0]);
			int i=pstmt.executeUpdate();
			if(i==1)
				return true;
			else
				return false;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateTolMoney(Object[] objects) {
		// TODO Auto-generated method stub
		String sql="update donor set tolmoney=? where account=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[1]);
			pstmt.setString(2, (String) objects[0]);
			int i=pstmt.executeUpdate();
			if(i==1)
				return true;
			else
				return false;
				
		} catch (SQLException e) {                                                                                                               
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Donor query(Object[] objects) {
		// TODO Auto-generated method stub
		
		  try{
		 
			pstmt=conn.prepareStatement("select * "
										+ "from donor natural join nationality"
										+ " where account =? and password=?");
			pstmt.setString(1, (String) objects[0]);
			pstmt.setString(2, (String) objects[1]);
			rs=pstmt.executeQuery();
			if(rs.next()){
					Donor don=new Donor();
					don.setAccount(rs.getString(2));
					don.setPassword(rs.getString(3));
					don.setNationID(rs.getInt(1));
					don.setName(rs.getString(4));
					don.setMailbox(rs.getString(5));
					don.setTolMoney(rs.getFloat(6));
					don.setNation(rs.getString(7));
					
					rs.close();
					pstmt.close();
					databaseConnection.closeConnection();
					return don;
	        }
			//return ;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try {
			pstmt=conn.prepareStatement("select count(*) from donor");
			rs=pstmt.executeQuery();
			int count=-1;
			if(rs.next()){
				count=rs.getInt(1);
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return 0;
	}



}