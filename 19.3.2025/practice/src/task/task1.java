package task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class task1 {

	public static void main(String[] args) {
		   Scanner scanner = new Scanner(System.in);
	       System.out.println("WELCOME TO SBI");

	       System.out.println("Enter a number \n FOR USERS \n 1:To Withdraw Amount,\n 2: To Deposit Amount,\n FOR ADMINS \n 3: Add New Customer,\n 4: Message Penaulty ");
		   int choice = scanner.nextInt();
		   scanner.nextLine();
		   try{
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "152004");
		   System.out.println("connection established");  
				switch (choice) {
		            case 1:
	        			System.out.println("To Withdraw");
	        			System.out.println("Enter the account number:");
		            	int acc_no = scanner.nextInt();
		            	System.out.println("Enter the withdrawal amount:");
		            	float amt= scanner.nextFloat();
		            	float useramt ;
		        		String query="select amount from users where acc_no=? ;";
		        	
		        			PreparedStatement ps = con.prepareStatement(query);
		        		    ps.setInt(1,acc_no);	
		        			ResultSet rs=ps.executeQuery();
		        			while(rs.next()){
		        				useramt= rs.getFloat("amount");
		        				System.out.println(useramt );
		        				
				        		if(amt < useramt){
				        			System.out.println("Sucessfully done");
				            	String query1="update users set amount=? where acc_no=?;";
				            	float updateamt= useramt-amt;
				        		PreparedStatement ps1 = con.prepareStatement(query1);
				        		    ps1.setFloat(1,updateamt);	
				        			ps1.setInt(2,acc_no);
				        			System.out.println(updateamt);
				                int rows = ps1.executeUpdate();
				                System.out.println (rows+"rows affectd");
				        		}
				        		else{
				        			System.out.println(" BALANCE  IS  LOW !");
				        		}
		        			}
		        			
		        	
		                break;
		            case 2:
		                System.out.println("To Deposit");
		                System.out.println("Enter the account number:");
		            	int acc_no1 = scanner.nextInt();
		            	System.out.println("Enter the amount:");
		            	float amt1= scanner.nextFloat();
		            	float useramt1 ;
		        		String query2="select amount from users where acc_no=? ;";
		        	    PreparedStatement ps1 = con.prepareStatement(query2);
		        		    ps1.setInt(1,acc_no1);	
		        			ResultSet rs1=ps1.executeQuery();
		        			while(rs1.next()){
		        				useramt1= rs1.getFloat("amount");
		        				System.out.println(useramt1 );
		        				System.out.println("Sucessfully done");
				            	String query3="update users set amount=? where acc_no=?;";
				            	float updateamt= useramt1+amt1;
				        		PreparedStatement ps2 = con.prepareStatement(query3);
				        		    ps2.setFloat(1,updateamt);	
				        			ps2.setInt(2,acc_no1);
				        			System.out.println(updateamt);
				                int rows = ps2.executeUpdate();
				                System.out.println (rows+"rows affectd");
				        		}
		        			
		        			
		        		
		                
		                break;
		            case 3:
		                System.out.println("Add New Customer");
		        		System.out.println("Enter the customer Name:");
		        		String name= scanner.nextLine();
		        		System.out.println("Mail Id:");
		        		String email = scanner.nextLine();
		        		System.out.println("Account no ( should start with 10000) \n ex:- 1000000001 ");
		        		int accountno = scanner.nextInt();
		        		scanner.nextLine();
		        		System.out.println("Contact Number(10 digit)");
		        		String contno = scanner.nextLine();
		        		System.out.println("Enter the address:");
		        		String addrs = scanner.nextLine();
		        		System.out.println("Branch Name:");
		        		String branch = scanner.nextLine();
		        		System.out.println("Initial Amount");
		        		float amount = scanner.nextFloat();
		        		String query4="INSERT INTO users (name, mailId, acc_no, contact_no, address, branch, amount) VALUES (?,?,?,?,?,?,?); ";		        	
		        		PreparedStatement ps6 = con.prepareStatement(query4);
		                ps6.setString(1,name);	
		        		ps6.setString(2,email);
		        		ps6.setInt(3,accountno);
		        		ps6.setString(4,contno);
		        		ps6.setString(5,addrs);
		        		ps6.setString(6,branch);
		        		ps6.setFloat(7,amount);
		                int rows = ps6.executeUpdate();
		                System.out.println (rows+"rows affectd");
		        		
		        
		                break;
		            case 4:
		            	System.out.println("Enter the account number:");
		            	int acc_no4 = scanner.nextInt();
		            	float msgamt= 50;
		            	float useramt4 ;
		        		String query5="select amount from users where acc_no=? ;";
		        	
		        			
		        			PreparedStatement ps4 = con.prepareStatement(query5);
		        		    ps4.setInt(1,acc_no4);	
		        			ResultSet rs3=ps4.executeQuery();
		        			while(rs3.next()){
		        				useramt4= rs3.getFloat("amount");
		        				
				        		if(msgamt < useramt4){
				        			System.out.println("Sucessfully done");
				            	String query1="update users set amount=? where acc_no=?;";
				            	float updateamt= useramt4-msgamt;
				        		PreparedStatement ps5 = con.prepareStatement(query1);
				        		    ps5.setFloat(1,updateamt);	
				        			ps5.setInt(2,acc_no4);
				        			System.out.println(updateamt);
				                int rows1 = ps5.executeUpdate();
				                System.out.println (rows1+"rows affectd");
				        		}
				        		else{
				        			System.out.println("MINIMUM BALANCED REACHED ");
				        		}
		        			}
		        			
		        		 
			        	
		            	break;
		            default:
		                System.out.println("Invalid choice");
		        }
}
	catch (SQLException e) {
		e.printStackTrace();
}

		        
	}

}
