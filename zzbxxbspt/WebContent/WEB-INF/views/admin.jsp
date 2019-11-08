<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="userName" id="userNameSearch" size="25" class="form-control placeholder-no-fix searchBox" type="text" autocomplete="off" placeholder="查找学员" />
			<button id="searchBut" type="button" class="btn blue">查询</button>
			<button id="createBut" type="button" class="btn green">新增</button>
			<button id="inputBut" type="button" class="btn green">批量导入</button>
		</form>
	</div>
	<div class="userTable" id="searchResult">
		<div class="userRow userHeader">
			<span class="userItem1">学员名</span>
			<span class="userItem1">单位名</span>
			<span class="userItem1">身份证号</span>
			<span class="userItem2">操作</span>
		</div>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo" />
	</div>
	<div class="mask"></div>
	<div id="userInfo" class="dialogueBox">
		<div class="dialogueHeader">
			<span>学员信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<form id="userForm" class="needs-validation">
				<div class="formLine">
					<div class="formDiv">
						<span>
							学员名：<i>*</i>
						</span>
						<input type="hidden" id="userId" name="userId" />
						<span>
							<input type="text" id="userName" name="userName" placeholder="学员名" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>单位名：</span>
						<span>
							<input type="text" id="userDesc" name="userDesc" placeholder="单位名" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							身份证号：<i>*</i>
						</span>
						<span>
							<input type="text" id="userPsw" name="userPsw" placeholder="身份证号" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<button id="saveUser" type="button" class="btn blue">保存</button>
			<button id="deleteUser" type="button" class="btn red">删除</button>
			<button id="closeUser" type="button" class="btn gray">取消</button>
		</div>
	</div>
	<div id="userInput" class="dialogueBox">
		<div class="dialogueHeader">
			<span>批量导入学员信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<form id="uploadForm" class="needs-validation" enctype="multipart/form-data">
				<div class="formLine">
					<div class="formDiv">
						<span>模版下载：</span>
						<span>
							<a href="rest/user/template" target="_blank">学员批量导入模版.xls</a>
						</span>
					</div>
					<div class="formDiv">
						<span>
							<button id="uploadFile" type="submit" class="btn green">上传</button>
						</span>
						<span>
							<input type="file" name="uploadFile" placeholder="请选择文件" class="form-control placeholder-no-fix" required />
						</span>
					</div>
				</div>
			</form>
			<form id="inputForm" class="needs-validation">
				<div class="userTable" id="inputResult">
					<div class="userRow userHeader">
						<span class="userItem4">删除</span>
						<span class="userItem3">学员名</span>
						<span class="userItem3">单位名</span>
						<span class="userItem3">身份证号</span>
						<span class="userItem4">状态</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<div id="uploadFooter">
				<button id="uploadAllUser" type="button" class="btn blue">全部保存</button>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="app/js/personCard.js"></script>
	<script type="text/javascript">
		$('#searchBut').click(function() {
			search(1);
		});

		$('#createBut').click(function() {
			edit(0);
		});

		$('#inputBut').click(function() {
			dialogueOpen("userInput");
			$("#inputResult .userHeader").nextAll().remove();
			$("#uploadAllUser").hide();
		});

		function search(pageNo) {
			var url = 'rest/user/search';
			$
					.getJSON(
							url,
							{
								'pageNo' : pageNo,
								'userName' : $("#userNameSearch").val()
							},
							function(data) {
								setPage(data, $(".pageBox"), $("#pageNo"));
								$("#searchResult .userHeader").nextAll().remove();
								$.each(data.result,function(i, n) {
									$("#searchResult").append('<div class="userRow"><span class="userItem1">'
										+ n.userName
										+ '</span><span class="userItem1">'
										+ n.userDesc
										+ '</span><span class="userItem1">'
										+ n.userPsw
										+ '</span><span class="userItem2"><button type="button" class="btn blue" onclick="edit(\''
										+ n.userId
										+ '\')">修改</button></span></div>');
								});
							});
		}

		function edit(userId) {
			if (userId == 0) {
				$("#deleteUser").hide();
				$("#userId").val("");
				$("#userName").val("");
				$("#userPsw").val("");
				$("#userDesc").val("");
			} else {
				var url = 'rest/user/info';
				$("#deleteUser").show();
				$.getJSON(url, {
					'userId' : userId
				}, function(data) {
					$("#userId").val(data.userId);
					$("#userName").val(data.userName);
					$("#userPsw").val(data.userPsw);
					$("#userDesc").val(data.userDesc);
				});
			}
			dialogueOpen("userInfo");
		}

		$(".dialogueClose").click(function(target) {
			dialogueClose($(this).parent().parent().attr("id"));
		});

		$("#closeUser").click(function(target) {
			dialogueClose("userInfo");
		});

		$("#saveUser").click(function(target) {
			$("form#userForm").submit();
		});

		$("#deleteUser").click(function(target) {
			var url = "rest/user/delete";
			$.getJSON(url, {
				'userId' : $("#userId").val(),
				'userName' : $("#userName").val()
			}, function(data) {
				dialogueClose("userInfo");
				search(1);
				layer.msg(data.content, {
					time : 2000
				});
			});
		});
		
		$("#uploadAllUser").click(function(target) {
			$("form#inputForm").submit();
		})

		$(function() {
			$("form#userForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/user/edit",
						dataType : "json",
						success : function(result) { //表单提交后更新页面显示的数据
							dialogueClose("userInfo");
							search(1);
							layer.msg(result.content, {
								time : 2000
							});
						}
					});
				},
				rules : {
					"userPsw" : {
						isCardNo : true,
						checkProvince : true,
						checkBirthday : true,
						checkParity : true,
						remote: {
						    url: "rest/user/checkPsw",     //后台处理程序
						    type: "get",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						    	userId: function() {
						    		return $("#userId").val();
						    		},
						    	userPsw: function() {
						    		return $("#userPsw").val();
						    		}
						        }
						    }
						}
				},
				messages : {
					"userPsw" : {
						remote: "您输入的身份证号码已被使用,请重新输入"
					}
				}
			});
		});

		$(function() {
			$("form#uploadForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/user/input",
						dataType : "json",
						success : function(result) {
							if (result.flag) {
								$("#inputResult").show();
								$("#inputResult .userHeader").nextAll().remove();
								$.each(result.object,function(i, n) {
									$("#inputResult").append('<div class="userRow" id="input' + i + '"><span class="userItem4"><button type="button" class="btn red" onclick="rowDelete(\'input' + i + '\')">删除</button></span><span class="userItem3">'
										+ '<input type="hidden" name="userName" />'
										+ '</span><span class="userItem3">'
										+ '<input type="hidden" name="userDesc" />'
										+ '</span><span class="userItem3">'
										+ '<input type="hidden" name="userPsw" />'
										+ '</span><span class="userItem4"><input type="hidden" class="inputFlag" value="0"/></span></div>');
									$("#input" + i + " input[name='userName']").val(n.userName);
									$("#input" + i + " input[name='userName']").parent().append($("#input" + i + " input[name='userName']").val());
									$("#input" + i + " input[name='userDesc']").val(n.userDesc);
									$("#input" + i + " input[name='userDesc']").parent().append($("#input" + i + " input[name='userDesc']").val());
									$("#input" + i + " input[name='userPsw']").val(n.userPsw);
									$("#input" + i + " input[name='userPsw']").parent().append($("#input" + i + " input[name='userPsw']").val());
									$("#input" + i + " input.inputFlag").val(n.message.flag ? 0 : 1);
									if (n.message.flag) {
										$("#input" + i + " input.inputFlag").parent().append("未上传");
									} else {
										$("#input" + i + " input.inputFlag").parent().append("错误项");
										$("#input" + i + " input.inputFlag").parent().parent().attr("title", n.message.content)
									}
								});
								$("form#inputForm.needs-validation").validate({
									submitHandler : function(form) {
										$(form).ajaxSubmit({
											type : 'post',
											url : "rest/user/saveAll",
											dataType : "json",
											success : function(result) {
												layer.msg(result.content, {
													time : 2000
												});
											},
											error : function(){
												layer.msg("保存出错", {
													time : 2000
												});
											}
										});
									}
								});
								$("#uploadAllUser").show();
								layer.msg(result.content, {
									time : 2000
								});
							} else {
								$("#inputResult .userHeader").nextAll().remove();
								$("#uploadAllUser").hide();
								layer.msg(result.content, {
									time : 2000
								});
							}
						},
						error : function(){
							$("#inputResult .userHeader").nextAll().remove();
							$("#uploadAllUser").hide();
							layer.msg("Excle解析出错", {
								time : 2000
							});
						}
					});
				}
			});
		});
		
		function rowDelete(id) {
			$("#" + id).remove();
		}

		$(function() {
			search(1);
			$("#inputResult").hide();
			$("#index-page-title").html("学员管理");
			$("#current-page-title").html("学员管理");
		});
	</script>
</div>