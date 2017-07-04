package sys.model.clouddatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	//添加一行
	//添加第二行
	private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动
	private static String url = "jdbc:mysql://111.231.10.78:3306/danotionmgtsys";// 数据库地址
	private static String user = "root";// 账号
	private static String password = "276951438#zch";// 密码
	
	public Connection conn = null;// 与数据库进行的一次回话连接

	public DatabaseConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (!conn.isClosed()) {
				System.out.println("连接数据库成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
