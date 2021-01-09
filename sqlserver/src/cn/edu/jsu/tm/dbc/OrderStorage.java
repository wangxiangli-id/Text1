package cn.edu.jsu.tm.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.tm.vo.OrderClass;

public class OrderStorage {

	public static void add(OrderClass order) {
		
		String sql="insert into Ordersheet(Ordernumber,Foodnumber,Foodsale) values(?,?,?)";//ʹ��ռλ������������
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
    		pstmt.setString(1, order.getOrdernumber());//�����1��ռλ��������
    		pstmt.setString(2, order.getFoodnumber());//�����2��ռλ��������
    		pstmt.setInt(3, order.getFoodsale());
    		pstmt.executeUpdate();//ִ�в������
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}