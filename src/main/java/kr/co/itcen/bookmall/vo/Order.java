package kr.co.itcen.bookmall.vo;

public class Order {
	private Long no;
	private Long price;
	private String from;
	private Long user_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "Order [no=" + no + ", price=" + price + ", from=" + from + ", user_no=" + user_no + "]";
	}
	
	
	
}
