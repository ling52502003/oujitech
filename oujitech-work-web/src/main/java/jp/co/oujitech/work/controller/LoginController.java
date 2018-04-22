package jp.co.oujitech.work.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.oujitech.work.model.UserInfo;
import jp.co.oujitech.work.service.UserService;
import jp.co.oujitech.work.util.WebSecurityConfig;

@Controller
@RequestMapping("/loginUser")
public class LoginController {

	@Autowired
	private UserService userService;

	/**
	 * Login
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/loginCheck")
	public String getUserInfo(@Validated @ModelAttribute UserInfo form, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("validationError",result.getAllErrors().get(0).getDefaultMessage());
			return "/user/login";
		}

		// DB check
		boolean chSuccess = userService.checkLoginUser(form);

		// login success
		if(chSuccess) {
			// set mailId to the session
			session.setAttribute(WebSecurityConfig.SESSION_KEY, form.getMailId());
			// set db name
			model.addAttribute("users", form);

			return "/user/list";
		} else {
			model.addAttribute("validationError","mail or passwork error!");
			return "/user/login";
		}

	}

	/**
	 *
	 * initUser
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String init(Model model) {
		model.addAttribute("userInfo", new UserInfo());
		return "/user/login";
	}

	/**
	 * AddUserInfo
	 *
	 * @return
	 */
	@RequestMapping("/addUserInfo")
	public String addUserInfo() {
		UserInfo user = new UserInfo();
		user.setUserId("1233");
		userService.insert(user);
		return "success:" + user.toString();
	}

}