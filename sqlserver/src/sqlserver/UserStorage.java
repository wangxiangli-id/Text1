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
		
		String sql="insert into Manageusers(username,password) values(?,?)";//ʹ��ռλ������������
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, user.getUsername());//�����1��ռλ��������
    		pstmt.setString(2, user.getPassword());//�����2��ռλ��������
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}


