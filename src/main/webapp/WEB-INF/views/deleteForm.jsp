<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
	<form action="/guestbook2/delete" method="get">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
				<td><button type="submit">삭제</button></td>
			</tr>
		</table>
		<input type="hidden" name="no" value="${param.no}">
	</form>
	
	<br><br>
	<a href="/guestbook2/addlist">메인으로 돌아가기</a>
</body>

</html>