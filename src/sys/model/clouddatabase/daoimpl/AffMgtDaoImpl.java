package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//事例管理员表的操作
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
		// 判断事例管理员账号是否存在
		boolean b=false;
		try {
			//预编译SQL语句
			pstmt=conn.prepareStatement("select * from affairManager where account=?");
			//给？赋值
			pstmt.setString(1, (String) objects[0]);
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	@Override
	public boolean insert(Object[] objects) {
		// TODO Auto-generated method stub
		try {
			pstmt=conn.prepareStatement("insert into affairManager values(?,?,?,?)");
			//给？赋值
			for(int i=0;i<objects.length-1;i++)
				pstmt.setString(i+1, (String) objects[i]);
			pstmt.setInt(4, (int) objects[3]);
			//执行SQL语句
			int i=pstmt.executeUpdate();
			if(i>0){
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}

	
	@Override
	public AffairManager query(Object[] objects) {
		// 登陆时验证事例管理员
		try{
			pstmt=conn.prepareStatement("select * "
										+ "from affairManager natural join task"
										+ "where account =?");
			pstmt.setString(1, (String) objects[0]);
			rs=pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
			if(rs.next()){
					AffairManager affMg=new AffairManager();
					affMg.setAccount(rs.getString(1));
					affMg.setName(rs.getString(2));
					affMg.setPassword(rs.getString(3));
					affMg.setTaskId(rs.getInt(4));
					affMg.setTask(rs.getString(5));
					rs.close();
					pstmt.close();
					databaseConnection.closeConnection();
					return affMg;
	        }
			//return ;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePassword(Object[] objects) {
		//更新事例管理员密码
		try{
			pstmt=conn.prepareStatement("update affairManager set password=? where account=?");
			pstmt.setString(1, (String)objects[1]);
			pstmt.setString(2, (String)objects[0]);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<AffairManager> queryAll() {
		// 列出所有事例管理员
		ArrayList<AffairManager> list=new ArrayList<AffairManager>();
		try{
			pstmt=conn.prepareStatement("select * "
										+ "from affairManager natural join task");
			rs=pstmt.executeQuery();
	        //int col = rs.getMetaData().getColumnCount();
			while(rs.next()){
				AffairManager affMg=new AffairManager();
				affMg.setAccount(rs.getString(1));
				affMg.setName(rs.getString(2));
				affMg.setTask(rs.getString(5));
	           list.add(affMg);
	        }
			rs.close();
			pstmt.close();
			databaseConnection.closeConnection();
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
