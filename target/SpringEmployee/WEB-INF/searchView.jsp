<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="700px" align="center" style="border:1px solid black;">
	<tr>
		<td colspan=4 align="center" style="background-color:red">Employee Details</td>
	</tr>
	<tr style="background-clor:white;">
		<td>Id</td>
		<td>Name</td>
		<td>Salary</td>
		<td>Department</td>
	</tr>
	<%
		int count=0;
		String color="black";
		if(request.getAttribute("listofEmployee") != null)
		{
			ArrayList al = (ArrayList) request.getAttribute("listofEmployee");
			System.out.println(al);
			Iterator itr = al.iterator();
			while(itr.hasNext())
			{
				if((count % 2) == 0)
				{
					color = "red";
				}
				count++;
				ArrayList listofEmployee = (ArrayList) itr.next();
	%>
	<tr style = "background-color:<%=color%>;">
		<td><%=listofEmployee.get(0) %></td>
		<td><%=listofEmployee.get(1) %></td>
		<td><%=listofEmployee.get(2) %></td>
		<td><%=listofEmployee.get(3) %></td>
	</tr>
	<%
			}
		}
		if(count == 0)
		{
	%>
	<tr>
		<td colspan=4 align="center" style="background-color:red">No Record Found</td>		
	</tr>
	<% 
		}
	%>
</table>
</body>
</html>