package kr.co.itcen.bookmall.vo;
public class Category {
	private Long no;
	private String category;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [no=" + no + ", category=" + category + "]";
	}
}
