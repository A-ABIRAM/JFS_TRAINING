<% 
if(session.getAttribute("userId")!=null){
out.println("welcome back " + session.getAttribute("username"));
}
else{
	out.println("session expired...");
}
%><br>
<a href='logout.jsp'>logout</a>