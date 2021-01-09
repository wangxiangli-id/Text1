package sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserStorage {
	
	public static void add(User user) {
		
		String sql="insert into Manageusers(username,password) values(?,?)";//使用占位符定义插入语句
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, user.getUsername());//定义第1个占位符的内容
    		pstmt.setString(2, user.getPassword());//定义第2个占位符的内容
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}


