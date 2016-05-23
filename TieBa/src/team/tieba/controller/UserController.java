/**
 * 
 */
package team.tieba.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import team.tieba.entity.User;
import team.tieba.entity.UserInf;
import team.tieba.service.UserService;

/**
 * @Description
 * @author WM
 * @date 2016-5-3 下午5:15:27
 * @version V1.0
 */

@Controller
@RequestMapping("Views")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * 验证用户名是否存在
	 * 
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping(value = "/verify")
	public void isRegister(HttpServletResponse response, User user)
			throws IOException {

		boolean info = true;
		boolean isExist = service.findUser(user);

		if (isExist) {
			info = false;
		}

		response.getWriter().print(info);
	}

	/**
	 * 注册成功时，保存信息
	 * 
	 * @param user
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(User user) {

		String result = service.save(user);

		if (result.equals("error")) {
			return "error";
		}

		return "login";
	}

	/**
	 * 登录用户(验证用户名 和 密码是否一致)
	 * 
	 * @param user
	 * @return 视图
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, User user) {

		boolean login = service.login(user);

		String info = "用户名和密码不一致！";
		String viewName = "login";

		if (login) {
			info = "登录成功！";
			viewName = "forward:home.do";

			// 用户信息保存在 SESSION 中
			// 获取用户信息
			UserInf userInf = service.getUserInf(user.getUname());
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("userinf", userInf);

			return new ModelAndView(viewName, null);
		}

		return new ModelAndView(viewName, "info", info);
	}

	/**
	 * 退出系统（删除用户信息）
	 * 
	 * @param request
	 *            删除session
	 * @return
	 */
	@RequestMapping("/shutdown")
	public String shutDown(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("userinf");

		return "redirect:home.do";
	}

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 *            用户名
	 * @return 视图
	 */
	@RequestMapping("/info")
	public ModelAndView getUserInf(HttpServletRequest request) {

		String uname = request.getParameter("uname");

		UserInf inf = service.getUserInf(uname);

		return new ModelAndView("userInf", "inf", inf);

	}

	/**
	 * 保存用户信息（包括 上传头像、性别、年龄）
	 * 
	 * @param photo
	 *            上传的头像文件
	 * @param userInf
	 *            用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveinf", method = RequestMethod.POST)
	public String saveInf(@RequestParam MultipartFile photofile,
			UserInf userInf, HttpServletRequest request) {

		String photoName = photofile.getOriginalFilename();
		String path = request.getSession().getServletContext()
				.getRealPath("/Resource/images/photos");

		// 新建文件，如果文件不存在，则创建目录
		File file = new File(path, photoName);
		if (!file.exists()) {
			file.mkdirs();
		}

		// 复制
		try {

			// FileUtils.copyInputStreamToFile(photo.getInputStream(), file);
			photofile.transferTo(file);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		userInf.setPhoto(photoName);

		boolean isSucc = service.saveInf(userInf);

		if (!isSucc) {
			return "error";
		}

		return "redirect:info.do?uname=" + userInf.getUname();

	}

}
