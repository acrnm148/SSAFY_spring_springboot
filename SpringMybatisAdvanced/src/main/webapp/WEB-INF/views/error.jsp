<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Error jsp</title>
</head>
<body>
<h1>
	오류가 발생했습니다.
</h1>

<P>  url: ${url} </P>
<P>  exception: ${exception} </P>
</body>
</html>
