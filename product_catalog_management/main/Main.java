package main;

import java.util.List;

import dao.ProductDaoImpl;
import dao.SupplierDaoImpl;
import model.Product;
import model.Supplier;


public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			SupplierDaoImpl supplierDaoImpl = new SupplierDaoImpl();
			
			//supplierDaoImpl.createSupplier("test1", "test1", "test1");
			
			//supplierDaoImpl.deleteSupplier(7);
			
			//supplierDaoImpl.updateSupplier("testUpdate", "testUpdate", "testUpdate", 1);
			
			List <Supplier> suppliers = supplierDaoImpl.readSupplier();
			printSupplier(suppliers);
			
			//List <Supplier> suppliers2 = supplierDaoImpl.readSupplierByCity("Roma");
			//printSupplier(suppliers2);
			
			//ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			//productDaoImpl.createProduct(1, 233445, "testproduct", "testproduct", 51.445);
			
			//da controllare inconsistenza posso modificare un prodotto anche se ho cancellato il fornitore--> dovrebbe rimanere solo nello storico
			//productDaoImpl.updateProduct(555746, 10);
			//productDaoImpl.deleteSingleProduct(6);
			//productDaoImpl.deleteProducts(555746);
			//List<Product> products = productDaoImpl.readProduct2();
			//List<Product> products2 = productDaoImpl.readProductBySupplierId(2);
			//printProducts(products);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		

	}
	
	

//method to return supplier
public static void printSupplier(List<Supplier> suppliers) {
		
		if ( suppliers != null ) {
			for ( Supplier supplier : suppliers ) {
				System.out.println( " | " + supplier.getSupplierId() + " | " + supplier.getSupplierName() + ", " +
			supplier.getAddress() + ", " + supplier.getCity() );
			}
		}
	}

public static void printProducts(List<Product> products) {
	
	if ( products != null ) {
		for ( Product product : products ) {
			System.out.println( " | " + product.getSupplierId() + " | " + product.getProductCode() + ", " +
		product.getDescription() + ", " + product.getBrand() + ", " + product.getPrice() );
		}
	}
}
	

}
