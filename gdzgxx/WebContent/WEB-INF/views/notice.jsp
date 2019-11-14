<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div>
	<div>
		<span class="uploadTitle">标题：</span> 
		<shiro:hasRole name = "gd">
			<span class="uploadItem withInput"><input name="noticeTitle" id="noticeTitle" value="${notice.noticeTitle}" class="form-control placeholder-no-fix uploadInput" /></span>
		</shiro:hasRole>
		<shiro:lacksRole name = "gd">
			<span>${notice.noticeTitle}</span>
		</shiro:lacksRole>
		<input id="noticeId" name="noticeId" type="hidden" value="${notice.noticeId}" />
	</div>
	<div>
		<div class="uploadTitle">内容：</div>
		<shiro:hasRole name = "gd">
			<div id="summernote" class="uploadItem">${notice.noticeContent}</div>
		</shiro:hasRole>
		<shiro:lacksRole name = "gd">
			<div>${notice.noticeContent}</div>
		</shiro:lacksRole>
	</div>
	<div class="uploadItem">
		<shiro:hasRole name = "gd">
			<button id="saveBut" type="button" class="btn green"
						onclick="saveNotice()">保存</button>
			<c:if test="${notice.noticeId != null}">
				<button id="deleteBut" type="button" class="btn red"
						onclick="deleteNotice()">删除</button>
			</c:if>
		</shiro:hasRole>
		<button id="backBut" type="button" class="btn blue"
						onclick="noticeList('${pageNo}')">返回</button>
	</div>
</div>
<shiro:hasRole name = "gd">
	<script type="text/javascript">
		$(document).ready(function() {
			$('#summernote').summernote({
				height : 500,
				minHeight : null,
				maxHeight : null,
				lang: 'zh-CN',
				toolbar: [
					['style', ['bold', 'italic', 'underline', 'clear']],
					['fontsize', ['fontname', 'fontsize']],
					['color', ['color']],
					[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
					[ 'Insert', [ 'table' ] ] ],
				fontNames: ['宋体', '黑体', '楷体', '微软雅黑'],
				disableDragAndDrop: true
			});
		});
		
		function saveNotice() {
			var title = $("#noticeTitle").val();
			if (title == null || title.length < 1) {
				alert("标题不能为空");
				return false;
			} else {
				var url = "rest/notice/save";
				$.ajax({
					type : "POST",
					url : url,
					data : {
						noticeId : $("#noticeId").val(),
						noticeTitle : $("#noticeTitle").val(),
						noticeContent : $("#summernote").summernote('code')
					},
					cache : false,
					success : function(data){
						alert("保存成功");
						$('#main-content').html(data);
					},
					error : function (XMLHttpRequest, textStatus, errorThrown) {
						alert("保存失败<br/><br/>textStatus: " + textStatus + "<br/>errorThrown: " + errorThrown);
					}
				});
			}
		}
		
		function deleteNotice() {
			var url = "rest/notice/delete";
			$.ajax({
				type : "POST",
				url : url,
				data : {
					noticeId : $("#noticeId").val()
				},
				cache : false,
				success : function(data){
					alert("删除成功");
					$('#main-content').html(data);
				},
				error : function (XMLHttpRequest, textStatus, errorThrown) {
					alert("删除失败<br/><br/>textStatus: " + textStatus + "<br/>errorThrown: " + errorThrown);
				}
			});
		}
	</script>
</shiro:hasRole>
<script type="text/javascript">
	function noticeList(pageNo) {
		var url = 'rest/notice/list';
		$.post(url, {
			pageNo : pageNo
		}, function(data) {
			$('#main-content').html(data);
		});
	}
	
	$(function() {
		$("#index-page-title").html("通知公告");
		$("#current-page-title").html("通知公告");
	});
</script>