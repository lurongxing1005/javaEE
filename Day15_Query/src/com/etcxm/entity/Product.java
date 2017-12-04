package com.etcxm.entity;

public class Product {
    private Long id;
    private String productName;
    private Long dir_id;
    private Double salePrice;
    private String supplier;
    private String brand;
    private Double cutoff;
    private Double costPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getDir_id() {
		return dir_id;
	}
	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getCutoff() {
		return cutoff;
	}
	public void setCutoff(Double cutoff) {
		this.cutoff = cutoff;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Product(Long id, String productName, Long dir_id, Double salePrice,
			String supplier, String brand, Double cutoff, Double costPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.dir_id = dir_id;
		this.salePrice = salePrice;
		this.supplier = supplier;
		this.brand = brand;
		this.cutoff = cutoff;
		this.costPrice = costPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", dir_id=" + dir_id + ", salePrice=" + salePrice
				+ ", supplier=" + supplier + ", brand=" + brand + ", cutoff="
				+ cutoff + ", costPrice=" + costPrice + "]\n";
	}
    
    
}
