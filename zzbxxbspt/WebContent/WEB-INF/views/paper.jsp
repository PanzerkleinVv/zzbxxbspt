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
						+ '<span>' + (n.paperId == null ? ((n.examBegin > Date.now()) ? '未开始' : ((n.examEnd < Date.now()) ? '已结束' : '可参与')) : (n.paperScore == null ? (n.examTime != null ? ('剩余时间：' + (n.examTime - Math.round((Date.now() - n.paperBegin) / 60000)) + '分钟') : '进行中') : ('得分：' + n.paperScore))) + '</span>'
						+ '<span>'
						+ '1、试卷满分：' + n.examScore + '分；<br/>'
						+ '2、'
						+ (n.examTf != 0 ? '判断题' + n.examTf + '道，每题' + n.examTfScore + '分；' : '')
						+ (n.examSc != 0 ? '单选题' + n.examSc + '道，每题' + n.examScScore + '分；' : '')
						+ (n.examMc != 0 ? '多选题' + n.examMc + '道，每题' + n.examMcScore + '分；' : '')
						+ '<br/>'
						+ (n.examTime != null ? '3、答题限时' + n.examTime + '分钟，<b>离线计时</b>，超过规定时间将自动交卷；<br/>' : '')
						+ (n.paperId == null ? ((n.examBegin > Date.now()) ? '' : ((n.examEnd < Date.now()) ? '' : '<button class="green btn" onclick="newPaper(\'' + n.examId + '\')">我已阅读竞赛规则，开始答题</button>')) : (n.paperScore == null && ((n.examTime - Math.round((Date.now() - n.paperBegin) / 60000)) > -1 || Date.now() < n.examEnd) ? ('<button class="green btn" onclick="goPaper(\'' + n.paperId + '\')">继续答题</button>') : ''))
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
		$("#paper").html('<div id="paperHeader"><span>' + data.exam.examTitle + '</span><span>剩余时间</span><span id="countdown"></span></div>');
		$(function() {
		    config = {
		        timeText: (data.exam.examTime != null ? (new Date(data.paperBegin + (data.exam.examTime * 60000)).format("yyyy/MM/dd hh:mm:ss")) : (new Date(data.exam.examEnd).format("yyyy/MM/dd hh:mm:ss"))), //倒计时时间，格式：年/月/日 时:分:秒
		        timeZone:'8' , //时区，GMT号码
		        style: "slide", //显示的样式，可选值有flip,slide,metal,crystal(翻动、滑动、金属、水晶)
		        color: "white", //显示的颜色，可选值white,black(黑色、白色)
		        width: '200px', //倒计时宽度，无限制，默认为0
		        textGroupSpace: 15, //天、时、分、秒之间间距
		        textSpace: 0, //数字之间间距
		        reflection: 0, //是否显示倒影
		        dayTextNumber: 2, //倒计时天数数字个数
		        displayDay: !0, //是否显示天数
		        displayHour: !0, //是否显示小时数
		        displayMinute: !0, //是否显示分钟数
		        displaySecond: !0, //是否显示秒数
		        displayLabel: 0, //是否显示倒计时底部label
		        onFinish: function() {
		        	submitPaper();
		        }//完成事件，您可以在时间结束时执行一些脚本，在创建倒计时时只需传递一个函数即可。
		    };
		    $("#countdown").jCountdown(config);
		});
		$("#paper").append('<ul type="一" id="paperBody"><form id="paperForm"></form></ul>');
		if (data.exam.examTf != 0) {
			$("#paperForm").append('<li class="paperQuestionType">判断题：（共' + data.exam.examTf + '小题，每题' + data.exam.examTfScore + '分）<ol id="tf" class="paperQuestionOl" type="1" start="1"></ol></li>');
		}
		if (data.exam.examSc != 0) {
			$("#paperForm").append('<li class="paperQuestionType">单选题：（共' + data.exam.examSc + '小题，每题' + data.exam.examScScore + '分）<ol id="sc" class="paperQuestionOl" type="1" start="' + (data.exam.examTf + 1) + '"></ol></li>');
		}
		if (data.exam.examMc != 0) {
			$("#paperForm").append('<li class="paperQuestionType">多选题：（共' + data.exam.examMc + '小题，每题' + data.exam.examMcScore + '分，多选、少选、错选均不得分）<ol id="mc" class="paperQuestionOl" type="1" start="' + (data.exam.examTf + data.exam.examSc + 1) + '"></ol></li>');
		}
		$.each(data.paperQuestion, function(i, n) {
			if (n.questionType == 0) {
				$("#tf").append('<li class="paperQuestionLine">' + n.questionContent + '<input type="hidden" name="paperQuestions[' + i + '].id" value="' + n.id + '" /><ul id="_' + n.id + '" class="answerOl"></ol></li>');
			} else if (n.questionType == 1) {
				$("#sc").append('<li class="paperQuestionLine">' + n.questionContent + '<input type="hidden" name="paperQuestions[' + i + '].id" value="' + n.id + '" /><ul id="_' + n.id + '" class="answerOl"></ol></li>');
			} else {
				$("#mc").append('<li class="paperQuestionLine">' + n.questionContent + '<input type="hidden" name="paperQuestions[' + i + '].id" value="' + n.id + '" /><ul id="_' + n.id + '" class="answerOl"></ol></li>');
			}
			$.each(n.answers, function(j, m) {
				var order = '';
				if (j == 0) {
					order = 'A';
				} else if (j == 1) {
					order = 'B';
				} else if (j == 2) {
					order = 'C';
				} else {
					order = 'D';
				}
				$("#_" + n.id).append('<label><input type="' + (n.questionType == 2 ? 'checkbox' : 'radio') + '" name="paperQuestions[' + i + '].answer" value="' + m.answerId + '" />&emsp;' + order + '.&emsp;' + m.answerContent + '</label>');
			});
		});
		$("#paper").append('<div id="paperFooter"><button class="btn green" onclick="submitPaper()">交卷</buttion></div>')
	}
	
	function submitPaper() {
		$(form).ajaxSubmit({
			type : 'post',
			url : "rest/paper/submit",
			dataType : "json",
			success : function(result) {
				getMyExamList();
				layer.msg(result.content, {
					time : 2000
				});
			}
		});
	}
	$(function() {
		getMyExamList();
		$("#index-page-title").html("答题");
		$("#current-page-title").html("答题");
	});
</script>