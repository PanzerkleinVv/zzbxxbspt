<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="mainContent">
	<div id="examList">
		<div class="examRow examHeader">
			<span>竞赛项目</span>
			<span>参与时间</span>
			<span>答题限时</span>
			<span>参与状态</span>
		</div>
	</div>
	<div id="paper"></div>
</div>

<script type="text/javascript">
	function getMyExamList() {
		var url = "rest/paper/list"
		$.getJSON(url, function(data) {
			$("#examList").show();
			$("#paper").hide();
			$(".examHearder").nextAll().remove();
			$.each(data, function(i, n) {
				$("#examList").append('<div class="examRow">'
						+ '<span>' + n.examTitle + '</span>'
						+ '<span>' + new Date(n.examBegin).format("yyyy-MM-dd") + ' ' + new Date(n.examBegin).format("hh:mm:ss") + '&emsp;至&emsp;' + new Date(n.examEnd).format("yyyy-MM-dd") + ' ' + new Date(n.examEnd).format("hh:mm:ss") + '</span>'
						+ '<span>' + (n.examTime != null ? n.examTime + '分钟' : '无') + '</span>'
						+ '<span>' + (n.paperId == null ? ((n.examBegin > Date.now()) ? '未开始' : ((n.examEnd < Date.now()) ? '已结束' : '可参与')) : (n.paperScore == null ? ('剩余时间：' + (n.examTime - Math.round((Date.now() - n.paperBegin) / 60000)) + '分钟') : ('得分：' + n.paperScore))) + '</span>'
						+ '<span>'
						+ '1、试卷满分：' + n.examScore + '分；<br/>'
						+ '2、'
						+ (n.examTf != 0 ? '判断题' + n.examTf + '道，每题' + n.examTfScore + '分；' : '')
						+ (n.examSc != 0 ? '单选题' + n.examSc + '道，每题' + n.examScScore + '分；' : '')
						+ (n.examMc != 0 ? '多选题' + n.examMc + '道，每题' + n.examMcScore + '分；' : '')
						+ '<br/>'
						+ (n.examTime != null ? '3、答题限时' + n.examTime + '分钟，<b>离线计时</b>，超过规定时间将自动交卷；<br/>' : '')
						+ (n.paperId == null ? ((n.examBegin > Date.now()) ? '' : ((n.examEnd < Date.now()) ? '' : '<button class="green btn" onclick="newPaper(\'' + n.examId + '\')">我已阅读竞赛规则，开始答题</button>')) : (n.paperScore == null ? ('<button class="green btn" onclick="goPaper(\'' + n.paperId + '\')">继续答题</button>') : ''))
						+ '</span>'
						+ '</div>');
			});
			$(".examRow:not(.examHeader) span:not(:last-child)").click(function() {
				var row = $(this).parent();
				$.each($(".examRow:not(.examHeader)"), function(i, n) {
					if (n == row[0]) {
						row.find("span:last-child").slideDown(200);
					} else {
						$(n).find("span:last-child").slideUp(200);
					}
				});
			});
		});
	}
	
	function newPaper(examId) {
		var url = "rest/paper/paper";
		$.getJSON(url, {'examId' : examId}, function(data) {
			showPaper(data);
		});
	}
	
	function goPaper(paperId) {
		var url = "rest/paper/paper";
		$.getJSON(url, {'paperId' : paperId}, function(data) {
			showPaper(data);
		});
	}
	
	function showPaper(data) {
		$("#examList").hide();
		$("#paper").show();
		console.log(data);
		$("#paper").html('<div>' + data.exam.examTitle + '</div>');
		$("#paper").append('<div><span>剩余时间</span></div>');
	}

	$(function() {
		getMyExamList();
		$("#index-page-title").html("答题");
		$("#current-page-title").html("答题");
	});
</script>