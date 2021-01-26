<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 리스트</h2>
	
	<table border="1">
		<tr>
			<th>순번</th>
			<th>ID</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		
		<!-- students를 반복시키면서, 한 회차당 변수의 이름은 student로 하겠다.  -->
		<c:forEach items="${students }" var="student">
			<tr>
				<td>
					<a href="student_list?seq=${student.seq }">${student.seq }</a>
				</td>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${student.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>