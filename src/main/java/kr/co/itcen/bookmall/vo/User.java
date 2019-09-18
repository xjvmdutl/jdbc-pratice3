package kr.co.itcen.bookmall.vo;

public class User {
	private Long no;
	private String admin_no;
	private String password;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(String admin_no) {
		this.admin_no = admin_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", admin_no=" + admin_no + ", password=" + password + "]";
	}
	
	
}
