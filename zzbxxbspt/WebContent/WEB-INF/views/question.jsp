<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="questionName" id="questionNameSearch" size="25" class="form-control placeholder-no-fix searchBox" type="text" autocomplete="off" placeholder="查找题目" />
			<button id="searchBut" type="button" class="btn blue">查询</button>
			<button id="createBut" type="button" class="btn green">新增</button>
			<button id="inputBut" type="button" class="btn green">批量导入</button>
		</form>
	</div>
	<div class="userTable" id="searchResult">
		<div class="userRow userHeader">
			<span class="userItem2">题目类型</span>
			<span class="userItem7">题目</span>
			<span class="userItem2">操作</span>
		</div>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo" />
	</div>
	<div class="mask"></div>
	<div id="questionInfo" class="dialogueBox">
		<div class="dialogueHeader">
			<span>题目信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<form id="questionForm" class="needs-validation">
				<div class="formLine">
					<div class="formDiv">
						<span>
							题目类型：<i>*</i>
						</span>
						<input type="hidden" id="questionId" name="questionId" />
						<span>
							<select id="questionType" name="questionType" class="form-control placeholder-no-fix" required>
								<option value="0">判断题</option>
								<option value="1">单选题</option>
								<option value="2">多选题</option>
							</select>
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							题目：<i>*</i>
						</span>
						<span>
							<textarea id="questionContent" name="questionContent" placeholder="请输入题目" class="form-control placeholder-no-fix" required autocomplete="off">
							</textarea>
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项A：<i>*</i>
						</span>
						<span>
							<input type="text" id="answerContentA" name="answerContent" placeholder="选项A" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceA" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" />
							<input type="hidden" id="answerTypeA" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项B：<i>*</i>
						</span>
						<span>
							<input type="text" id="answerContentB" name="answerContent" placeholder="选项B" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceB" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" />
							<input type="hidden" id="answerTypeB" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项C：
						</span>
						<span>
							<input type="text" id="answerContentC" name="answerContent" placeholder="选项C" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceC" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeC" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项D：
						</span>
						<span>
							<input type="text" id="answerContentD" name="answerContent" placeholder="选项D" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceD" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeD" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项E：
						</span>
						<span>
							<input type="text" id="answerContentE" name="answerContent" placeholder="选项E" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceE" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeE" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项F：
						</span>
						<span>
							<input type="text" id="answerContentF" name="answerContent" placeholder="选项F" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceF" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeF" name="answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<button id="saveQuestion" type="button" class="btn blue">保存</button>
			<button id="deleteQuestion" type="button" class="btn red">删除</button>
			<button id="closeQuestion" type="button" class="btn gray">取消</button>
		</div>
	</div>
	<div id="questionInput" class="dialogueBox">
		<div class="dialogueHeader">
			<span>批量导入题目信息</span>
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
							<a href="rest/user/template" target="_blank">题目批量导入模版.xls</a>
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
						<span class="userItem2">题目类型</span>
						<span class="userItem8">题目与答案</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<div id="uploadFooter">
				<button id="uploadAllQuestion" type="button" class="btn blue">全部保存</button>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var examNotExistFlag = true;
		var examNotExistMessage = ""
	
		$('#searchBut').click(function() {
			search(1);
		});

		$('#createBut').click(function() {
			edit(0);
		});

		$('#inputBut').click(function() {
			dialogueOpen("userInput");
			$("#inputResult .userHeader").nextAll().remove();
			$("#uploadAllQuestion").hide();
		});

		function search(pageNo) {
			var url = 'rest/question/search';
			$.getJSON(url, {
					'pageNo' : pageNo,
					'questionContent' : $("#questionContentSearch").val()
				}, function(data) {
					setPage(data, $(".pageBox"), $("#pageNo"));
					$("#searchResult .userHeader").nextAll().remove();
					$.each(data.result,function(i, n) {
						$("#searchResult").append('<div class="userRow"><span class="userItem2">'
							+ (n.questionType == 0 ? '判断题' : (n.questionType == 1 ? '单选题' : '多选题'))
							+ '</span><span class="userItem7">'
							+ n.questionContent
							+ '</span><span class="userItem2"><button type="button" class="btn blue" onclick="edit(\''
							+ n.questionId
							+ '\')">修改</button></span></div>');
					});
			});
		}

		function edit(questionId) {
			if (questionId == 0) {
				$("#deleteQuestion").hide();
				$("#questionId").val("");
				$("#questionType").val("");
				$("#questionContent").val("");
				$("#answerContentA").val("");
				$("#answerTypeA").val("");
				$("#answerTypeChoiceA").val("");
				$("#answerContentB").val("");
				$("#answerTypeB").val("");
				$("#answerTypeChoiceB").val("");
				$("#answerContentC").val("");
				$("#answerTypeC").val("");
				$("#answerTypeChoiceC").val("");
				$("#answerContentD").val("");
				$("#answerTypeD").val("");
				$("#answerTypeChoiceD").val("");
				$("#answerContentE").val("");
				$("#answerTypeE").val("");
				$("#answerTypeChoiceE").val("");
				$("#answerContentF").val("");
				$("#answerTypeF").val("");
				$("#answerTypeChoiceF").val("");
			} else {
				var url = 'rest/question/info';
				$("#deleteQuestion").show();
				$.getJSON(url, {
					'questionId' : questionId
				}, function(data) {
					$("#questionId").val(data.questionId);
					$("#questionType").val(data.questionType);
					$("#questionContent").val(data.questionContent);
					$.each(data.answers, function(i, n) {
						var idFlag;
						switch(n.answerOrder) {
						case 1:
							idFlag = "A";
						case 2:
							idFlag = "B";
						case 3:
							idFlag = "C";
						case 4:
							idFlag = "D";
						case 5:
							idFlag = "E";
						case 6:
							idFlag = "F";
						}
						$("#answerContent" + idFlag).val(n.answerContent);
						if (n.answerType == 1) {
							$("#answerTypeChoice" + idFlag).attr('checked', true);
						} else {
							$("#answerTypeChoice" + idFlag).attr('checked', false);
						}
						$("#answerType" + idFlag).val(n.answerType);
						$("#answerTypeChoice" + idFlag).attr("disabled", false);
					});
				});
			}
			dialogueOpen("questionInfo");
		}

		$(".dialogueClose").click(function(target) {
			dialogueClose($(this).parent().parent().attr("id"));
		});

		$("#closeQuestion").click(function(target) {
			dialogueClose("questionInfo");
		});

		$("#saveQuestion").click(function(target) {
			$("form#questionForm").submit();
		});

		$("#deleteQuestion").click(function(target) {
			var url = "rest/question/delete";
			$.getJSON(url, {
				'questionId' : $("#questionId").val(),
				'questionContent' : $("#questionContent").val()
			}, function(data) {
				dialogueClose("questionInfo");
				search(1);
				layer.msg(data.content, {
					time : 2000
				});
			});
		});
		
		$("#saveQuestion").click(function(target) {
			var flag = false;
			var count = 0;
			$.each($(".answerTypeChoice:checked'"), function (i, n) {
				count++;
			});
			if ($("#questionType").val() == "0" || $("#questionType").val() == "1") {
				if (count == 1) {
					flag = true;
				}
			} else if ($("#questionType").val() == "2") {
				if (count > 1) {
					flag = true;
				}
			}
			if (flag) {
				if (examNotExistFlag) {
					$.each($(".answerTypeChoice'"), function (i, n) {
						$(n).attr("disabled", true);
					});
					$("form#inputForm").submit();
				} else {
					layer.msg(examNotExistMessage, {
						time : 2000
					});
					return;
				}
			} else {
				layer.msg("单选题和判断题只能有一个正确答案，多选题至少有两个正确答案", {
					time : 2000
				});
				return;
			}
		});

		$(function() {
			$("form#questionForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/question/edit",
						dataType : "json",
						success : function(result) { //表单提交后更新页面显示的数据
							dialogueClose("questionInfo");
							search(1);
							layer.msg(result.content, {
								time : 2000
							});
						}
					});
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
										+ '<input type="hidden" name="users[' + i + '].userName" class="inputUserName" />'
										+ '</span><span class="userItem3">'
										+ '<input type="hidden" name="users[' + i + '].userDesc" class="inputUserDesc" />'
										+ '</span><span class="userItem3">'
										+ '<input type="hidden" name="users[' + i + '].userPsw" class="inputUserPsw" />'
										+ '</span><span class="userItem4"><input type="hidden" name="inputFlag" class="inputFlag" value="0"/></span></div>');
									$("#input" + i + " input.inputUserName").val(n.userName);
									$("#input" + i + " input.inputUserName").parent().append($("#input" + i + " input.inputUserName").val());
									$("#input" + i + " input.inputUserDesc").val(n.userDesc);
									$("#input" + i + " input.inputUserDesc").parent().append($("#input" + i + " input.inputUserDesc").val());
									$("#input" + i + " input.inputUserPsw").val(n.userPsw);
									$("#input" + i + " input.inputUserPsw").parent().append($("#input" + i + " input.inputUserPsw").val());
									$("#input" + i + " input.inputFlag").val(n.message.flag ? 0 : 1);
									if (n.message.flag) {
										$("#input" + i + " input.inputFlag").parent().append("可保存");
										$("#input" + i + " input.inputFlag").parent().addClass("green");
									} else {
										$("#input" + i + " input.inputFlag").parent().append("错误项");
										$("#input" + i + " input.inputFlag").parent().parent().attr("title", n.message.content);
										$("#input" + i + " input.inputFlag").parent().addClass("red");
									}
								});
								$("form#inputForm.needs-validation").validate({
									submitHandler : function(form) {
										$(form).ajaxSubmit({
											type : 'post',
											url : "rest/user/saveAll",
											dataType : "json",
											success : function(result) {
												if (result.flag) {
													search(1);
												}
												layer.msg(result.content, {
													time : 2000
												});
												$("#inputResult .userHeader").nextAll().remove();
												$("#uploadAllUser").hide();
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
		
		function examNotExist() {
			var url = 'rest/exam/examNotExist';
			$.getJSON(url, function(data) {
				examNotExistFlag = data.flag;
				examNotExistMessage = data.content;
			});
		}

		$(function() {
			examNotExist();
			search(1);
			$("#inputResult").hide();
			$("#index-page-title").html("学员管理");
			$("#current-page-title").html("学员管理");
		});
	</script>
</div>