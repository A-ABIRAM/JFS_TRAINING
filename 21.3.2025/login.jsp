<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import =  "java.sql.* " %>
<% 
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/testdb";
		Connection con = DriverManager.getConnection(url,"root","152004");
		out.println("Connection Established...");
		
		String usermail = request.getParameter("usermail");
		String userpass = request.getParameter("password");
		
		String query = "SELECT * FROM users WHERE gmail = ? AND userpass =?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,usermail);
		ps.setString(2,userpass);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			session.setAttribute("userId",rs.getInt("userId"));
			session.setAttribute("username",rs.getString("username"));
			session.setAttribute("usermail",usermail);
			session.setAttribute("userpass",userpass);	
			session.setAttribute("authentication",rs.getString("authentication"));
			response.sendRedirect("session.jsp");
			
			out.println("<br>User Already Exists.....");
		
		}
		else{
			out.println("User not Found ....");
			out.println("<br><a href ='index.jsp'>Login</a>");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>