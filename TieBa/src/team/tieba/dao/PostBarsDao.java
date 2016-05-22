package team.tieba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import team.tieba.entity.Follow;
import team.tieba.entity.PostBars;
import team.tieba.entity.Posts;
import team.tieba.util.OracleDBUtil;

/**
 * @Description 贴吧（数据访问层）
 * @author WM
 * @date 2016-5-10 上午10:25:54
 * @version V1.0
 */
@Repository
public class PostBarsDao {
	

	/**
	 * 获取 热门动态 （最新贴子）
	 * @return List<Posts>
	 */
	public List<Posts> getPopularDynamic(String parent_id){
		
		String sql = "select * from posts where rownum < 5 and parent_id='"+parent_id+"' order by sendtime desc";
		Connection conn = null;
		List<Posts> postsList = null;
		try {
			
			conn = OracleDBUtil.getODBconn();
			
			postsList = new QueryRunner().query(conn, sql, new BeanListHandler<Posts>(Posts.class));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			OracleDBUtil.CloseDBConn(conn);
		}
		
		return postsList;
	}
	
	
	/**
	 * 查询 贴吧信息 及其中的 贴子
	 * @param bname 贴吧名字
	 * @return Map
	 */
	public Map<String, Object> getPostsAndBarInf(String bname){
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		String sql = "select * from posts where bname='"+bname+"' order by sendtime desc";
		String barsql = "select * from postbars where bname='"+bname+"'";
		String followsql = "select uname from follow where bname='"+bname+"'";
		
		Connection conn = null;
		List<Posts> postsList = null;
		List<Object[]> follows = null;
		PostBars bar = null;
		
		try {
			
			conn = OracleDBUtil.getODBconn();
			postsList = new QueryRunner().query(conn, sql, new BeanListHandler<Posts>(Posts.class));
			maps.put("postsList", postsList);
			
			bar = new QueryRunner().query(conn, barsql, new BeanHandler<PostBars>(PostBars.class));
			maps.put("bar", bar);
			
			follows = new QueryRunner().query(conn, followsql, new ArrayListHandler());
			
			maps.put("follows", follows);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			OracleDBUtil.CloseDBConn(conn);
		}
		
		return maps;
	}
	
	
	
	/**
	 * 搜索
	 * @param searchName
	 * @return
	 */
	public List<Posts> search(String searchName){
		
		Connection conn = null;
		String sql = "select * from posts where content like '%"+searchName+"%' and parent_id='0'";
		List<Posts> posts = null;
		
		try {
			
			conn = OracleDBUtil.getODBconn();
			posts = new QueryRunner().query(conn, sql, new BeanListHandler<Posts>(Posts.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return posts;
		}finally{
			OracleDBUtil.CloseDBConn(conn);
		}
		
		return posts;
		
	}
	
	
	/**
	 * 加关注
	 * @param follow
	 * @return 成功/失败
	 */
	public boolean attention(Follow follow){
		
		System.out.println(follow.getBname()+"+++"+follow.getUname());
		
		
		Connection conn = null;
		String sql = "insert into follow(uname,bname) values(?,?)";
		
		Object[] param = {
				follow.getUname(),
				follow.getBname()
		};
		
		try {
			
			conn = OracleDBUtil.getODBconn();
			int update = new QueryRunner().update(conn, sql, param);
			if (update > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			OracleDBUtil.CloseDBConn(conn);
		}
		
		return false;
	}
	
	
	
	/**
	 * 通过 用户名 来获取他/她的关注的贴吧
	 * @param uname
	 * @return List<PostBars>
	 */
	public List<PostBars> getMyPostBars(String uname){
		
		Connection conn = null;
		List<PostBars> postbars = null;
		String sql = "select p.* from follow f, postbars p where p.bname=f.bname and f.uname='"+uname+"'";
		
		try {
			
			conn = OracleDBUtil.getODBconn();
			postbars = new QueryRunner().query(conn, sql, new BeanListHandler<PostBars>(PostBars.class));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			OracleDBUtil.CloseDBConn(conn);
		}
		
		return postbars;
		
	}

}
