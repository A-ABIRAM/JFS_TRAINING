//meta
package practice;

import java.sql.*;


public class practice5 {

	public static void main(String[] args) {
		String query="select * from usersprepared ;";
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "152004");
		System.out.println("connection established");
		
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		ResultSetMetaData meta=rs.getMetaData();
		
		System.out.println(meta.getColumnCount());
		System.out.println(meta.getColumnName(1));
		System.out.println(meta.getColumnTypeName(1));
		System.out.println(meta.getTableName(1));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
