<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t"   uri="http://www.t2framework.org/web/t2/functions" %>
<%@ taglib prefix="f"   uri="http://www.slim3.org/functions"%>
<html>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/JavaScript" />
	<link type="text/css" href="${t:url('/css/')}" rel="stylesheet" />
<body>
	<div class="contener">
		<div class="header"><c:if test="${! empty key}"><img width="100" src="${t:url('/img/view/')}${key}"/></c:if></div>
		<div class="contents">
<ul>
<c:forEach var="e" items="${f:errors()}">
<li>${f:h(e)}</li>
</c:forEach>
</ul>
			<form action="${t:url('/upload/')}" method="POST" enctype="multipart/form-data">
				<div>アップロードファイル:<input type="file" name="img"/></div>
				<div>タイトル:<input type="text" name="title"/></div>
				<div>コメント:<textarea name="updaterComment" ></textarea></div>
				<div><input type="submit" name="store" value="アップロード"/></div>
			</form>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>