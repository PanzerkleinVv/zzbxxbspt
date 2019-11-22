<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="questionName" id="questionNameSearch" size="25" class="form-control placeholder-no-fix searchBox" type="text" autocomplete="off" placeholder="查找题目" />
			<button id="searchBut" type="button" class="btn blue">查询</button>
			<button id="createBut" type="button" class="btn green">新增</button>
			<button id="inputBut" type="button" class="btn green">批量导入</button>
		</form>
	</div>
	<div id="countQuestion"></div>
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
							<input type="text" id="answerContentA" name="answers[0].answerContent" placeholder="选项A" class="form-control placeholder-no-fix answerContent" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceA" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled" />
							<input type="hidden" id="answerTypeA" name="answers[0].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项B：<i>*</i>
						</span>
						<span>
							<input type="text" id="answerContentB" name="answers[1].answerContent" placeholder="选项B" class="form-control placeholder-no-fix answerContent" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceB" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled" />
							<input type="hidden" id="answerTypeB" name="answers[1].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项C：
						</span>
						<span>
							<input type="text" id="answerContentC" name="answers[2].answerContent" placeholder="选项C" class="form-control placeholder-no-fix answerContent" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceC" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeC" name="answers[2].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项D：
						</span>
						<span>
							<input type="text" id="answerContentD" name="answers[3].answerContent" placeholder="选项D" class="form-control placeholder-no-fix answerContent" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceD" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled"/>
							<input type="hidden" id="answerTypeD" name="answers[3].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项E：
						</span>
						<span>
							<input type="text" id="answerContentE" name="answers[4].answerContent" placeholder="选项E" class="form-control placeholder-no-fix answerContent" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceE" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled" />
							<input type="hidden" id="answerTypeE" name="answers[4].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							选项F：
						</span>
						<span>
							<input type="text" id="answerContentF" name="answers[5].answerContent" placeholder="选项F" class="form-control placeholder-no-fix answerContent" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							正确答案：
						</span>
						<span>
							<input type="radio" id="answerTypeChoiceF" name="answerTypeChoice" class="form-control placeholder-no-fix answerTypeChoice" autocomplete="off" disabled="disabled" />
							<input type="hidden" id="answerTypeF" name="answers[5].answerType" placeholder="正确答案" class="form-control placeholder-no-fix" autocomplete="off" disabled="disabled" />
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
							<a href="rest/question/template" target="_blank">题目批量导入模版.xls</a>
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
						<span class="userItem2">类型</span>
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
			dialogueOpen("questionInput");
			$("#inputResult .userHeader").nextAll().remove();
			$("#uploadAllQuestion").hide();
		});

		function search(pageNo) {
			var url = 'rest/question/search';
			$.getJSON(url, {
					'pageNo' : pageNo,
					'questionContent' : $("#questionContentSearch").val()
				}, function(data) {
					countQuestion();
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
				$("#questionType").val("").trigger('change');
				$("#questionContent").val("");
				$("#answerContentA").val("").trigger('change');
				$("#answerContentB").val("").trigger('change');
				$("#answerContentC").val("").trigger('change');
				$("#answerContentD").val("").trigger('change');
				$("#answerContentE").val("").trigger('change');
				$("#answerContentF").val("").trigger('change');
			} else {
				var url = 'rest/question/info';
				$("#deleteQuestion").show();
				$.getJSON(url, {
					'questionId' : questionId
				}, function(data) {
					$("#questionId").val(data.questionId);
					$("#questionType").val(data.questionType).trigger('change');
					$("#questionContent").val(data.questionContent);
					$.each(data.answers, function(i, n) {
						var idFlag;
						switch(n.answerOrder) {
						case 1:
							idFlag = "A";
							break;
						case 2:
							idFlag = "B";
							break;
						case 3:
							idFlag = "C";
							break;
						case 4:
							idFlag = "D";
							break;
						case 5:
							idFlag = "E";
							break;
						case 6:
							idFlag = "F";
							break;
						}
						$("#answerContent" + idFlag).val(n.answerContent).trigger('change');
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
		
		$("#questionType").change(function() {
			var value = $("#questionType").val();
			switch (value) {
			case '0':
				$("#answerContentA").val("正确").trigger('change');
				$("#answerContentB").val("错误").trigger('change');
				$("#answerContentA").attr("readonly", true);
				$("#answerContentB").attr("readonly", true);
				$("#answerContentC").attr("disabled", true);
				$("#answerContentC").val("").trigger('change');
				$("#answerContentD").attr("disabled", true);
				$("#answerContentD").val("").trigger('change');
				$("#answerContentE").attr("disabled", true);
				$("#answerContentE").val("").trigger('change');
				$("#answerContentF").attr("disabled", true);
				$("#answerContentF").val("").trigger('change');
				$.each($(".answerTypeChoice"), function(i, n) {
					$(n).attr("type", "radio");
					$(n).attr("checked", false);
				});
				break;
			case '1':
				$("#answerContentA").val("").trigger('change');
				$("#answerContentB").val("").trigger('change');
				$("#answerContentA").attr("readonly", false);
				$("#answerContentB").attr("readonly", false);
				$("#answerContentC").attr("disabled", false);
				$("#answerContentC").attr("disabled", false);
				$("#answerContentC").val("").trigger('change');
				$("#answerContentD").attr("disabled", false);
				$("#answerContentD").val("").trigger('change');
				$("#answerContentE").attr("disabled", false);
				$("#answerContentE").val("").trigger('change');
				$("#answerContentF").attr("disabled", false);
				$("#answerContentF").val("").trigger('change');
				$.each($(".answerTypeChoice"), function(i, n) {
					$(n).attr("type", "radio");
					$(n).attr("checked", false);
				});
				break;
			case '2':
				$("#answerContentA").val("").trigger('change');
				$("#answerContentB").val("").trigger('change');
				$("#answerContentA").attr("readonly", false);
				$("#answerContentB").attr("readonly", false);
				$("#answerContentC").attr("disabled", false);
				$("#answerContentC").attr("disabled", false);
				$("#answerContentC").val("").trigger('change');
				$("#answerContentD").attr("disabled", false);
				$("#answerContentD").val("").trigger('change');
				$("#answerContentE").attr("disabled", false);
				$("#answerContentE").val("").trigger('change');
				$("#answerContentF").attr("disabled", false);
				$("#answerContentF").val("").trigger('change');
				$.each($(".answerTypeChoice"), function(i, n) {
					$(n).attr("type", "checkbox");
					$(n).attr("checked", false);
				});
				break;
			}
		});
		
		$(".answerContent").change(function() {
			var idFlag = $(this).attr("id").substr(13, 14);
			$("#answerTypeChoice" + idFlag).attr("checked", false);
			if ($(this).val() == "") {
				$("#answerTypeChoice" + idFlag).attr("disabled", true);
				$("#answerType" + idFlag).attr("disabled", true);
				$("#answerType" + idFlag).val("0");
			} else {
				$("#answerTypeChoice" + idFlag).attr("disabled", false);
				$("#answerType" + idFlag).attr("disabled", false);
			}
		});
		
		$("#saveQuestion").click(function(target) {
			var flag = false;
			var count = 0;
			$.each($(".answerTypeChoice:checked"), function (i, n) {
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
					$.each($(".answerTypeChoice"), function (i, n) {
						$(n).attr("disabled", true);
						if ($(n).prop('checked')) {
							$(n).next().val(1);
						} else {
							$(n).next().val(0);
						}
					});
					$("form#questionForm").submit();
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
		
		$("#uploadAllQuestion").click(function() {
			$('form#inputForm').submit();
		});

		$(function() {
			$("form#uploadForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/question/input",
						dataType : "json",
						success : function(result) {
							if (result.flag) {
								$("#inputResult").show();
								$("#inputResult .userHeader").nextAll().remove();
								$.each(result.object,function(i, n) {
									$("#inputResult").append('<div class="userRow" id="input' + i + '"><span class="userItem2"><input type="hidden" name="questions[' + i + '].questionType" /></span>'
										+ '<span class="userItem8">'
										+ '<input type="hidden" name="questions[' + i + '].questionContent" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[0].answerContent" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[0].answerType" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[1].answerContent" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[1].answerType" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[2].answerContent" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[2].answerType" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[3].answerContent" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[3].answerType" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[4].answerContent" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[4].answerType" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[5].answerContent" disabled="true" />'
										+ '<input type="hidden" name="questions[' + i + '].answers[5].answerType" disabled="true" />'
										+ '</span></div>');
									$("input[name='questions[" + i + "].questionType']").val(n.questionType);
									$("input[name='questions[" + i + "].questionType']").parent().append((n.questionType == 0 ? "判断题" : (n.questionType == 1 ? "单选题" : "多选题")));
									$("input[name='questions[" + i + "].questionContent']").val(n.questionContent);
									$("input[name='questions[" + i + "].questionContent']").parent().append(n.questionContent);
									$.each($(n.answers), function(j, m) {
										var orderFlag = "";
										switch(m.answerOrder) {
										case 1:
											orderFlag = "A";
											break;
										case 2:
											orderFlag = "B";
											break;
										case 3:
											orderFlag = "C";
											break;
										case 4:
											orderFlag = "D";
											break;
										case 5:
											orderFlag = "E";
											break;
										case 6:
											orderFlag = "F";
											break;
										}
										$("input[name='questions[" + i + "].answers[" + j + "].answerType']").val(m.answerType);
										$("input[name='questions[" + i + "].answers[" + j + "].answerType']").attr("disabled", false);
										$("input[name='questions[" + i + "].answers[" + j + "].answerContent']").val(m.answerContent);
										$("input[name='questions[" + i + "].answers[" + j + "].answerContent']").attr("disabled", false);
										$("input[name='questions[" + i + "].answers[" + j + "].answerContent']").parent().append("<br/>" + orderFlag + "：" + m.answerContent + (m.answerType == 1 ? '&emsp;（正确答案）' : ''));
									});
								});
								$("form#inputForm.needs-validation").validate({
									submitHandler : function(form) {
										$(form).ajaxSubmit({
											type : 'post',
											url : "rest/question/saveAll",
											dataType : "json",
											success : function(result) {
												if (result.flag) {
													search(1);
												}
												layer.msg(result.content, {
													time : 2000
												});
												$("#inputResult .userHeader").nextAll().remove();
												$("#uploadAllQuestion").hide();
											},
											error : function(){
												layer.msg("保存出错", {
													time : 2000
												});
											}
										});
									}
								});
								$("#uploadAllQuestion").show();
								layer.msg(result.content, {
									time : 2000
								});
							} else {
								$("#inputResult .userHeader").nextAll().remove();
								$("#uploadAllQuestion").hide();
								layer.msg(result.content, {
									time : 2000
								});
							}
						},
						error : function(){
							$("#inputResult .userHeader").nextAll().remove();
							$("#uploadAllQuestion").hide();
							layer.msg("Excle解析出错", {
								time : 2000
							});
						}
					});
				}
			});
		});
		
		function examNotExist() {
			var url = 'rest/exam/examNotExist';
			$.getJSON(url, function(data) {
				examNotExistFlag = data.flag;
				examNotExistMessage = data.content;
			});
		}
		
		function countQuestion() {
			var url = 'rest/question/getCount';
			$.getJSON(url, function(data) {
				$("#countQuestion").html("判断题" + data[0] + "道、单选题" + data[1] + "道、多选题" + data[2] + "道");
			});
		}

		$(function() {
			examNotExist();
			search(1);
			$("#inputResult").hide();
			$("#index-page-title").html("试题管理");
			$("#current-page-title").html("试题管理");
		});
	</script>
</div>