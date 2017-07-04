package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		return null;
	}

	@Override
	public boolean updateDonateAmount(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReceivedAmount(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContinue() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean updateFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
