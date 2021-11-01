<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

  
<h1>All Languages</h1>
<table class="table table-success table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${ language.id }"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
          	<td>
          		<a href="/languages/${language.id}/edit"><button class="btn btn-info">Edit Language</button></a>
				<form action="/languages/${language.id}" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" class="btn btn-danger" value="Delete">
				</form>

          	</td>
          	
        </tr>
    </c:forEach>
    </tbody>
</table>


<h1>New Language</h1>
<form:form  action="/languages" method="post" modelAttribute="form">
    <p>
        <form:label class="form-label" path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" path="name"/>
    </p>
    <p>
       <form:label class="form-label" path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input class="form-control" path="creator"/>
    </p>
    <p>
        <form:label class="form-label" path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input class="form-control" path="version"/>
    </p>
    
    <input type="submit" class="btn btn-success" value="Submit"/>
</form:form>   
</body>
</html>