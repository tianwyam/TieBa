/**
 * 
 */
package team.tieba.entity;

/**
 * @Description
 * @author WM
 * @date 2016-5-10 下午8:23:11
 * @version V1.0
 */
public class Replay {

	// 发贴人
	private String author;
	// 贴子标题
	private String title;
	// 回复内容
	private String rcontent;
	// 回复人
	private String rname;

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
	 * @return the rcontent
	 */
	public String getRcontent() {
		return rcontent;
	}

	/**
	 * @param rcontent
	 *            the rcontent to set
	 */
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	/**
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * @param rname
	 *            the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

}
