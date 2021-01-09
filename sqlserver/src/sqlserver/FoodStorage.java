package sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodStorage {

	public static void add(FoodClass food) {
		
		String sql="insert into Foodsheet(id,Foodname,Foodprice,storage,quality) values(?,?,?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setInt(1, food.getId());//�����1��ռλ��������
    		pstmt.setString(2, food.getFoodname());//�����2��ռλ��������
    		pstmt.setInt(3, food.getFoodprice());
    		pstmt.setInt(4, food.getStorage());
    		pstmt.setInt(5, food.getQuality());
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}