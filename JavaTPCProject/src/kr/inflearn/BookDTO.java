package kr.inflearn;

public class BookDTO {
	private String title;
	private int price;
	private String compony;
	private int page;
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	public BookDTO(String title, int price, String compony, int page) {
		super();
		this.title = title;
		this.price = price;
		this.compony = compony;
		this.page = page;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompony() {
		return compony;
	}
	public void setCompony(String compony) {
		this.compony = compony;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", price=" + price + ", compony=" + compony + ", page=" + page + "]";
	}
	
	
	
	
}
