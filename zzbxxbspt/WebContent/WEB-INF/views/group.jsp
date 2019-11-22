<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="groupName" id="groupNameSearch" size="25" class="form-control placeholder-no-fix searchBox" type="text" autocomplete="off" placeholder="查找课题组" />
			<button id="searchBut" type="button" class="btn blue">查询</button>
			<button id="createBut" type="button" class="btn green">新增</button>
		</form>
	</div>
	<div class="userTable" id="searchResult">
		<div class="userRow userHeader">
			<span class="userItem5">课题组名</span>
			<span class="userItem6">课题组状态</span>
			<span class="userItem6">操作</span>
		</div>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo" />
	</div>
	<div class="mask"></div>
	<div id="groupInfo" class="dialogueBox">
		<div class="dialogueHeader">
			<span>课题组信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<form id="groupForm" class="needs-validation">
				<div class="formLine">
					<div class="formDiv">
						<span>
							课题组名：<i>*</i>
						</span>
						<input type="hidden" id="groupId" name="groupId" />
						<span>
							<input type="text" id="groupName" name="groupName" placeholder="课题组名" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<button id="saveGroup" type="button" class="btn blue">保存</button>
			<button id="deleteGroup" type="button" class="btn red">删除</button>
			<button id="closeGroup" type="button" class="btn gray">取消</button>
		</div>
	</div>

	<script type="text/javascript">
		$('#searchBut').click(function() {
			search(1);
		});

		$('#createBut').click(function() {
			edit(0);
		});

		function search(pageNo) {
			var url = 'rest/group/search';
			$
					.getJSON(
							url,
							{
								'pageNo' : pageNo,
								'groupName' : $("#groupNameSearch").val()
							},
							function(data) {
								setPage(data, $(".pageBox"), $("#pageNo"));
								$("#searchResult .userHeader").nextAll().remove();
								$.each(data.result,function(i, n) {
									$("#searchResult").append('<div class="userRow"><span class="userItem5">'
										+ n.groupName
										+ '</span><span class="userItem6">'
										+ (n.groupStatus == 1 ? "启用" : "停用")
										+ '</span><span class="userItem6"><button type="button" class="btn blue" onclick="edit(\''
										+ n.groupId
										+ '\')">修改</button>&emsp;'
										+ (n.groupStatus == 1 ? '<button type="button" class="btn red" onclick="stopGroup(\'' + n.groupId + '\')">停用</button>' : '<button type="button" class="btn green" onclick="startGroup(\'' + n.groupId + '\')">启用</button>')
										+ '</span></div>');
								});
							});
		}

		function edit(groupId) {
			if (groupId == 0) {
				$("#deleteGroup").hide();
				$("#groupId").val("");
				$("#GroupName").val("");
			} else {
				var url = 'rest/group/info';
				$("#deleteGroup").show();
				$.getJSON(url, {
					'groupId' : groupId
				}, function(data) {
					$("#groupId").val(data.groupId);
					$("#groupName").val(data.groupName);
				});
			}
			dialogueOpen("groupInfo");
		}

		$(".dialogueClose").click(function(target) {
			dialogueClose($(this).parent().parent().attr("id"));
		});

		$("#closeGroup").click(function(target) {
			dialogueClose("gruopInfo");
		});

		$("#saveGroup").click(function(target) {
			$("form#groupForm").submit();
		});

		$("#deleteGroup").click(function(target) {
			var url = "rest/group/delete";
			$.getJSON(url, {
				'groupId' : $("#groupId").val(),
				'groupName' : $("#groupName").val()
			}, function(data) {
				dialogueClose("groupInfo");
				search(1);
				layer.msg(data.content, {
					time : 2000
				});
			});
		});

		$(function() {
			$("form#groupForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/group/edit",
						dataType : "json",
						success : function(result) { //表单提交后更新页面显示的数据
							dialogueClose("groupInfo");
							search(1);
							layer.msg(result.content, {
								time : 2000
							});
						}
					});
				}
			});
		});
		
		function startGroup(groupId) {
			var url = 'rest/group/edit';
			$.ajax({
				'url' : url, 
				'data' : {
					'groupId' : groupId,
					'groupStatus' : 1
				},
				'type' : 'POST',
				'cache' : false,
				'dataType' : 'json',
				'success' : function(result) {
					search(1);
					layer.msg(result.content, {
						time : 2000
					});
				}
			});
		}
		
		function stopGroup(groupId) {
			var url = 'rest/group/edit';
			$.ajax({
				'url' : url, 
				'data' : {
					'groupId' : groupId,
					'groupStatus' : 0
				},
				'type' : 'POST',
				'cache' : false,
				'dataType' : 'json',
				'success' : function(result) {
					search(1);
					layer.msg(result.content, {
						time : 2000
					});
				}
			});
		}

		$(function() {
			search(1);
			$("#inputResult").hide();
			$("#index-page-title").html("课题管理");
			$("#current-page-title").html("课题管理");
		});
	</script>
</div>