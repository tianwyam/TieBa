package team.tieba.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.springframework.stereotype.Repository;

import team.tieba.entity.User;
import team.tieba.entity.UserInf;
import team.tieba.util.OracleDBUtil;

/**
 * @Description
 * @author WM
 * @date 2016-5-3 下午6:55:23
 * @version V1.0
 */

@Repository
public class UserDao {

	/**
	 * 查找用户
	 * 
	 * @param user
	 * @return 是否查找到
	 */
	public boolean findUser(User user) {

		Connection conn = null;
		String sql = "select * from nuser where uname = '" + user.getUname()
				+ "'";

		try {

			// 获取连接
			conn = OracleDBUtil.getODBconn();

			// 查询 -- 匹配与指定用户是否存在
			User query = new QueryRunner().query(conn, sql,
					new BeanHandler<User>(User.class));

			// 存在
			if (query != null)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				OracleDBUtil.CloseDBConn(conn);
		}

		// 不存在
		return false;
	}

	/**
	 * 保存信息
	 * 
	 * @param user
	 * @return String
	 */
	public String save(User user) {

		Connection conn = null;
		String sql = "insert into nuser(uname,password) values(?,?)";
		String sql2 = "insert into userinf(uname,photo) values(?,?)";
		String photo = "defaultUser.jpg";
		int update = 0;

		try {

			conn = OracleDBUtil.getODBconn();
			// 更新数据--插入数据
			update = new QueryRunner().update(conn, sql, user.getUname(),
					user.getPassword());
			// 更新用户信息表
			update = new QueryRunner().update(conn, sql2, user.getUname(),
					photo);

			if (update > 0) {
				System.out.println("插入数据成功！");
				return "success";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} finally {
			if (conn != null)
				OracleDBUtil.CloseDBConn(conn);
		}

		System.out.println("插入数据失败！");
		return "error";
	}

	/**
	 * 登录（验证 用户名和密码是否匹配）
	 * 
	 * @param user
	 * @return true/false
	 */
	public boolean login(User user) {

		Connection conn = null;
		String sql = "select * from nuser where uname='" + user.getUname()
				+ "' and password='" + user.getPassword() + "'";

		try {
			conn = OracleDBUtil.getODBconn();
			User query = new QueryRunner().query(conn, sql,
					new BeanHandler<User>(User.class));
			if (query != null)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				OracleDBUtil.CloseDBConn(conn);
		}

		return false;
	}

	/**
	 * 获取 用户信息
	 * 
	 * @param uname
	 * @return UserInf
	 */
	public UserInf getUserInf(String uname) {

		Connection conn = null;
		String sql = "select * from userinf where uname='" + uname + "'";
		UserInf inf = null;

		try {

			conn = OracleDBUtil.getODBconn();
			inf = new QueryRunner().query(conn, sql, new BeanHandler<UserInf>(
					UserInf.class));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.CloseDBConn(conn);
		}

		return inf;
	}

	/**
	 * 保存用户信息（包括 上传头像、性别、年龄）
	 * 
	 * @param userInf
	 *            用户信息
	 * @return
	 */
	public boolean saveInf(UserInf userInf) {

		Connection conn = null;
		String sql = "update userinf set age=? , sex=? , photo=? where uname='"
				+ userInf.getUname() + "'";
		Object[] param = { userInf.getAge(), userInf.getSex(),
				userInf.getPhoto() };

		try {

			conn = OracleDBUtil.getODBconn();
			int row = new QueryRunner().update(conn, sql, param);

			if (row > 0) {
				System.out.println("用户信息 更新 成功！");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("用户信息 更新 失败！");
			return false;
		}

		System.out.println("用户信息 更新 失败！");
		return false;
	}

}
