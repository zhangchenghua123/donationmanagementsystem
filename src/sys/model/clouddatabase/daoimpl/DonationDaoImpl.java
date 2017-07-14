package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.objects.AffairManager;
import sys.model.objects.Donation;

/**
 * 
 * @author 王珂
 */
public class DonationDaoImpl implements sys.model.clouddatabase.dao.DonationDao {

	private DatabaseConnection databaseConnection = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public DonationDaoImpl() {
		databaseConnection = new DatabaseConnection();
		conn = databaseConnection.getConnection();
	}

	@Override
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub
		String sql = "Insert into donation Values(?,?,?,?,?)";// 生成SQL语句

		try {
			// 给？赋值
			pstmt = conn.prepareStatement(sql);

			pstmt.setTimestamp(1, new Timestamp(((Date) objects[0]).getTime()));
			pstmt.setString(2, (String) objects[1]);
			pstmt.setString(3, (String) objects[2]);
			pstmt.setFloat(4, (float) objects[3]);
			pstmt.setInt(5, (int) objects[4]);

			int i = pstmt.executeUpdate();
			pstmt.close();
			databaseConnection.closeConnection();
			if (i == 1)
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
	public boolean updateState(ArrayList<Donation> list) {
		// TODO Auto-generated method stub
		Object[] objects=new Object[3];
		String sql = "update donation set paid=? where time=?" + " and donoraccount=? " + " and doneeidentity=?";
		try {
			pstmt = conn.prepareStatement(sql);

			for(Donation object : list){ 
				pstmt.setInt(1, 1); 
				pstmt.setTimestamp(2,new Timestamp(((Date) objects[0]).getTime())); 
				pstmt.setString(3, object.getDonorAccount()); 
				pstmt.setString(4, object.getDoneeIdentity()); 
				pstmt.addBatch(); 
			} 
			
			int i = pstmt.executeUpdate();
			pstmt.close();
			databaseConnection.closeConnection();
			if (i == 1)
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
	public ArrayList<Donation> getDonationsByDonor(Object[] objects) {
		// TODO Auto-generated method stub
		ArrayList<Donation> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select time,account,donor.name,identity,donee.name,amount,paid "
					+ "from donation,donor,donee "
					+ "where donation.donoraccount=? and donation.donoraccount=donor.account and donation.doneeidentity=donee.identity");
			pstmt.setString(1, (String) objects[0]);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setTime(new Date(rs.getTimestamp(1).getTime()));
				donation.setDonorAccount(rs.getString(2));
				donation.setDonorName(rs.getString(3));
				donation.setDoneeIdentity(rs.getString(4));
				donation.setDoneeName(rs.getString(5));
				donation.setAmount(rs.getFloat(6));
				donation.setHasPaid(rs.getInt(7) == 0 ? "否" : "是");
				list.add(donation);
			}
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Donation> getDonationByDonee(Object[] objects) {
		// TODO Auto-generated method stub
		try {
			pstmt = conn.prepareStatement("select time,account,donor.name,identity,donee.name,amount,paid "
							+ "from donation ,donor,donee" 
							+ " where account =donoraccount "
							+ "and identity=doneeidentity "
							+ "and identity=?");
			pstmt.setString(1, (String) objects[0]);
			rs = pstmt.executeQuery();
			ArrayList<Donation> list=new ArrayList<>();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setTime(new Date(rs.getTimestamp(1).getTime()));
				donation.setDonorAccount(rs.getString(2));
				donation.setDonorName(rs.getString(3));
				donation.setDoneeIdentity(rs.getString(4));
				donation.setDoneeName(rs.getString(5));
				donation.setAmount(rs.getFloat(6));
				donation.setHasPaid(rs.getInt(7) == 0 ? "否" : "是");
				list.add(donation);
			}
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Donation> getAll() {
		// TODO Auto-generated method stub
		try {
			pstmt = conn.prepareStatement("select time,account,donor.name,identity,donee.name,amount,paid "
							+ "from donation ,donor,donee" 
							+ " where account =donoraccount "
							+ "and identity=doneeidentity "
							+ "order by time");
			rs = pstmt.executeQuery();
			ArrayList<Donation> list=new ArrayList<>();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setTime(new Date(rs.getTimestamp(1).getTime()));
				donation.setDonorAccount(rs.getString(2));
				donation.setDonorName(rs.getString(3));
				donation.setDoneeIdentity(rs.getString(4));
				donation.setDoneeName(rs.getString(5));
				donation.setAmount(rs.getFloat(6));
				donation.setHasPaid(rs.getInt(7) == 0 ? "否" : "是");
				list.add(donation);
			}
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			// return ;
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try {
			pstmt=conn.prepareStatement("select count(*) from donation");
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

	@Override
	public ArrayList<Donation> getAllNotPaid() {
		// TODO Auto-generated method stub
		try {
			pstmt = conn.prepareStatement("select time,account,donor.name,identity,donee.name,amount,paid "
							+ "from donation ,donor,donee" 
							+ " where account = donoraccount "
							+ "and identity = doneeidentity "
							+ "and paid = 0 ");
			rs = pstmt.executeQuery();
			ArrayList<Donation> list=new ArrayList<>();
			while (rs.next()) {
				Donation donation = new Donation();
				donation.setTime(new Date(rs.getTimestamp(1).getTime()));
				donation.setDonorAccount(rs.getString(2));
				donation.setDonorName(rs.getString(3));
				donation.setDoneeIdentity(rs.getString(4));
				donation.setDoneeName(rs.getString(5));
				donation.setAmount(rs.getFloat(6));
				donation.setHasPaid(rs.getInt(7) == 0 ? "否" : "是");
				list.add(donation);
			}
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			// return ;
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
