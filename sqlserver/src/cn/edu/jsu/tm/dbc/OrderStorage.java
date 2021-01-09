package cn.edu.jsu.tm.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.jsu.tm.vo.OrderClass;

public class OrderStorage {

	public static void add(OrderClass order) {
		
		String sql="insert into Ordersheet(Ordernumber,Foodnumber,Foodsale) values(?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setString(1, order.getOrdernumber());//定义第1个占位符的内容
    		pstmt.setString(2, order.getFoodnumber());//定义第2个占位符的内容
    		pstmt.setInt(3, order.getFoodsale());
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}