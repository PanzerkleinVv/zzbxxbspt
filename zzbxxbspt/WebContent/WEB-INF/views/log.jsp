<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="">
		<form id="logSearchForm" method="get">
			<div class="formLine">
				<div class="formDiv">
					<span>
						日志类型：
					</span>
					<span>
						<select name="logType" class="form-control placeholder-no-fix">
							<option value="0" selected="selected">所有</option>
							<option value="1">登录日志</option>
							<option value="2">操作日志</option>
						</select>
					</span>
				</div>
				<div class="formDiv">
					<span>操作人：</span>
					<span>
						<input type="text" name="userName" placeholder="操作人" class="form-control placeholder-no-fix" autocomplete="off" />
					</span>
				</div>
				<div class="formDiv">
					<span>
						课题组：
					</span>
					<span>
						<select id="groupId" name="groupId" class="form-control placeholder-no-fix">
							<option selected="selected">所有</option>
						</select>
					</span>
				</div>
			</div>
			<div class="formLine">
				<div class="formDiv">
					<span>操作内容：</span>
					<span>
						<input type="text" name="logDesc" placeholder="日志内容" class="form-control placeholder-no-fix" autocomplete="off" />
					</span>
				</div>
				<div class="formDiv">
					<span>开始时间：</span>
					<span>
						<input type="text" name="logBegin" readonly class="form_date form-control placeholder-no-fix">
					</span>
				</div>
				<div class="formDiv">
					<span>结束时间：</span>
					<span>
						<input type="text" name="logEnd" readonly class="form_date form-control placeholder-no-fix">
					</span>
				</div>
			</div>
			<div class="formLine">
				<button id="searchBut" type="button" class="btn blue">查询</button>
			</div>
		</form>
	</div>
	<div class="userTable" id="searchResult">
		<div class="userRow userHeader">
			<span class="userItem2">日志类型</span>
			<span class="userItem1">操作人</span>
			<span class="userItem1">操作内容</span>
			<span class="userItem1">操作时间</span>
		</div>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo"/>
	</div>
	<div class="mask"></div>
	<div id="logInfo" class="dialogueBox">
		<div class="dialogueHeader">
			<span>日志信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<div class="formLine">
				<div class="formDiv">
					<span>
						日志类型：
					</span>
					<span id="logType"></span>
				</div>
				<div class="formDiv">
					<span>
						操作人：
					</span>
					<span id="userName"></span>
				</div>
				<div class="formDiv">
					<span>
						操作时间：
					</span>
					<span id="logTime"></span>
				</div>
			</div>
			<div class="formLine">
				<div class="formDiv">
					<span>
						操作内容：
					</span>
					<span id="logDesc"></span>
				</div>
			</div>
		</div>
		<div class="dialogueFooter">
			<button id="closeLog" type="button" class="btn gray">关闭</button>
		</div>
	</div>

	<script type="text/javascript">
		$(".form_date").datepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN'
		});
		
		$('#searchBut').click(function() {
			search(1);
		});

		function search(pageNo) {
			var url = "rest/log/search";
			$.getJSON(url, {
				'pageNo' : pageNo,
				'logType' : $("select[name='logType']").val(),
				'userName' : $("input[name='userName']").val(),
				'groupId' : $("select[name='groupId']").val(),
				'logDesc' : $("input[name='logDesc']").val(),
				'logBegin' : $("input[name='logBegin']").val(),
				'logEnd' : $("input[name='logEnd']").val()
			}, function(data) {
				setPage(data, $(".pageBox"), $("#pageNo"));
				$("#searchResult .userHeader").nextAll().remove();
				$.each(data.result, function(i, n) {
					$("#searchResult").append('<div class="userRow" onclick="info(\''
						+ n.logId
						+ '\')"><span class="userItem2">'
						+ (n.logType == 1 ? "登录日志" : "操作日志")
						+ '</span><span class="userItem1">'
						+ n.userName
						+ '</span><span class="userItem1">'
						+ n.logDesc
						+ '</span><span class="userItem1">'
						+ new Date(n.logTime).toLocaleString()
						+ '</span></div>');
					});
			});
		}

		function info(logId) {
			var url = 'rest/log/info';
			$.getJSON(url, {
				'logId' : logId
			}, function(data) {
				$("#logType").html(data.logType == 1 ? "登录日志" : "操作日志");
				$("#userName").html(data.userName);
				$("#logTime").html(new Date(data.logTime).toLocaleString());
				$("#logDesc").html(data.logDesc);
			});
			dialogueOpen("logInfo");
		}

		$(".dialogueClose").click(function(target) {
			dialogueClose($(this).parent().parent().attr("id"));
		});

		$("#closeLog").click(function(target) {
			dialogueClose("logInfo");
		});

		$(function() {
			search(1);
			$.getJSON('rest/group/list', function(data) {
				$.each(data, function(i, n) {
					$("#groupId").append('<option value="' + n.groupId + '">' + n.groupName + '</option>');
				});
			});
			$("#inputResult").hide();
			$("#index-page-title").html("日志管理");
			$("#current-page-title").html("日志管理");
		});
	</script>
</div>