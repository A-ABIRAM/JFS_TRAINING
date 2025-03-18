package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(url, "root", "152004");
			System.out.println("Connection Established Successfully...");
			System.out.print("Enter the Mail : ");
			String mail = sc.next();
			String query = "SELECT * FROM users WHERE gmail = '" + mail + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				System.out.print("user found... ");
			}
			else {
				System.out.print("Enter the Password : ");
				String pass= sc.next();
				String query1 = "INSERT INTO users (gmail, pass) VALUES ('" + mail + "','"+pass+"');";
				int rowAffect= st.executeUpdate(query1);
				if(rowAffect>0){
					System.out.print("created");
				}
				else{
					System.out.print("failed");
				}

			}
			con.close();
			rs.close();
			st.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}