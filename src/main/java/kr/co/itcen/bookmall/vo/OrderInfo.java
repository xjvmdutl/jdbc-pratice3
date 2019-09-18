package kr.co.itcen.bookmall.vo;

public class OrderInfo {
	private Long no;
	private String name;
	private String email;
	private Long price;
	private String from;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "OrderInfo [no=" + no + ", name=" + name + ", email=" + email + ", price=" + price + ", from=" + from
				+ "]";
	}
	
	
}
