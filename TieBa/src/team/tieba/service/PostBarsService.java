/**
 * 
 */
package team.tieba.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tieba.dao.PostBarsDao;
import team.tieba.entity.Follow;
import team.tieba.entity.PostBars;
import team.tieba.entity.Posts;

/**
 * @Description 贴吧（业务逻辑层）
 * @author WM
 * @date 2016-5-10 上午10:37:36
 * @version V1.0
 */
@Service
public class PostBarsService {

	@Autowired
	private PostBarsDao postBarsDao;
	
	
	/**
	 * 获取 热门动态 （最新贴子）
	 * @return List<Posts>
	 */
	public List<Posts> getPopularDynamic(String parent_id){
		return postBarsDao.getPopularDynamic(parent_id);
	}
	
	
	/**
	 * 查询 贴吧信息 及其中的 贴子
	 * @param bname 贴吧名字
	 * @return Map
	 */
	public Map<String, Object> getPostsAndBarInf(String bname){
		return postBarsDao.getPostsAndBarInf(bname);
	}
	
	
	/**
	 * 搜索
	 * @param searchName
	 * @return
	 */
	public List<Posts> search(String searchName){
		return postBarsDao.search(searchName);
	}
	
	
	/**
	 * 加关注
	 * @param follow
	 * @return 成功/失败
	 */
	public boolean attention(Follow follow){
		return postBarsDao.attention(follow);
	}
	
	
	/**
	 * 通过 用户名 来获取他/她的关注的贴吧
	 * @param uname
	 * @return List<PostBars>
	 */
	public List<PostBars> getMyPostBars(String uname){
		return postBarsDao.getMyPostBars(uname);
	}

}
