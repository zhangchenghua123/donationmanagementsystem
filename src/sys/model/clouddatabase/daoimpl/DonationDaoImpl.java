package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.objects.Donation;

/**
 * 
 * @author 王珂
 */
public class DonationDaoImpl implements sys.model.clouddatabase.dao.DonationDao {

	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public DonationDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	
	
	@Override
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public ArrayList<Donation> getDonationsByDonor(Object[] objects) {
		// TODO Auto-generated method stub
		ArrayList<Donation> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement("select time,account,donor.name,identity,donee.name,amount,paid " +
										"from donation,donor,donee " +
										"where donation.donoraccount=? and donation.donoraccount=donor.account and donation.doneeidentity=donee.identity");
			pstmt.setString(1, (String) objects[0]);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Donation donation=new Donation();
				donation.setTime(rs.getDate(1));
				donation.setDonorAccount(rs.getString(2));
				donation.setDonorName(rs.getString(3));
				donation.setDoneeIdentity(rs.getString(4));
				donation.setDoneeName(rs.getString(5));
				donation.setAmount(rs.getFloat(6));
				donation.setHasPaid(rs.getInt(7)==0?"否":"是");
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
		return null;
	}


	@Override
	public boolean updateState(Object[] objects) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<Donation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
