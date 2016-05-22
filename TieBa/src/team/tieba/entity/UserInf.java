/**
 * 
 */
package team.tieba.entity;

/**
 * @Description 
 * @author WM
 * @date 2016-5-10 下午7:50:53
 * @version V1.0
 */
public class UserInf {

	// 用户名
	private String uname;
	// 年龄
	private int age;
	// 性别
	private String sex;
	// 头像
	private String photo;
	// 
	private String contact;
	
	
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
