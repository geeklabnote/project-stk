<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t"   uri="http://www.t2framework.org/web/t2/functions" %>
<%@ taglib prefix="stk" uri="http://www.stk.jp/web/stk/functions" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/JavaScript" />
  <script src="${t:url('/js/jquery-1.3.2.min.js')}"></script>
  <script src="${t:url('/js/jquery-ui-1.7.2.custom.min.js')}"></script>

</head>
<body>
${member.nickName}
<p><a href="${t:url('/upload')}">画像をUPLOADする。</a></p>
<c:if test="${!stk:isEmpty(list)}">
	<c:forEach items="${list}" var="img">
	<div>
	<hr/>
	<p><c:out value="${img.title}"></c:out></p>
	<img src="${t:url('/img/view/')}${stk:keyString(img.key)}"/><br/>
	<p><a href="javascript:void(0);" class="commentLink" value="${img.key}">コメントする。</a>&nbsp;|&nbsp;<a href="javascript:void(0)" class="voteLink" value="${img.key}">投票</a></p>
	</div>
	</c:forEach>
</c:if>
</body>
</html>