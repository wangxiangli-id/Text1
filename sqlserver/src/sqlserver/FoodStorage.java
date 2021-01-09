package sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodStorage {

	public static void add(FoodClass food) {
		
		String sql="insert into Foodsheet(id,Foodname,Foodprice,storage,quality) values(?,?,?,?,?)";//使用占位符定义插入语句
		
		DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//获取数据库连接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
    		pstmt.setInt(1, food.getId());//定义第1个占位符的内容
    		pstmt.setString(2, food.getFoodname());//定义第2个占位符的内容
    		pstmt.setInt(3, food.getFoodprice());
    		pstmt.setInt(4, food.getStorage());
    		pstmt.setInt(5, food.getQuality());
    		pstmt.executeUpdate();//执行插入语句
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	

}