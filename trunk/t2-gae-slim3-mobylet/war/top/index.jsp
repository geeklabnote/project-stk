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
  <link type="text/css" href="${t:url('/css/stk.css')}" rel="stylesheet" />
  <link type="text/css" href="${t:url('/css/top.css')}" rel="stylesheet" />
  <link type="text/css" href="${t:url('/css/redmond/jquery-ui-1.8rc3.custom.css')}" rel="stylesheet"/>

  <script src="${t:url('/js/jquery-1.4.2.min.js')}" type="text/javascript"></script>
  <script src="${t:url('/js/jquery-ui-1.8rc3.custom.min.js')}" type="text/javascript"></script>
  <script type="text/javascript">
  $(function(){
    $('#imgBox2').accordion({
					collapsible: true,
					active: false,
					autoHeight: false,
					navigation: true

				});
  });
  </script>
</head>
<body>
<div class="conteiner">
<div align="right">${member.nickName}&nbsp;|&nbsp;<a href="${t:url(logoutUrl)}">ログアウト</a></div>
<p><a href="${t:url('/upload')}">画像をUPLOADする。</a></p>
<c:if test="${!stk:isEmpty(list)}">
	<div id="imgBox2" style="clear:both">
	<c:forEach items="${list}" var="img">
		<h3 style="clear:both" class="fs-1"><a href="#">${t:escape(img.title)}&nbsp;<font size="1">投稿者&nbsp;${t:escape(img.updater.nickName)}</font></a></h3>
		<div style="clear:both;">
			<p>
				<a href="javascript:void(0);" class="commentLink" value="${img.key}">コメント</a>
				|&nbsp;<a href="javascript:void(0)" class="voteLink" value="${img.key}">投票</a>
				<c:if test="${img.updater.key eq sessionScope.member.key}">|&nbsp;<a href="${t:url('/img/delete/')}${stk:keyString(img.key)}/">削除</a></c:if>
			</p>
			<div class="img" style="float:left;">
				<img src="${t:url('/img/view')}/${stk:keyString(img.key)}/" width="200" class="fl-l"/>
			</div>
			<div class="right" style="float:left;">
				<p>
					${t:escape(img.updaterComment)}
				</p>
			</div>
			<div class="comment" style="clear:both;">
				&nbsp;
			</div>
		</div>
	</c:forEach>
	</div>



	<c:forEach items="${list}" var="img">
	<div id="imgBox" style="clear:both">
		<div class="title">
			<h4>${t:escape(img.title)}&nbsp;<font size="1">投稿者&nbsp;${t:escape(img.updater.nickName)}</font></h4>
			<div class="tools">
				<a href="javascript:void(0);" class="commentLink" value="${img.key}">コメント</a>
				|&nbsp;<a href="javascript:void(0)" class="voteLink" value="${img.key}">投票</a>
				<c:if test="${img.updater.key eq sessionScope.member.key}">|&nbsp;<a href="${t:url('/img/delete/')}${stk:keyString(img.key)}/">削除</a></c:if>
			</div>
		</div>
		<div class="img">
			<img src="${t:url('/img/view')}/${stk:keyString(img.key)}/" width="200" class="fl-l"/>
		</div>
		<div class="right">
			<p>
				${t:escape(img.updaterComment)}
			</p>
		</div>
		<div class="comment">
			&nbsp;
		</div>
	</div>
</c:forEach>
</c:if>
</div>
</body>
</html>