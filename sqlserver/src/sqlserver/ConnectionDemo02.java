package sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo02 {
	// ����SQLServer�����ݿ���������
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
	// ����SQLServer���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=testdb" ;
	// SQL���ݿ�������û���
	public static final String DBUSER = "sa" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "123456789" ;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null ;			// ���ݿ�����
		Class.forName(DBDRIVER) ;			// ���������������쳣
		// ����MySQL���ݿ�ʱ��Ҫд�����ӵ��û��������룬���쳣
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); // ���쳣
		System.out.println(conn) ;
		conn.close() ;					// ���ݿ�رգ����쳣
	}
}
