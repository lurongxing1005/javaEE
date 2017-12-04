package com.etcxm.shoppingcart;

//商品对象
public class CartItem {
   
	private Long id;//商品id
	private String name;//商品名称
	private Double price;//商品价格
	private Integer num;//商品数量
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public CartItem(Long id, String name, Double price, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price
				+ ", num=" + num + "]";
	}
	
	
}
