<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t"   uri="http://www.t2framework.org/web/t2/functions" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <link src="${t:url('/css/typeIT.css')}" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container" align="center">
		<div class="contents">
			<form action="${t:url('/auth/login/')}" method="post">
			ID:<input align="left" type="text" name="userId"/><br/>
			PASSOWRD:<input align="left" type="password" name="password"/><br/>
			<input type="submit" name="login" value="ログイン"/>
			</form>
		</div>
	</div>
</body>
</html>
