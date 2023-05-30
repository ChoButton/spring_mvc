<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>아이디 비밀번호를 입력해주세요</h1>
    <form action="http://localhost:8080/chap01/login" method="POST">
        사용자ID : <input type="text" name="id"><br/>
        사용자PW : <input type="password" name="pw"><br/>
        <input type="submit" value="로그인">
    </form>
</body>
</html>