/**
 * 
 */
package team.tieba.entity;

/**
 * @Description 贴吧
 * @author WM
 * @date 2016-5-10 上午10:20:50
 * @version V1.0
 */
public class PostBars {

	// 贴吧名字
	private String bname;
	
	// 贴吧简介
	private String breif;
	
	// 人数
	private int num;

	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param bname the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}


	
	
	/**
	 * @return the breif
	 */
	public String getBreif() {
		return breif;
	}

	/**
	 * @param breif the breif to set
	 */
	public void setBreif(String breif) {
		this.breif = breif;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
}
