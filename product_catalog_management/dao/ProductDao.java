package dao;

import java.util.List;
import model.Product;


public interface ProductDao {
	
	//CRUD method for Product
	void createProduct ( int supplierId, int productCode, String description, String brand, double price );
	List<Product> readProduct();
	List<Product> readProductBySupplierId( int supplierId);
	List<Product> readProduct2();
	void updateProduct(  double price, int productCode );
	void deleteSingleProduct( int productId);
	void deleteProducts( int productCode );
}
