package sqlserver;

public class ConnectionDemo01 {
	// 定义SQLServer的数据库驱动程序
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
   // 定义MySQL的数据库驱动程序
	public static final String DBDRIVER2 = "org.gjt.mm.mysql.Driver" ;
	public static void main(String[] args) {
		try {
			Class.forName(DBDRIVER) ;			// 加载驱动程序
             System.out.println("驱动加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
