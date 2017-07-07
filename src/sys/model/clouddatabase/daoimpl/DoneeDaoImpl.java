package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

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
			pstmt=conn.prepareStatement("select identity from donee where identity=?");
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
				Donee donee=new Donee();
				donee.setIdentity(rs.getString(1));
				donee.setName(rs.getString(2));
				donee.setGender(rs.getString(3));
				donee.setAge(Calendar.getInstance().get(Calendar.YEAR)-Integer.getInteger(donee.getIdentity().substring(6, 10)));
				
				ByteArrayOutputStream outputStream=null;
				InputStream is = rs.getBinaryStream(4);
				outputStream = new ByteArrayOutputStream();
				int b = 0;
				try {
					while ((b = is.read()) != -1) {
						outputStream.write(b);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				donee.setPic(new ImageIcon(outputStream.toByteArray()));
				donee.setPhone(rs.getString(5));
				donee.setAddress(rs.getString(6));
				donee.setBank(rs.getString(7));
				donee.setTaskID(rs.getInt(8));
				donee.setReleaseTime(rs.getDate(9));
				donee.setExpectedamount(rs.getFloat(10));
				donee.setExperience(rs.getString(11));
				donee.setDonatedamount(rs.getFloat(12));
				donee.setReceivedamount(rs.getFloat(13));
				donee.setIsContinue(rs.getInt(14));
				donee.setFinish(rs.getInt(15));
				
				list.add(donee);
				
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
		String sql = "update donee set donatedamount = donatedamount + ? where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[1]);
			pstmt.setString(2, (String) objects[0]);
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
			pstmt.setFloat(1, (float) objects[1]);
			pstmt.setString(2, (String) objects[0]);
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
	public boolean updateContinue(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update donee set continue = 0 where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) objects[0]);
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
	public boolean updateFinish(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "update donee set finish = 1 where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,(String) objects[0]);
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
