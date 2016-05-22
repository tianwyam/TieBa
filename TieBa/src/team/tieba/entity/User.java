/**
 * 
 */
package team.tieba.entity;

/**
 * @Description 
 * @author WM
 * @date 2016-5-3 下午5:17:16
 * @version V1.0
 */

public class User {
	
	// 用户名
	private String uname;	
	// 密码
	private String password;
	// 权限
	private int root;
	
	// getter and setter
	
	/**
	 * @return the uname 
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the root
	 */
	public int getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(int root) {
		this.root = root;
	}
	
	
}
