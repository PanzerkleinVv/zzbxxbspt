package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.UserBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.UsernameIdcardToken;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户控制器
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserBiz userBiz;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
		try {
			Subject subject = SecurityUtils.getSubject();
			// 已登陆则 跳到首页
			if (subject.isAuthenticated()) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			// 身份验证
			subject.login(new UsernameIdcardToken(user.getUserName(), user.getUserPsw()));
			// 验证成功在Session中保存用户信息
			final User authUserInfo = userBiz.logon(user.getUserPsw());
			request.getSession().setAttribute("userInfo", authUserInfo);
		} catch (AuthenticationException e) {
			// 身份验证失败
			model.addAttribute("error", "个人信息错误 ！请联系考试管理员");
			return "login";
		}
		return "redirect:/";
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Page<User> search(@RequestParam(value = "pageNo") Integer pageNo,
			@RequestParam(value = "userName", required = false) String userName, HttpSession session) {
		User user0 = new User();
		if (userName != null && !"".equals(userName)) {
			user0.setUserName(userName);
		}
		user0.setUserGroup(((User) session.getAttribute("userInfo")).getUserGroup());
		return userBiz.search(user0, pageNo);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Message edit(@Valid User user, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (user != null) {
			return userBiz.edit(user, me);
		} else {
			return new Message(false, "保存失败");
		}
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public User info(@Valid User user) {
		return userBiz.info(user.getUserId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Message delete(@Valid User user, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (user != null) {
			return userBiz.delete(user, me);
		} else {
			return new Message(false, "删除失败");
		}
	}

	@RequestMapping(value = "/checkPsw", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Boolean checkPsw(@Valid User user, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		user.setUserGroup(me.getUserGroup());
		return userBiz.checkPsw(user);
	}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	public ResponseEntity<byte[]> template() throws IOException {
		final String filename = "学员批量导入模版.xls";
		HttpHeaders headers = new HttpHeaders();
		File file = userBiz.template(filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment",
				new String(URLEncoder.encode(filename, "UTF8").getBytes("UTF-8"), "iso-8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Message input(@RequestParam MultipartFile uploadFile, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		InputStream inputStream = null;
		try {
			inputStream = uploadFile.getInputStream();
			return userBiz.input(inputStream, me.getUserGroup());
		} catch (IOException e) {
			return new Message(false, "Excel解析失败", e.getStackTrace());
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}
	
	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.ADMIN_STUDENT)
	@ResponseBody
	public Message saveAll(@RequestBody List<User> users, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		return userBiz.saveAll(users, me);
	}

}
