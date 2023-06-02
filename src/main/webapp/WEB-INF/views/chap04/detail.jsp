<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>${score.studentNumber}번 학생 성적정보</h1>
<table class="table table-hover">
        <tr>
            <td>이름</td>
            <td>${score.name}</td>
        </tr>
        <tr>
            <th>국어</th>
            <th>${score.korScore}점</th>
        </tr>
        <tr>
            <th>수학</th>
            <th>${score.mathScore}점</th>
        </tr>
        <tr>
            <th>영어</th>
            <th>${score.engScore}점</th>
        </tr>
        <tr>
            <th>총점</th>
            <th>${score.engScore + score.korScore + score.mathScore}점</th>
        </tr>
        <tr>
            <th>평균</th>
            <th>${(score.engScore + score.korScore + score.mathScore) / 3}점</th>
        </tr>
</table>
        <a href="/score/list" class="btn btn-primary">목록으로 돌아가기</a>
        <form action="/score/remove" method="POST">
            <input type="hidden" name="studentNumber" value="${score.studentNumber}">
            <input type="submit" class="btn btn-secondary" value="삭제하기">
        </form>

</div>
</body>
</html>