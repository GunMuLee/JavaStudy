<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		if("${false}" != ""){
			alert("${false}");
			history.back();
		} else if("${home}" != ""){
			alert("${home}");
			location.href = "/";
		}
		
	});
</script>
</head>
<body>

</body>
</html>