package sys.model.clouddatabase.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sys.model.clouddatabase.DatabaseConnection;

/**
 * @author 邓光亮
 */
public class TaskDaoImpl implements sys.model.clouddatabase.dao.TaskDao {
	private DatabaseConnection databaseConnection=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	@Override
	public boolean nameExisted(Object[] objects) {
		// 检查任务名是否重复
		try {
			//预编译SQL语句
			pstmt=conn.prepareStatement("select * from task where task=?");
			//给？赋值
			pstmt.setString(1, (String) objects[0]);
			//执行SQL语句
			rs=pstmt.executeQuery();
			//判断返回结果是否有数据
			if(rs.next())
				//释放资源
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean insert(Object[] objects) {
		// 插入一个任务
		try {
			pstmt=conn.prepareStatement("insert into task values(NULL,?)");
			//给？赋值
			pstmt.setString(1, (String) objects[0]);
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
	public int getId(Object[] objects) {
		// 返回一个任务名对应的ID
		try {
			pstmt=conn.prepareStatement("select taskID from task where task=?");
			//给？赋值
			pstmt.setString(1, (String) objects[0]);
			//执行SQL语句
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int ID=Integer.parseInt(rs.getString(1));
				rs.close();
				pstmt.close();
				databaseConnection.closeConnection();
				return ID;
			}
					
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return 0;
		
	}

}
