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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.DoneeDao;
import sys.model.objects.Donation;
import sys.model.objects.Donee;
import sys.view.GetResourceClass;

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
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean phoneExisted(Object[] objects) {
		boolean b = false;
		try {
			// 预编译SQL语句
			pstmt = conn
					.prepareStatement("select phone from donee where phone=?");
			// 给问号赋值
			for (int i = 0; i < objects.length; i++)
				pstmt.setString(i + 1, (String) objects[i]);
			// 执行SQL语句，返回查询结果给rs
			rs = pstmt.executeQuery();
			// 判断rs是否有数据
			if (rs.next())
				b = true;
			else
				b = false;
			// 逆序关闭连接和释放空间
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean cardExisted(Object[] objects) {
		boolean b = false;
		try {
			// 预编译SQL语句
			pstmt = conn
					.prepareStatement("select bank from donee where bank=?");
			// 给问号赋值
			for (int i = 0; i < objects.length; i++)
				pstmt.setString(i + 1, (String) objects[i]);
			// 执行SQL语句，返回查询结果给rs
			rs = pstmt.executeQuery();
			// 判断rs是否有数据
			if (rs.next())
				b = true;
			else
				b = false;
			// 逆序关闭连接和释放空间
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Object[] objects) {
		FileInputStream str=null;
		try {
			String sql = "insert into donee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) objects[0]); // 身份证号号
			pstmt.setString(2, (String) objects[1]);
			pstmt.setString(3, (String) objects[2]);
			//将该路径下的图片转成输入流
			str = new FileInputStream((String) objects[3]);
			//将输入流添加进SQL语句
			pstmt.setBinaryStream(4, str, str.available()); // 图片数据
			
			pstmt.setString(5, (String) objects[4]);
			pstmt.setString(6, (String) objects[5]);
			pstmt.setString(7, (String) objects[6]);
			pstmt.setInt(8, (int) objects[7]);
			pstmt.setDate(9, (java.sql.Date) objects[8]);
			pstmt.setFloat(10, (float) objects[9]);
			pstmt.setString(11, (String) objects[10]);
			pstmt.setFloat(12, 0);
			pstmt.setFloat(13,0);
			pstmt.setInt(14, 1);
			pstmt.setInt(15, 0);
			if(pstmt.executeUpdate()==1){
				pstmt.close();
				databaseConnection.closeConnection();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	@Override
	public Donee query(Object[] objects) {
		Donee donee=null;
		try {
			//预编译SQL语句
			pstmt=conn.prepareStatement("select * from donee where identity=?");
			//给问号赋值
			pstmt.setString(1, (String) objects[0]);
			//执行SQL语句，返回查询结果给rs
			rs=pstmt.executeQuery();
			//判断rs是否有数据
			if(rs.next()){
				donee=new Donee();
				donee.setIdentity(rs.getString(1));
				donee.setName(rs.getString(2));
				donee.setGender(rs.getString(3));
				donee.setAge(Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(donee.getIdentity().substring(6, 10)));
				//从数据库查询结果读出二进制数据，转成输出流，生成图片
				ByteArrayOutputStream outputStream=null;
				InputStream is = rs.getBinaryStream(4);
				outputStream = new ByteArrayOutputStream();
				int b = 0;
				try {
					while ((b = is.read()) != -1) {
						outputStream.write(b);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				donee.setPic(new ImageIcon(outputStream.toByteArray()));
				GetResourceClass.icon= donee.getPic();
				donee.setPhone(rs.getString(5));
				donee.setAddress(rs.getString(6));
				donee.setBank(rs.getString(7));
				donee.setTaskID(rs.getInt(8));
				donee.setReleaseTime(rs.getDate(9));
				DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
				donee.setExpectedamount(rs.getFloat(10));
				donee.setExperience(rs.getString(11));
				donee.setDonatedamount(rs.getFloat(12));
				donee.setReceivedamount(rs.getFloat(13));
				donee.setIsContinue(rs.getInt(14));
				donee.setFinish(rs.getInt(15));
			}
			//逆序关闭连接和释放空间
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return donee;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getCount() {
		String sql = "select count(*) from donee";
		try{
			pstmt = conn.prepareStatement( sql );
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 *@author  顾伟宏
	 * 
	 * 
	 */
	@Override
	public ArrayList<Donee> getOnePage(int firstIndex) {
		String sql = "select * from donee limit "+firstIndex+",4";
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
				donee.setAge(Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(donee.getIdentity().substring(6, 10)));
				ByteArrayOutputStream outputStream=null;
				InputStream is = rs.getBinaryStream(4);
				outputStream = new ByteArrayOutputStream();
				int b = 0;
				try {
					while ((b = is.read()) != -1) {
						outputStream.write(b);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				donee.setPic(new ImageIcon(outputStream.toByteArray()));
				GetResourceClass.icon= donee.getPic();
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
		String sql = "update donee set continued = 0 where identity = ?";
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
	public boolean updateFinish(ArrayList<Donee> donees) {
		String sql = "update donee set finish = 1 where identity = ?";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			for(Donee s : donees)
			{
			    pstmt.setString(1,s.getIdentity());
			    pstmt.addBatch();
			}
			pstmt.executeBatch();
			pstmt.close();
			databaseConnection.closeConnection();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}
	@Override
	public ArrayList<Donee> getDoneeByCondition(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "select identity,name,gender,phone,address,bank,releasetime,expectedamount,donatedamount,receivedamount,continued,finish from donee ";
		try {
			if (((String) objects[1]).equals("continue")) {
				sql = sql + " where taskid=? and continued = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (int) objects[0]);
			}
			else if (((String) objects[1]).equals("stop")){
				sql = sql + " where taskid=? and continued = 0 and finish = 0";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (int) objects[0]);
			}
			else if (((String) objects[1]).equals("finish")){
				sql = sql + " where taskid=? and finish = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (int) objects[0]);
			}
			else if (((String) objects[1]).equals("canfinish")){
				sql = sql
						+ " where finish = 0 and (receivedamount>=expectedamount or donatedamount<expectedamount and continued = 0)";
				pstmt = conn.prepareStatement(sql);
			}
			rs = pstmt.executeQuery();
			ArrayList<Donee> list = new ArrayList<Donee>();
			while (rs.next()) {
				Donee donee = new Donee();
				donee.setIdentity(rs.getString(1));
				donee.setName(rs.getString(2));
				donee.setGender(rs.getString(3));
				donee.setAge(Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(donee.getIdentity().substring(6, 10)));
				donee.setPhone(rs.getString(4));
				donee.setAddress(rs.getString(5));
				donee.setBank(rs.getString(6));
				donee.setTaskID((int) objects[0]);
				donee.setReleaseTime(rs.getDate(7));
				donee.setExpectedamount(rs.getFloat(8));
				donee.setDonatedamount(rs.getFloat(9));
				donee.setReceivedamount(rs.getFloat(10));
				donee.setIsContinue(rs.getInt(11));
				donee.setFinish(rs.getInt(12));
				list.add(donee);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getCountByTaskId(Object[] objects) {
		String sql = "select count(*) from donee where taskId = ?";
		int Count = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) objects[0]);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Count = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Count;
	}
	@Override
	public float getTolExpectedAmountByTaskId(Object[] objects) {
		String sql = "select sum(expectedamount) from donee where taskId = ?";
		float total = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[0]);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				total = rs.getFloat(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public float getTolDonatedAmountByTaskId(Object[] objects) {
		String sql = "select sum(donatedamount) from donee where taskId = ?";
		float total = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, (float) objects[0]);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getFloat(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
