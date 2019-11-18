<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="">
		<form action="" method="post">
			<input name="examTitle" id="examTitleSearch" size="25" class="form-control placeholder-no-fix searchBox" type="text" autocomplete="off" placeholder="查找考试" />
			<button id="searchBut" type="button" class="btn blue">查询</button>
			<button id="createBut" type="button" class="btn green">新增</button>
		</form>
	</div>
	<div class="userTable" id="searchResult">
		<div class="userRow userHeader">
			<span class="userItem5">试卷标题</span>
			<span class="userItem6">状态</span>
			<span class="userItem6">操作</span>
		</div>
	</div>
	<div class="pageBox">
		<input type="hidden" id="pageNo" />
	</div>
	<div class="mask"></div>
	<div id="examInfo" class="dialogueBox">
		<div class="dialogueHeader">
			<span>试卷信息</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<form id="examForm" class="needs-validation">
				<div class="formLine">
					<div class="formDiv">
						<span>
							试卷标题：<i>*</i>
						</span>
						<input type="hidden" id="examId" name="examId" />
						<span>
							<input type="text" id="examTitle" name="examTitle" placeholder="试卷标题" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							开始时间：<i>*</i>
						</span>
						<span>
							<input type="text" id="examBegin" name="examBegin" placeholder="开始答题的时间" readonly class="form_date form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							截止时间：<i>*</i>
						</span>
						<span>
							<input type="text" id="examEnd" name="examEnd" placeholder="停止答题的时间" readonly class="form_date form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							限制时长（分钟）：
						</span>
						<span>
							<input type="number" id="examTime" name="examTime" placeholder="个人答题时长限制（分钟）" class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							考试总分：<i>*</i>
						</span>
						<span>
							<input type="number" id="examScore" name="examScore" placeholder="考试总分" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							判断题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examTf" name="examTf" placeholder="试卷随机生成判断题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examTfScore" name="examTfScore" placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							单选题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examSc" name="examSc" placeholder="试卷随机生成单选题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examScScore" name="examScScore" placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							多选题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examMc" name="examMc" placeholder="试卷随机生成多选题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examMcScore" name="examMcScore" placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="dialogueFooter">
			<button id="saveExam" type="button" class="btn blue">保存</button>
			<button id="deleteExam" type="button" class="btn red">删除</button>
			<button id="closeExam" type="button" class="btn gray">取消</button>
		</div>
	</div>

	<script type="text/javascript">
		$(".form_date").datepicker({
			format : 'yyyy-mm-dd hh:ii:ss',
			language : 'zh-CN'
		});
		
		$('#searchBut').click(function() {
			search(1);
		});

		$('#createBut').click(function() {
			edit(0);
		});

		function search(pageNo) {
			var url = 'rest/exam/search';
			$.getJSON(url,{
					'pageNo' : pageNo,
					'examTitle' : $("#examTitleSearch").val()
				}, function(data) {
					setPage(data, $(".pageBox"), $("#pageNo"));
					$("#searchResult .userHeader").nextAll().remove();
					$.each(data.result,function(i, n) {
							$("#searchResult").append('<div class="userRow"><span class="userItem5">'
									+ n.examTitle
									+ '</span><span class="userItem6">'
									+ (Date.now() < n.examBegin ? "未开始" : (Date.now() > n.examEnd ? "已结束" : "进行中"))
									+ '</span><span class="userItem6"><button type="button" class="btn blue" onclick="edit(\''
									+ n.examId
									+ '\')">修改</button></span></div>');
					});
			});
		}

		function edit(examId) {
			if (examId == 0) {
				$("#deleteExam").hide();
				$("#examId").val("");
				$("#examTitle").val("");
				$("#examBegin").val("");
				$("#examEnd").val("");
				$("#examTime").val("");
				$("#examScore").val("");
				$("#examTf").val("");
				$("#examTfScore").val("");
				$("#examSc").val("");
				$("#examScScore").val("");
				$("#examMc").val("");
				$("#examMcScore").val("");
			} else {
				var url = 'rest/exam/info';
				$("#deleteExam").show();
				$.getJSON(url, {
					'examId' : examId
				}, function(data) {
					$("#examId").val(data.examId);
					$("#examTitle").val(data.examTitle);
					$("#examBegin").datepicker("update", new Date(data.examBegin));
					$("#examEnd").datepicker("update", new Date(data.examEnd));
					$("#examTime").val(data.examTime);
					$("#examScore").val(data.examScore);
					$("#examTf").val(data.examTf);
					$("#examTfScore").val(data.examTfScore);
					$("#examSc").val(data.examSc);
					$("#examScScore").val(data.examScScore);
					$("#examMc").val(data.examMc);
					$("#examMcScore").val(data.examMcScore);
				});
			}
			dialogueOpen("examInfo");
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
			$("#index-page-title").html("试卷定制");
			$("#current-page-title").html("试卷定制");
		});
	</script>
</div>