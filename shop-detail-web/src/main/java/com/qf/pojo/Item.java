package com.qf.pojo;


public class Item{

	private Integer bookid;

	private String bookname;

	private String isbn;

	private Integer num;

	private Integer price;

	private String author;

	private Integer publisherid;

	private String publishname;

	private String phone;

	private String address;

	private String edition;

	private String publicationdate;

	private Integer smalltypeid;

	private String typename;

	private String pic;

	private String spare;

	private String context;

	@Override
	public String toString() {
		return "Item{" +
				"bookid=" + bookid +
				", bookname='" + bookname + '\'' +
				", isbn='" + isbn + '\'' +
				", num=" + num +
				", price=" + price +
				", author='" + author + '\'' +
				", publisherid=" + publisherid +
				", publishname='" + publishname + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", edition='" + edition + '\'' +
				", publicationdate='" + publicationdate + '\'' +
				", smalltypeid=" + smalltypeid +
				", typename='" + typename + '\'' +
				", pic='" + pic + '\'' +
				", spare='" + spare + '\'' +
				", context='" + context + '\'' +
				'}';
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPublishname() {
		return publishname;
	}

	public void setPublishname(String publishname) {
		this.publishname = publishname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}



	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(Integer publisherid) {
		this.publisherid = publisherid;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublicationdate() {
		return publicationdate;
	}

	public void setPublicationdate(String publicationdate) {
		this.publicationdate = publicationdate;
	}

	public Integer getSmalltypeid() {
		return smalltypeid;
	}

	public void setSmalltypeid(Integer smalltypeid) {
		this.smalltypeid = smalltypeid;
	}

	public String getPic() {
		// if (pic != null && !"".equals(pic)) {
		// 	String[] strings = pic.split(",");
		// 	return strings;
		// }
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getSpare() {
		return spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Item() {
	}

}
