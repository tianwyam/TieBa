/**
 * 
 */
package team.tieba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tieba.dao.UserDao;
import team.tieba.entity.User;
import team.tieba.entity.UserInf;

/**
 * @Description 
 * @author WM
 * @date 2016-5-3 下午6:58:40
 * @version V1.0
 */

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 查找是否有指定的user
	 * @param user
	 * @return boolean
	 */
	public boolean findUser(User user){
		return userDao.findUser(user);
	}
	
	/**
	 * 保存数据
	 * @param user
	 * @return 
	 */
	public String save(User user){
		return userDao.save(user);
	}
	
	/**
	 * 登录（验证 密码与用户名是否一致）
	 * @param user
	 * @return true/false
	 */
	public boolean login(User user){
		return userDao.login(user);
	}
	
	
	/**
	 * 获取 用户信息
	 * @param uname
	 * @return UserInf
	 */
	public UserInf getUserInf(String uname){
		return userDao.getUserInf(uname);
	}
	
	

	/**
	 * 保存用户信息（包括 上传头像、性别、年龄）
	 * @param userInf 用户信息
	 * @return
	 */
	public boolean saveInf(UserInf userInf){
		return userDao.saveInf(userInf);
	}
}
