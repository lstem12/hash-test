<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : ${hb.HB_TITLE}<br>
내용 : ${hb.HB_CONTENT}<br>
해쉬태크 :
<c:forEach items="${hb.hashs}" var="hash">
	<a href="/board/list/${hash.HT_HASH}">#${hash.HT_HASH}</a> 
</c:forEach>
</body>
</html>