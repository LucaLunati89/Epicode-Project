package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionHandler;
import model.Product;
import model.Supplier;

public class ProductDaoImpl implements ProductDao {

	//create an attribute of type ConnectionHandler
	private ConnectionHandler connectionHandler;

	//create a constructor 
	public ProductDaoImpl() throws ClassNotFoundException{
		connectionHandler = new ConnectionHandler();
	}




	@Override
	public void createProduct(int supplierId, int productCode, String description, String brand, double price) {

		Connection connection = null;
		PreparedStatement query = null;

		try {
			connection = connectionHandler.getConnection();
			query = connection.prepareStatement( "INSERT INTO Product (supplierId, productCode, description, brand, price) VALUES (?, ?, ?, ?, ?) " );
			query.setInt(1, supplierId);
			query.setInt(2, productCode);
			query.setString(3, description);
			query.setString(4, brand);
			query.setDouble(5, price);
			query.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}
	}

	@Override
	public List<Product> readProduct() {

		List<Product> products = new ArrayList<Product>();

		Connection connection  = null;
		Statement  query = null;
		ResultSet  results = null;

		try {

			connection = connectionHandler.getConnection();

			query = connection.createStatement();
			results = query.executeQuery( "SELECT * FROM PRODUCT ORDER BY supplierId" );

			while ( results.next() ) {
				products.add( new Product( results.getInt("supplierId"), results.getInt("productCode"),
						results.getString("description"),results.getString("brand"), results.getDouble("price") ));

			}

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		} finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}


		return products;

	}

	@Override
	public List<Product> readProduct2() {

		List<Product> products = new ArrayList<Product>();
		Connection connection  = null;
		Statement  query = null;
		ResultSet  results = null;

		try {

			connection = connectionHandler.getConnection();

			query = connection.createStatement();
			results = query.executeQuery(" SELECT COUNT (productId) AS supplierId, productCode, description, brand, s.supplierName "
					+ "FROM Product p"
					+ " JOIN Supplier s on p.supplierId = s.supplierId"
					+ " GROUP BY productCode, description, brand, s.supplierName ");

			while ( results.next() ) {
				products.add( new Product( results.getInt("supplierId"), results.getInt("productCode"),
						results.getString("description"),results.getString("brand"), results.getString("supplierName") ));

			}

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		} finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}


		return products;

	}

	@Override
	public List<Product> readProductBySupplierId(int supplierId) {

		List<Product> products = new ArrayList<Product>();
		Connection connection = null;
		Statement query = null;
		ResultSet  results = null;


		try {

			connection = connectionHandler.getConnection();

			query = connection.createStatement();
			results = query.executeQuery( "SELECT * FROM PRODUCT WHERE supplierId =" + supplierId );

			while ( results.next() ) {
				products.add( new Product( results.getInt("supplierId"), results.getInt("productCode"),
						results.getString("description"),results.getString("brand"), results.getDouble("price") ));

			}

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		} finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}


		return products;

	}

	@Override
	public void updateProduct(  double priceIncrement, int productCode ) {

		Connection connection = null;
		PreparedStatement query = null;

		try {

			connection = connectionHandler.getConnection();

			query = connection.prepareStatement("UPDATE Product SET price = price + ? WHERE productCode = ? ");
			query.setInt(1, productCode ); 
			query.setDouble(2, priceIncrement ); 
			query.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		}
		finally {

			try {
				connectionHandler.closeConnection();

			}
			catch (Exception e) {};
		}


	}

	@Override
	public void deleteSingleProduct( int productId) {

		Connection connection = null;
		PreparedStatement query = null;

		try {
			connection = connectionHandler.getConnection();

			query = connection.prepareStatement("DELETE FROM Product WHERE productId = ?");
			query.setInt(1, productId);
			query.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		}
		finally {

			try {
				connectionHandler.closeConnection();

			}
			catch (Exception e) {};
		}

	}

	@Override
	public void deleteProducts(int productCode) {

		Connection connection = null;
		PreparedStatement query = null;

		try {
			connection = connectionHandler.getConnection();

			query = connection.prepareStatement("DELETE FROM Product WHERE productCode = ?");
			query.setInt(1, productCode);
			query.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		}
		finally {

			try {
				connectionHandler.closeConnection();

			}
			catch (Exception e) {};
		}
	}







}
