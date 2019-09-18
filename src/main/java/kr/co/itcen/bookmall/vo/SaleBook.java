package kr.co.itcen.bookmall.vo;

public class SaleBook {
	private Long no;
	private String title;
	private Long price;
	private Long categorynum;
	private Long saleprice;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategorynum() {
		return categorynum;
	}
	public void setCategorynum(Long categorynum) {
		this.categorynum = categorynum;
	}
	public Long getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Long saleprice) {
		this.saleprice = saleprice;
	}
	@Override
	public String toString() {
		return "SaleBook [no=" + no + ", title=" + title + ", price=" + price + ", categorynum=" + categorynum
				+ ", saleprice=" + saleprice + "]";
	}
	
	
}
