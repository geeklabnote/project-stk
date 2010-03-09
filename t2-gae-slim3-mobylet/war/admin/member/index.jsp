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
</head>
<body>
${msg}
<c:if test="${!stk:isEmpty(memberList)}">
	<table>
		<tr>
			<th>名前</th>
			<th>管理者</th>
			<th>操作</th>
		</tr>
	<c:forEach items="${memberList}" var="member">
		<tr>
			<td>${t:escape(member.nickName)}</td>
			<td>${t:escape(member.admin)}</td>
			<td>
				<a href="${t:url('/admin/member/fix/')}${stk:keyString(member.key)}">編集</a>&nbsp;|&nbsp;<a href="${t:url('/admin/member/delete/')}${stk:keyString(member.key)}">削除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
	<form action="${t:url('/admin/member/add')}" method="POST">
		<div>name:<input type="text" name="nickName" value=""/></div>
		<div>pass:<input type="text" name="password" value=""/></div>
		<div>admin:<input type="checkbox" name="admin" value="ON"/></div>
		<div><input type="submit" name="add" value="add"/></div>
	</form>
</body>
</html>
