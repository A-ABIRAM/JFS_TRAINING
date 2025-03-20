//prepared statement (deleting data)
package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class practice2 {

	public static void main(String[] args) {
		String query="delete from usersprepared where userId=?;";
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "152004");
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,1);	
		
		
        int rows = ps.executeUpdate();
        System.out.println (rows+"rows affectd");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
