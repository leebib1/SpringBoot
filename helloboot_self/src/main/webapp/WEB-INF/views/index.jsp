<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="메인화면"/>
</jsp:include>
<div id="container">
	<section id="content">
		<button id="memberAll" class="btn btn-outline-success my-2 my-sm-0" onclick="fn_searchMemberAll();">전체 회원 조회</button>
		<input type="text" id="userId">
		<button class="btn btn-outline-success my-2 my-sm-0" onclick="fn_seachMember();">조회</button>
		<h2 align="center" style="margin-top: 200px">안녕하세요, MVC입니다.</h2>
		<div id="memberList"></div>
	</section>
</div>
<script>
	function fn_searchMemberAll(){
		//location.assign("${path}/member/enrollMember.do");
	}
	function fn_searchMember(){
		//location.assign("${path}/member/userName");
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>