package kr.co.itcen.bookmall.vo;

public class OrderBook {
	private Long no;
	private Long amount;
	private Long order_no;
	private Long book_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	@Override
	public String toString() {
		return "OrderBook [no=" + no + ", amount=" + amount + ", order_no=" + order_no + ", book_no=" + book_no + "]";
	}
	
}
