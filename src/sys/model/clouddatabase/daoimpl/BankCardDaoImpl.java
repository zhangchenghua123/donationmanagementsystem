package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.BankCardDao;
import sys.model.objects.Donation;
import sys.model.objects.PlatformBankCard;

/**
 * 
 * @author 张成华
 *
 */
public class BankCardDaoImpl implements BankCardDao {

	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public BankCardDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	@Override
	public PlatformBankCard query() {
		PlatformBankCard card=null;
		try {
			pstmt=conn.prepareStatement("select * from platformbankcard");
			rs=pstmt.executeQuery();
			if(rs.next()){
				card=new PlatformBankCard();
				card.setCardNo(rs.getString(1));
				card.setBalance(rs.getFloat(2));
				card.setTolDonation(rs.getFloat(3));
			}
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return card;
	}
	@Override
	public boolean updateBalance(Object[] objects) {
		int row=0;
		try {
			pstmt=conn.prepareStatement("update platformbankcard set balance=?");
			pstmt.setFloat(1, (float) objects[0]);
			row=pstmt.executeUpdate();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row==0)
			return false;
		else {
			return true;
		}
	}

	@Override
	public boolean updateTolDonation(Object[] objects) {
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
		int row=0;
		try {
			pstmt=conn.prepareStatement("update platformbankcard set toldonation= toldonation + ?");
			pstmt.setFloat(1, (float) objects[0]);
			row=pstmt.executeUpdate();
			rs.close();
			pstmt.close();
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
