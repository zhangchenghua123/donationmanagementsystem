package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.DoneeDao;
import sys.model.objects.Donee;

public class DoneeDaoImpl implements DoneeDao {

	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	
	public DoneeDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	
	/**
	 * @author 王靖凯
	 */
	
	@Override
	public boolean identityExisted(Object[] objects) {
		// TODO Auto-generated method stub
		boolean b=false;
		try {
			
			//预编译SQL语句
			pstmt=conn.prepareStatement("select * from donee where identity=?");
			//给问号赋值
			for(int i=0;i<objects.length;i++)
				pstmt.setString(i+1, (String) objects[i]);
			//执行SQL语句，返回查询结果给rs
			rs=pstmt.executeQuery();
			//判断rs是否有数据
			
			if(rs.next())
				b=true;
			else
				b=false;
			
			//逆序关闭连接和释放空间
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return b;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public boolean phoneExisted(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cardExisted(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Donee query(Object[] objects) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 *@author  顾伟宏
	 * 
	 * 
	 */
	
	
	
	@Override
	public ArrayList<Donee> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from donee";
		try{
			pstmt = conn.prepareStatement( sql );
			rs = pstmt.executeQuery();
			ArrayList<Donee> list = new ArrayList<Donee>();
			while(rs.next())
			{
				list.add(new Donee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getDate(9), rs.getFloat(10),rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getInt(14), rs.getInt(15)));
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
	}

	@Override
	public boolean updateDonateAmount(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update donee set donatedamount = ? where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[0]);
			pstmt.setString(2, Donee.getIdentity());
			i = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
	}
		if(i == 0)
		return false;
		else
			return true;
	}

	@Override
	public boolean updateReceivedAmount(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update donee set receivedamount = receivedamount + ? where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[0]);
			pstmt.setString(2, Donee.getIdentity());
			i = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
	}
		if( i == 0 )
		return false;
		else
			return true;
	}

	@Override
	public boolean updateContinue() {
		// TODO Auto-generated method stub
		String sql = "update donee set continue = ? where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Donee.getIsContinue());
			pstmt.setString(2, Donee.getIdentity());
			i = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
	}
		if( i == 0 )
		return false;
		else
			return true;
	}

	
	@Override
	public boolean updateFinish() {
		// TODO Auto-generated method stub
		String sql = "update donee set finish = ? where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Donee.getFinish());
			pstmt.setString(2, Donee.getIdentity());
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
