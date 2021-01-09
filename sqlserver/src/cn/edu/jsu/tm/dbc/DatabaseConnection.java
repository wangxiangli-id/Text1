package cn.edu.jsu.tm.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//定义sql驱动
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//定义sqlserver数据库连接地址
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
	private static final String DBUSER="sa"; //SQLServer数据库连接用户名
	private static final String PASSWORD="123456789"; //SQLServer数据库连接密码
	private Connection conn=null; //保存连接对象
	public DatabaseConnection(){//构造方法连接数据库
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
