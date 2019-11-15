package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.QuestionBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionListModel;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Resource
	private QuestionBiz questionBiz;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Page<Question> search(@RequestParam(value = "pageNo") Integer pageNo,
			@RequestParam(value = "questionContent", required = false) String questionContent, HttpSession session) {
		Question question = new Question();
		if (questionContent != null && !"".equals(questionContent)) {
			question.setQuestionContent(questionContent);
		}
		question.setGroupId(((User) session.getAttribute("userInfo")).getUserGroup());
		return questionBiz.search(question, pageNo);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Message edit(@Valid QuestionExtend question, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (question != null) {
			return questionBiz.edit(question, me);
		} else {
			return new Message(false, "保存失败");
		}
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public QuestionExtend info(@Valid Question question) {
		return questionBiz.info(question);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Message delete(@Valid Question question, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (question != null) {
			return questionBiz.delete(question, me);
		} else {
			return new Message(false, "删除失败");
		}
	}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	public ResponseEntity<byte[]> template() throws IOException {
		final String filename = "题目批量导入模版.xls";
		HttpHeaders headers = new HttpHeaders();
		File file = questionBiz.template(filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment",
				new String(URLEncoder.encode(filename, "UTF8").getBytes("UTF-8"), "iso-8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Message input(@RequestParam MultipartFile uploadFile, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		InputStream inputStream = null;
		try {
			inputStream = uploadFile.getInputStream();
			return questionBiz.input(inputStream, me.getUserGroup());
		} catch (IOException e) {
			return new Message(false, "Excel解析失败", e.getStackTrace());
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Message saveAll(QuestionListModel questions, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		List<QuestionExtend> questions0 = new ArrayList<QuestionExtend>();
		if (questions != null) {
			for (QuestionExtend question : questions.getQuestions()) {
				if (question != null && question.getQuestionContent() != null) {
					questions0.add(question);
				}
			}
			return questionBiz.saveAll(questions0, me);
		} else {
			return new Message(false, "保存失败，请重新上传");
		}
	}

}
