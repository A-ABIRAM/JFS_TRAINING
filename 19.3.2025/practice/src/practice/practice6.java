//meta info
package practice;

import java.sql.*;


public class practice6 {

	public static void main(String[] args) {
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "152004");
		System.out.println("connection established");
		
		DatabaseMetaData metainfo= con.getMetaData();
		
		System.out.println(metainfo.getDriverName());
		System.out.println(metainfo.getDriverVersion());
		System.out.println(metainfo.getUserName());
		System.out.println(metainfo.getDatabaseProductName());
		System.out.println(metainfo.getDatabaseProductVersion());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}