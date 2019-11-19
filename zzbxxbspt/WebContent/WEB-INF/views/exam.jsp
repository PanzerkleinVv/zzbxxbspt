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
							<input type="number" id="examTime" name="examTime" placeholder="个人答题时长限制（分钟）" min='0' class="form-control placeholder-no-fix" autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							考试总分：<i>*</i>
						</span>
						<span>
							<input type="number" id="examScore" name="examScore" placeholder="考试总分" min='0' class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							出题规则：
						</span>
						<span>
							（设置每份试卷格式试题的数量，没有请填0。注意数量不要超过题库总数，且题目总分应与试卷总分一致。）
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							判断题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examTf" name="examTf" min='0' placeholder="试卷随机生成判断题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examTfScore" name="examTfScore" min='0' placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							单选题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examSc" name="examSc" min='0' placeholder="试卷随机生成单选题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examScScore" name="examScScore" min='0' placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
				</div>
				<div class="formLine">
					<div class="formDiv">
						<span>
							多选题数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examMc" name="examMc" min='0' placeholder="试卷随机生成多选题数" class="form-control placeholder-no-fix" required autocomplete="off" />
						</span>
					</div>
					<div class="formDiv">
						<span>
							每题分数：<i>*</i>
						</span>
						<span>
							<input type="number" id="examMcScore" name="examMcScore" min='0' placeholder="每题分数" class="form-control placeholder-no-fix" required autocomplete="off" />
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

		$("#closeExam").click(function(target) {
			dialogueClose("examInfo");
		});

		$("#saveExam").click(function(target) {
			var sorce = $("#examSorce").val();
			var sorce0 = $("#examTf").val() * $("#examTfSorce").val();
			var sorce1 = $("#examSc").val() * $("#examScSorce").val();
			var sorce2 = $("#examMc").val() * $("#examMcSorce").val();
			if (sorce = (sorce0 + sorce1 + sorce2)) {
				$("form#examForm").submit();
			} else {
				layer.msg("题目总分应与试卷总分一致", {
					time : 2000
				});
			}
		});

		$("#deleteExam").click(function(target) {
			var url = "rest/exam/delete";
			$.getJSON(url, {
				'examId' : $("#examId").val(),
				'examTitle' : $("#examTitle").val()
			}, function(data) {
				dialogueClose("examInfo");
				search(1);
				layer.msg(data.content, {
					time : 2000
				});
			});
		});

		$(function() {
			$("form#examForm.needs-validation").validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						type : 'post',
						url : "rest/exam/edit",
						dataType : "json",
						success : function(result) { //表单提交后更新页面显示的数据
							dialogueClose("examInfo");
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
			search(1);
			var url = 'rest/question/getCount';
			$.getJSON(url, function(data) {
				$("#examTf").attr("max", data[0]);
				$("#examSC").attr("max", data[1]);
				$("#examMc").attr("max", data[2]);
			});
			$("#inputResult").hide();
			$("#index-page-title").html("试卷定制");
			$("#current-page-title").html("试卷定制");
		});
	</script>
</div>