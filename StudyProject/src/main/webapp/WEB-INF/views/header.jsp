<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
          <a href="./" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="me-2" viewBox="0 0 24 24"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"/><circle cx="12" cy="13" r="4"/></svg>
            <strong>홈</strong>
          </a>
        <div class="row">
        	<c:choose>
        		<c:when test="${sessionScope.nickName != null }">
	        		<div class="col">
	        			<a href="MyPage" class="navbar-brand d-flex align-items-center">
	                    	<strong>${sessionScope.nickName }</strong>
	                	</a>
	        		</div>
	        		<div class="col">
	        			<a href="Logout" class="navbar-brand d-flex align-items-center">
	                    	<strong>로그아웃</strong>
	                	</a>
	        		</div>
        		</c:when>
        		<c:otherwise>
	        		<div class="col">
		                <a href="Login" class="navbar-brand d-flex align-items-center">
		                    <strong>로그인</strong>
		                </a>
		            </div>
		            <div class="col">
		                <a href="Join" class="navbar-brand d-flex align-items-center">
		                    <strong>회원가입</strong>
		                </a>
		            </div>
        		</c:otherwise>
        	</c:choose>
            <div class="col">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </div>
    </div>
      </div>
      <div class="collapse text-bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4>메뉴바</h4>
              <div class="row">
              	<div class="col">
              		<a href="ChatGPT" class="navbar-brand d-flex align-items-center">
              			<h4>ChatGPT</h4>
              		</a>
              	</div>
              	<div class="col">
              		<a href="Chat" class="navbar-brand d-flex align-items-center">
              			<h4>Chat</h4>
              		</a>
              	</div>
              </div>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4>메뉴바</h4>
            </div>
          </div>
        </div>
      </div>
</body>
</html>