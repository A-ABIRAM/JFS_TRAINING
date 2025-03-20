//prepared statement (select statement)
package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practice4 {

	public static void main(String[] args) {
		String query="select * from usersprepared ;";
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "152004");
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			String name =rs.getString("username");
			System.out.println(name + rs.getInt("userId") + "  " +
			rs.getString("username") + "  " +
			rs.getString("gmail") + "  " +	
		    rs.getString("pass"));
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
