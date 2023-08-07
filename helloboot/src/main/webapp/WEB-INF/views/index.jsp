<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot 메인 화면</title>
</head>
<body>
	<h2>나의 첫 부트 화면</h2>
	<h3><a href="${pageContext.request.contextPath }/member/memberAll">전체 회원 조회</a></h3>
	<form action="${pageContext.request.contextPath }/fileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="upFile"><br>
		<input type="file" name="upFile"><br>
		<input type="file" name="upFile">
		<input type="submit" value="파일 저장">
	</form>
	<form action="${pageContext.request.contextPath }/datatest" method="post">
		<input type="text" name="data">
		<input type="submit" value="전송">
	</form>
	<form action="${pageContext.request.contextPath }/memberId" method="post">
		<input type="text" name="userId">
		<input type="submit" value="아이디로 조회">
	</form>
	<form action="${pageContext.request.contextPath }/membername" method="get">
		<input type="text" name="name">
		<input type="submit" value="이름으로 조회">
	</form>
	
	<button onclick="openChatting();">채팅하기</button>
	
	<script>
		function openChatting(){
			open("/chattingpage","_blank","width=400,height=500");
		}
	</script>
	
	<button onclick="memberAll();">전체 회원 가져오기</button>
	<script>
		const memberAll=()=>{
			fetch("${pageContext.request.contextPath}/ajax/memberAll")
				.then(response=>{
						if(!response.ok) 
							throw new Error("요청에러"); 
						return response.json();
					})
				.then(data=>{
					console.log(data);
				})
				.catch(error=>{
					console.log(error);
				});
		}
	</script>
	
	<h2>JPA 적용</h2>
	<h3><a href="${pageContext.request.contextPath }/jpa/member/admin">관리자 조회</a></h3>
	<h3><a href="${pageContext.request.contextPath }/jpa/member/insertMember">사원생성 조회</a></h3>
	<h3><a href="${pageContext.request.contextPath }/board">게시글 조회</a></h3>
	<h3><a href="${pageContext.request.contextPath }/board?title='안녕'">게시글 제목으로 조회</a></h3>
</body>
</html>