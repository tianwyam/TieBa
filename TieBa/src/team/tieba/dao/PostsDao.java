/**
 * 
 */
package team.tieba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import team.tieba.entity.Posts;
import team.tieba.entity.UserInf;
import team.tieba.util.OracleDBUtil;

/**
 * @Description
 * @author WM
 * @date 2016-5-10 下午8:14:19
 * @version V1.0
 */
@Repository
public class PostsDao {

	/**
	 * 根据用户名来查询贴子
	 * 
	 * @param uname
	 * @return
	 */
	public List<Posts> getPostsByUname(String uname) {

		String sql = "select * from posts where author='" + uname
				+ "' and parent_id='0'";
		Connection conn = null;
		List<Posts> posts = null;

		try {

			conn = OracleDBUtil.getODBconn();
			posts = new QueryRunner().query(conn, sql,
					new BeanListHandler<Posts>(Posts.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.CloseDBConn(conn);
		}

		return posts;
	}

	/**
	 * 通过PID 获取 贴子
	 * 
	 * @param pid
	 * @return Map(贴子 + 回复)
	 */
	public Map<String, Object> getPostById(String pid) {

		Map<String, Object> maps = new HashMap<String, Object>();

		String sql = "select * from posts where pid='" + pid + "'";
		Connection conn = null;
		UserInf userInf = null;
		Posts post = null;
		List<Posts> replay = null;

		try {

			// 获取贴子信息
			conn = OracleDBUtil.getODBconn();

			post = new QueryRunner().query(conn, sql, new BeanHandler<Posts>(
					Posts.class));

			// 获取回复信息
			String sqlreplay = "select * from posts where parent_id='"
					+ post.getPid() + "' order by sendtime asc";
			replay = new QueryRunner().query(conn, sqlreplay,
					new BeanListHandler<Posts>(Posts.class));
			// maps.put("replay", replay);

			// 二级回复
			for (Posts posts : replay) {
				String sqlreplay2 = "select * from posts where parent_id='"
						+ posts.getPid() + "' order by sendtime asc";
				List<Posts> replay2 = new QueryRunner().query(conn, sqlreplay2,
						new BeanListHandler<Posts>(Posts.class));

				for (Posts posts2 : replay2) {
					String sqlinf3 = "select * from userinf where uname='"
							+ posts2.getAuthor() + "'";
					UserInf userInf3 = new QueryRunner().query(conn, sqlinf3,
							new BeanHandler<UserInf>(UserInf.class));
					posts2.setUserInf(userInf3);
				}
				posts.setReplay(replay2);

				String sqlinf2 = "select * from userinf where uname='"
						+ posts.getAuthor() + "'";
				UserInf userInf2 = new QueryRunner().query(conn, sqlinf2,
						new BeanHandler<UserInf>(UserInf.class));
				posts.setUserInf(userInf2);

			}
			post.setReplay(replay);

			post.setPnum(replay.size());
			// 修改回复数
			String sqlpnum = "update posts set pnum=? where pid='"
					+ post.getPid() + "'";
			new QueryRunner().update(conn, sqlpnum, post.getPnum());

			// 获取作者信息
			String sqlinf = "select * from userinf where uname='"
					+ post.getAuthor() + "'";
			userInf = new QueryRunner().query(conn, sqlinf,
					new BeanHandler<UserInf>(UserInf.class));
			// maps.put("userInf", userInf);
			post.setUserInf(userInf);

			maps.put("post", post);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			OracleDBUtil.CloseDBConn(conn);
		}

		return maps;
	}

	/**
	 * 发表贴子
	 * 
	 * @param posts
	 *            贴子信息
	 * @return true/false
	 */
	public boolean savePosts(Posts posts) {

		Connection conn = null;
		String sql = "insert into posts(bname,title,content,author,pid,parent_id,sendtime) values(?,?,?,?,?,?,?)";

		Object[] param = { posts.getBname(), posts.getTitle(),
				posts.getContent(), posts.getAuthor(), posts.getPid(),
				posts.getParent_id(), posts.getSendtime() };

		try {

			conn = OracleDBUtil.getODBconn();

			int update = new QueryRunner().update(conn, sql, param);

			if (update > 0) {
				System.out.println("发表贴子成功！");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("发表贴子失败！");
			return false;
		} finally {
			OracleDBUtil.CloseDBConn(conn);
		}

		System.out.println("发表贴子失败！");
		return false;
	}

}
