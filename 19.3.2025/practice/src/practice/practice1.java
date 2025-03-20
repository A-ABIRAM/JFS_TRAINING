//prepared statement (insert statement)
package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class practice1 {
	public static void main (String[] args){

		String query="insert into usersprepared (username,gmail,pass) values (?,?,?);";
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "152004");
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"abiram.a");	
		ps.setString(2,"abiram.a@gmail.cm");
		ps.setString(3,"abiram152000220");
		
        int rows = ps.executeUpdate();
        System.out.println (rows+"rows affectd");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
}
