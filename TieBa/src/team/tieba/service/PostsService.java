/**
 * 
 */
package team.tieba.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tieba.dao.PostsDao;
import team.tieba.entity.Posts;

/**
 * @Description
 * @author WM
 * @date 2016-5-10 下午8:53:25
 * @version V1.0
 */
@Service
public class PostsService {

	@Autowired
	private PostsDao postsDao;

	/**
	 * 根据用户名来查询贴子
	 * 
	 * @param uname
	 * @return
	 */
	public List<Posts> getPostsByUname(String uname) {
		return postsDao.getPostsByUname(uname);
	}

	/**
	 * 通过PID 获取 贴子
	 * 
	 * @param pid
	 * @return Map
	 */
	public Map<String, Object> getPostById(String pid) {
		return postsDao.getPostById(pid);
	}

	/**
	 * 发表贴子
	 * 
	 * @param posts
	 *            贴子信息
	 * @return true/false
	 */
	public boolean savePosts(Posts posts) {
		return postsDao.savePosts(posts);
	}

}
