package team.tieba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.tieba.entity.Follow;
import team.tieba.entity.PostBars;
import team.tieba.entity.Posts;
import team.tieba.entity.User;
import team.tieba.service.PostBarsService;

/**
 * @Description
 * @author WM
 * @date 2016-5-6 上午10:37:43
 * @version V1.0
 */

@Controller
@RequestMapping("Views")
public class PostBarsController {

	@Autowired
	private PostBarsService service;
	
	
	
	/**
	 * 申请成为吧主
	 * @param request
	 * @param response
	 * @param follow
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/apply")
	public String applyMaster(HttpServletRequest request,
								HttpServletResponse response, 
									Follow follow) throws IOException{
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null)
			return "login";
		
		follow.setUname(user.getUname());
		
		boolean isSucc = service.applyMaster(follow);
		
		if (!isSucc) {
			return "error";
		}
		
		PrintWriter out = response.getWriter();
		
		out.print(true);
		
		return null;
		
	}

	

	/**
	 * 通过用户名 来获取 关注的贴吧
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/mypostbars")
	public String getMyPostBars(HttpServletRequest request, Model model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}

		List<PostBars> postbars = service.getMyPostBars(user.getUname());
		model.addAttribute("postbars", postbars);

		return "mypostbars";
	}

	/**
	 * +关注
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/attention", method = RequestMethod.GET)
	public String addAtttention(HttpServletRequest request) throws IOException {

		String bname = request.getParameter("bname");

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			return "login";
		}

		Follow follow = new Follow();
		follow.setUname(user.getUname());
		follow.setBname(bname);

		boolean isSucc = service.attention(follow);
		if (!isSucc) {
			return "error";
		}

		return "forward:bar.do?bname=" + bname;
	}
	
	
	/**
	 * +取消关注
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/subattention", method = RequestMethod.GET)
	public String subAtttention(HttpServletRequest request) throws IOException {

		String bname = request.getParameter("bname");

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			return "login";
		}

		Follow follow = new Follow();
		follow.setUname(user.getUname());
		follow.setBname(bname);

		boolean isSucc = service.subAttention(follow);
		if (!isSucc) {
			return "error";
		}

		return "forward:bar.do?bname=" + bname;
	}
	

	/**
	 * 搜索功能--主页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String searchSomeThing(HttpServletRequest request, Model model) {

		String kind = request.getParameter("kind");
		String searchName = request.getParameter("search");

		if (kind.equals("搜贴")) {

			List<Posts> posts = service.search(searchName);

			if (posts == null) {
				return "error";
			}

			model.addAttribute("posts", posts);

		} else {
			return "forward:bar.do?bname=" + searchName;
		}

		return "search";

	}

	/**
	 * 访问主页（并且判断是否已登录）
	 * 
	 * @param request
	 * @return 视图
	 */
	@RequestMapping(value = "/home")
	public ModelAndView showHomeView(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("home");

		User user = (User) request.getAttribute("user");

		if (user != null) {
			mav.addObject(user);
		}

		List<Posts> posts = service.getPopularDynamic("0");
		mav.addObject("posts", posts);

		return mav;
	}

	
	//
	@RequestMapping("/bar")
	public ModelAndView toPostBar(HttpServletRequest request) {

		// 获取贴吧名字
		String bname = request.getParameter("bname");

		// 获取贴吧信息 及其中的 贴子
		Map<String, Object> maps = service.getPostsAndBarInf(bname);

		if (maps.get("bar") == null) {
			return new ModelAndView("error");
		}

		@SuppressWarnings("unchecked")
		List<Object[]> follows = (List<Object[]>) maps.get("follows");

		User user = (User) request.getSession().getAttribute("user");

		maps.put("isExist", false);
		
		if(user!=null){
			for (Object[] follow : follows) {
	
				if (follow[0].equals(user.getUname())) {
					System.out.println(true);
					maps.put("isExist", true);
					break;
				}
			}
		}

		return new ModelAndView("postbars", "maps", maps);

	}

}
