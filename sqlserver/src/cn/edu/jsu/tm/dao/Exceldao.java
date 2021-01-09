package cn.edu.jsu.tm.dao;

	
	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlserver.DatabaseConnection;

public class Exceldao{
		
		public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=(Connection) dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getInt(1));//��ȡ��һ���ֶη�������
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶι˿�ID
	    			row.add(rs.getInt(3));//��ȡ�������ֶ�Ա��ID
	    			row.add(rs.getInt(4));//��ȡ���ĸ��ֶη�����Ŀ
	    			row.add(rs.getInt(5));//��ȡ������ֶμ۸�
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
}