package model;

public class Supplier {
	
	private int supplierId; 
	private String supplierName; 
	private String address; 
	private String city;
	
	//constructor
	public Supplier( int supplierId ) {
		this.supplierId = supplierId;
	}
	
	public Supplier( int supplierId, String supplierName, String address, String city ) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.city = city;
	}

	// getter and setter
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
