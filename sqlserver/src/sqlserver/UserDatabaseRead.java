package sqlserver;

	import java.sql.Connection;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Vector;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	public class UserDatabaseRead {
		private Connection conn=new DatabaseConnection().getConnection();
		public UserDatabaseRead() {}
		public List<User> getAllUserData() {
			List<User> list=new ArrayList<User>();
			String sql="select username,password from Manageusers";
			try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					User user=new User();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					
					list.add(user);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		public Vector<Vector> getTableRows(List<User> list){
			Vector<Vector> rows=new Vector<Vector>();
			for(int i=0;i<list.size();i++) {
				Vector row=new Vector();
				User user=list.get(i);
				Collections.addAll(row, user.getUsername(),user.getPassword());
				rows.add(row);
			}
			
			return rows;
		}

	}
