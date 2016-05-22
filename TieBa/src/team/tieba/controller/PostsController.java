
package team.tieba.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import team.tieba.entity.Posts;
import team.tieba.entity.User;
import team.tieba.service.PostsService;

/**
 * @Description 
 * @author WM
 * @date 2016-5-10 下午8:10:35
 * @version V1.0
 */
@Controller
@RequestMapping("Views")
public class PostsController{
	
	@Autowired
	private PostsService service;
	
	
	/**
	 * 获取 用户自己发的帖子
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/myposts")
	public String getMyPosts(HttpServletRequest request){
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		
		List<Posts> posts = service.getPostsByUname(user.getUname());
		request.setAttribute("posts", posts);
		
		return "myposts";
		
	}

	
	/**
	 * 查询 贴子信息
	 * @param request
	 * @return 视图
	 */
	@RequestMapping("/post")
	public ModelAndView toPostInf(HttpServletRequest request){
		
		String pid = request.getParameter("pid");
		
		Map<String, Object> maps = service.getPostById(pid);
		
		return new ModelAndView("posts","maps",maps);
		
	}
	
	
	/**
	 * GET 请求发贴（+ 验证用户是否登录）
	 * @param request
	 * @return 视图
	 */
	@RequestMapping(value="/sendpost",method=RequestMethod.GET)
	public String SendPosts(HttpServletRequest request){
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user==null){
			return "login";
		}
		
		return "sendpost";
	}
	
	
	
	/**
	 * POST 请求发贴
	 * @param posts
	 * @param request
	 * @return 
	 */
	@RequestMapping(value="/sendpost",method=RequestMethod.POST)
	public String sendPosts(Posts posts,HttpServletRequest request){
		
		User user = (User)request.getSession().getAttribute("user");
		String author = user.getUname();
		
		posts.setAuthor(author);
		posts.setParent_id("0");

		posts.setSendtime(new Timestamp(new java.util.Date().getTime()));
		// 随机生成一个ID
		posts.setPid(UUID.randomUUID().toString());
		
		boolean isSucc = service.savePosts(posts);
		
		// 如果发贴失败，就跳转错误界面
		if (!isSucc) {
			return "error";
		}
		
		return "redirect:bar.do?bname="+posts.getBname();
		
	}
	
	
	
	/**
	 * POST 请求发贴回复
	 * @param posts
	 * @param request
	 * @return 
	 */
	@RequestMapping(value="/sendreplay",method=RequestMethod.POST)
	public String sendReplay(Posts posts,HttpServletRequest request){
		
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login";
		}
		
		String author = user.getUname();
		
		posts.setAuthor(author);
		
		posts.setSendtime(new Timestamp(new java.util.Date().getTime()));
		
		// 随机生成一个ID
		posts.setPid(UUID.randomUUID().toString());
		
		boolean isSucc = service.savePosts(posts);
		
		// 如果发贴失败，就跳转错误界面
		if (!isSucc) {
			return "error";
		}
		
		return "redirect:post.do?pid="+posts.getParent_id();
		
	}
	
	
	/**
	 * POST 请求发贴回复
	 * @param posts
	 * @param request
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping(value="/secondreplay",method=RequestMethod.POST)
	public String secondReplay(Posts posts,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "login";
		}
		
		if(posts.getAuthor().equals("") || posts.getAuthor()==null){
			String author = user.getUname();
			posts.setAuthor(author);
		}
		
		posts.setSendtime(new Timestamp(new java.util.Date().getTime()));
		
		// 随机生成一个ID
		posts.setPid(UUID.randomUUID().toString());
		
		boolean isSucc = service.savePosts(posts);
		
		// 如果发贴失败，就跳转错误界面
		if (!isSucc) {
			return "error";
		}
		
		response.getWriter().print(true);
		
		return null;
	}


	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(sdf, false));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
