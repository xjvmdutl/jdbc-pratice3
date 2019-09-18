package kr.co.itcen.bookmall.vo;

public class UserInfo {
	private Long no;
	
	private String name;
	private String phone;
	private String email;
	private Long user_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "UserInfo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", user_no="
				+ user_no + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	
}
