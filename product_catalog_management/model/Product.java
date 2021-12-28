package model;


public class Product {

	private String supplierName; // prova collegamento alla tabella fornitore
	private int supplierId;
	private int productCode;
	private String description;
	private String brand;
	private double price;


	public Product(int supplierId, int productCode, String description, String brand, String supplierName) {

		this.supplierName = supplierName;
		this.supplierId = supplierId;
		this.productCode = productCode;
		this.description = description;
		this.brand = brand;
		

	}

	public Product(int supplierId, int productCode, String description, String brand, double price) {

		this.supplierId = supplierId;
		this.productCode = productCode;
		this.description = description;
		this.brand = brand;
		this.price = price;

	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}




}
