package cn.edu.jsu.tm.dao;

	
	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlserver.DatabaseConnection;

public class Exceldao{
		
		public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	try(Connection conn=(Connection) dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getInt(1));//获取第一个字段服务序数
	    			row.add(rs.getString(2));//获取第二个字段顾客ID
	    			row.add(rs.getInt(3));//获取第三个字段员工ID
	    			row.add(rs.getInt(4));//获取第四个字段服务项目
	    			row.add(rs.getInt(5));//获取第五个字段价格
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
}