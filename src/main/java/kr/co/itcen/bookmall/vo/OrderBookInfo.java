package kr.co.itcen.bookmall.vo;

public class OrderBookInfo {
	private Long no;
	private String title;
	private Long amount;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderBookInfo [no=" + no + ", title=" + title + ", amount=" + amount + "]";
	}
	
}
