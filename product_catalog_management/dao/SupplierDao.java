package dao;

import java.util.List;
import model.Supplier;

public interface SupplierDao {

	//CRUD method for Supplier
	void createSupplier ( String supplierName, String address, String city );
	List<Supplier> readSupplier();
	List<Supplier> readSupplierByCity( String city );
	void updateSupplier( String supplierName, String address, String city, int supplierId );
	void deleteSupplier( int supplierId );
	
}

