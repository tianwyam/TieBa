/**
 * 
 */
package team.tieba.entity;

/**
 * @Description 用户与贴吧的联系
 * @author WM
 * @date 2016-5-17 上午11:07:49
 * @version V1.0
 */
public class Follow {

	// 用户名
	private String uname;
	// 贴吧名字
	private String bname;
	// 等级
	private int grade;
	// 申请吧主的理由
	private String reason;

	// 构造器
	public Follow() {
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname
	 *            the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param bname
	 *            the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
