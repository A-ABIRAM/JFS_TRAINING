<% 
if(session.getAttribute("userId")!=null){
out.println("welcome back " + session.getAttribute("username"));
String ans="ADMIN";
if(session.getAttribute("authentication").equals(ans)){
	out.println("View the users");
	%><br>
	<a href='list.jsp'>view all users</a>
	<%
}
}
else{
	out.println("session expired...");
}
%><br>
<a href='logout.jsp'>logout</a>