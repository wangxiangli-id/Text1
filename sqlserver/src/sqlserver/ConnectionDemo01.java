package sqlserver;

public class ConnectionDemo01 {
	// ����SQLServer�����ݿ���������
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
   // ����MySQL�����ݿ���������
	public static final String DBDRIVER2 = "org.gjt.mm.mysql.Driver" ;
	public static void main(String[] args) {
		try {
			Class.forName(DBDRIVER) ;			// ������������
             System.out.println("�������سɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
