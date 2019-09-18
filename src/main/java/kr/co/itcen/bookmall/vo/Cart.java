package kr.co.itcen.bookmall.vo;
public class Cart{
	private Long no;
	private Long amount;
	private Long book_no;
	private Long user_no;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "Cart [no=" + no + ", amount=" + amount + ", book_no=" + book_no + ", user_no=" + user_no + ", title="
				+ title + "]";
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	
}
