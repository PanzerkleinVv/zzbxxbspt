<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="msgTable">
	<shiro:hasRole name = "gd">
	<button class="btn blue" type="button" onclick="openNotice('new')">发布通知</button>
	</shiro:hasRole>
	<div class="msg msgHeader">
		<span class="msgItem1">通 知</span> <span
			class="msgItem3">时 间</span>
	</div>
	<c:if test="${notices != null}">
		<c:forEach items="${notices}" var="notice0">
			<div class="msg" id="${notice0.noticeId}">
				<span class="msgItem1" onclick="openNotice('${notice0.noticeId}')">
					<c:choose>
	    				<c:when test="${notice0.unread}">
	    					<i class="fa fa-envelope"></i>
	    				</c:when>
	    				<c:otherwise>
	    					<i class="fa fa-envelope-open-o"></i>
	    				</c:otherwise>
	    			</c:choose>
    				${notice0.noticeTitle}
    			</span>
				<span class="msgItem3" onclick="openNotice('${notice0.noticeId}')"> <fmt:formatDate
						value='${notice0.noticeDate}' type='DATE' pattern='yyyy-MM-dd' />
				</span>
			</div>
		</c:forEach>
	</c:if>
</div>
<div class="pageBox">
	<input type="hidden" id="pageNo" value="${page.pageNo}" />
	<c:if test="${page.pageNo eq 1}">
		<span class="page firstP">首页</span>
		<span class="page beforeP">上一页</span>
	</c:if>
	<c:if test="${page.pageNo > 1}">
		<span class="page firstP" onclick="noticeList(1)">首页</span>
		<span class="page beforeP" onclick="noticeList(${page.pageNo-1})">上一页</span>
	</c:if>
	<c:if test="${page.totalPages<5}">
		<c:forEach begin="1" end="${page.totalPages}" varStatus="index">
			<span class="page numP" id="${index.index}"
				onclick="noticeList(${index.index})">${index.index}</span>
		</c:forEach>
	</c:if>
	<c:if test="${page.totalPages>5}">
		<c:if test="${page.pageNo<=3}">
			<c:forEach begin="1" end="5" varStatus="index">
				<span class="page numP" id="${index.index}"
					onclick="noticeList(${index.index})">${index.index}</span>
			</c:forEach>
		</c:if>
	</c:if>
	<span class="page countP">第${page.pageNo}/${page.totalPages}页（共${page.totalCount}条结果）</span>
	<c:if test="${page.totalPages>5}">
		<c:if test="${page.pageNo>=4&&page.pageNo<=page.totalPages-2}">
			<c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}"
				varStatus="index">
				<span class="page numP" id="${index.index}"
					onclick="noticeList(${index.index})">${index.index}</span>
			</c:forEach>
		</c:if>
	</c:if>
	<c:if test="${page.totalPages>5}">
		<c:if test="${page.pageNo>(page.totalPages-2)}">
			<c:forEach begin="${page.totalPages-4}" end="${page.totalPages}"
				varStatus="index">
				<span class="page numP" id="${index.index}"
					onclick="noticeList(${index.index})">${index.index}</span>
			</c:forEach>
		</c:if>
	</c:if>
	<c:if test="${page.pageNo eq page.totalPages}">
		<span class="page afterP">下一页</span>
		<span class="page lastP">尾页</span>
	</c:if>
	<c:if test="${page.pageNo < page.totalPages}">
		<span class="page afterP" onclick="noticeList(${page.pageNo+1})">下一页</span>
		<span class="page lastP" onclick="noticeList(${page.totalPages})">尾页</span>
	</c:if>
</div>
<script type="text/javascript">
	function noticeList(pageNo) {
		var url = 'rest/notice/list';
		$.post(url, {
			pageNo : pageNo
		}, function(data) {
			$('#main-content').html(data);
		});
	}
	
	function openNotice(noticeId) {
		var url = 'rest/notice/open';
		$.post(url, {
			pageNo : $("#pageNo").val(),
			noticeId : noticeId
		}, function(data) {
			checkNews();
			$('#main-content').html(data);
		});
	}
	
	$(function() {
		$("#index-page-title").html("通知公告");
		$("#current-page-title").html("通知公告");
	});
</script>