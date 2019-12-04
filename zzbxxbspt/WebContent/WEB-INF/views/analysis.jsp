<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="mainContent">
	<div class="userTable" id="exams">
		<div class="userRow userHeader">
			<span class="userItem7">试卷标题</span>
			<span class="userItem6">操作</span>
		</div>
	</div>
	<div class="mask"></div>
	<div id="rankDialogue" class="dialogueBox">
		<div class="dialogueHeader">
			<span>分数排名</span>
			<span class="dialogueClose">
				<i class="fa fa-window-close"></i>
			</span>
		</div>
		<div class="dialogueBody">
			<div class="userTable" id="rank">
				<div class="userRow userHeader">
					<span class="userItem6">排名</span>
					<span class="userItem5">姓名（单位）</span>
					<span class="userItem6">分数</span>
				</div>
			</div>
		</div>
		<div class="dialogueFooter">
		</div>
	</div>

	<script type="text/javascript">

		function exams() {
			var url = 'rest/analysis/exams';
			$.getJSON(url, function(data) {
					$("#exams .userHeader").nextAll().remove();
					$.each(data, function(i, n) {
							$("#exams").append('<div class="userRow"><span class="userItem7">'
									+ n.examTitle
									+ '</span><span class="userItem6"><button type="button" class="btn blue" onclick="rank(\''
									+ n.examId
									+ '\')">分数排名</button></span></div>');
					});
			});
		}

		function rank(examId) {
			var url = 'rest/analysis/rank';
			$.getJSON(url, {
				'examId' : examId
			}, function(data) {
				$("#rank .userHeader").nextAll().remove();
				var rank;
				var score;
				$.each(data, function(i, n) {
					$("#rank").append('<div class="userRow"><span class="userItem5">'
							+ (n.paperScore == score ? "（并列）" : (i + 1))
							+ '</span><span class="userItem6">'
							+ n.userName + '（' + n.userDesc + '）'
							+ '</span><span class="userItem5">'
							+ n.paperScore
							+ '</span></div>');
					if (n.paperScore != score) {
						rank = i;
						score = n.paperScore;
					}
				});
			});
			dialogueOpen("rankDialogue");
		}

		$(".dialogueClose").click(function(target) {
			dialogueClose($(this).parent().parent().attr("id"));
		});
		
		$(function() {
			exams();
			$("#inputResult").hide();
			$("#index-page-title").html("分数统计");
			$("#current-page-title").html("分数统计");
		});
	</script>
</div>