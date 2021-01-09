package cn.edu.jsu.tm.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//����sql����
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//����sqlserver���ݿ����ӵ�ַ
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
	private static final String DBUSER="sa"; //SQLServer���ݿ������û���
	private static final String PASSWORD="123456789"; //SQLServer���ݿ���������
	private Connection conn=null; //�������Ӷ���
	public DatabaseConnection(){//���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
