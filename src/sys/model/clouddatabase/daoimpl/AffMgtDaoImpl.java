package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sys.model.clouddatabase.DatabaseConnection;
import sys.model.clouddatabase.dao.AffMgtDao;
import sys.model.objects.AffairManager;
/**
 * 
 * @author 邓光亮
 * 
 *
 */
public class AffMgtDaoImpl implements AffMgtDao {
	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public AffMgtDaoImpl(){
		databaseConnection=new DatabaseConnection();
		conn=databaseConnection.getConnection();
	}
	
	@Override
	public boolean accountAlreadyExisted(Object[] objects) {
		// TODO Auto-generated method stub
		boolean b=false;
		try {
			//预编译SQL语句
			pstmt=conn.prepareStatement("select * from donee where account=?");
			//给？赋值
			for(int i=0;i<objects.length;i++)
				pstmt.setString(i+1, (String) objects[i]);
			//执行SQL语句
			rs=pstmt.executeQuery();
			//判断返回结果是否有数据
			if(rs.next())
				b=true;
			else
				b=false;
			//释放资源
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
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	
	@Override
	public AffairManager query(Object[] objects) {
		// TODO Auto-generated method stub
		String str="";
		try{
			pstmt=conn.prepareStatement("select * from affairManager where account =?");
			pstmt.setString(1, (String) objects[0]);
			rs=pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
			if(rs.next()){
	            for (int i = 1; i <= col; i++) {
	                //System.out.print(rs.getString(i) + "\t");
	                str=str+rs.getString(i)+"\t";
	            }
	            str=str+"\n";
	        }
		}catch(Exception e){
			
		}
		return null;
	}

	@Override
	public boolean updatePassword(Object[] objects) {
		// TODO Auto-generated method stub
		try{
			pstmt=conn.prepareStatement("update affairManager set password=? where account=?");
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public ArrayList<AffairManager> queryAll() {
		// TODO Auto-generated method stub[
		ArrayList list=new ArrayList();
		try{
			pstmt=conn.prepareStatement("select * from affairManager ");
			rs=pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        String str=" ";
			while(rs.next()){
	            for (int i = 1; i <= col; i++) {
	                //System.out.print(rs.getString(i) + "\t");
	                str=str+rs.getString(i)+"\t";
	            }
	           list.add(str);
	        }
			return list;
		}catch(Exception e){
			
		}
		return null;
	}

}
