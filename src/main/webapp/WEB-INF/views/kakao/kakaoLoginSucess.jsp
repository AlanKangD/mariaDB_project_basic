<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Long id = (Long) session.getAttribute("kakao");
	%>
		<h3>session : </h3> <%=id %>
		<h3>session 1 : </h3> ${kakao }
	<c:if test="${kakao != null }">
		<h1>카카오 톡 로그인 기능 생성</h1>
	</c:if>

	<h1>로그인 성공!</h1>
	
	<a href="${contextPath }/recipe/recipeBoard">레시피 게시판 이동</a>


</body>
</html>