/**
 * 
 */
package team.tieba.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description 贴子
 * @author WM
 * @date 2016-5-10 上午10:16:52
 * @version V1.0
 */
public class Posts {

	// 所属贴吧名字
	private String bname;
	// 标题
	private String title;
	// 内容
	private String content;
	// 发贴者
	private String author;
	// 回复人数
	private int pnum;
	// 贴子ID
	private String pid;
	// 父贴子ID
	private String parent_id;
	// 回复/发贴时间
	private Timestamp sendtime;

	// 回复的贴子
	private List<Posts> replay;

	// 作者人信息
	private UserInf userInf;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the pnum
	 */
	public int getPnum() {
		return pnum;
	}

	/**
	 * @param pnum
	 *            the pnum to set
	 */
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}

	/**
	 * @param parent_id
	 *            the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * @return the sendtime
	 */
	public Timestamp getSendtime() {
		return sendtime;
	}

	/**
	 * @param sendtime
	 *            the sendtime to set
	 */
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	/**
	 * @return the replay
	 */
	public List<Posts> getReplay() {
		return replay;
	}

	/**
	 * @param replay
	 *            the replay to set
	 */
	public void setReplay(List<Posts> replay) {
		this.replay = replay;
	}

	/**
	 * @return the userInf
	 */
	public UserInf getUserInf() {
		return userInf;
	}

	/**
	 * @param userInf
	 *            the userInf to set
	 */
	public void setUserInf(UserInf userInf) {
		this.userInf = userInf;
	}

}
