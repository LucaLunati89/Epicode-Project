package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionHandler;
import model.Supplier;

public class SupplierDaoImpl implements SupplierDao {

	//create an attribute of type ConnectionHandler
	private ConnectionHandler connectionHandler;

	//create a constructor 
	public SupplierDaoImpl() throws ClassNotFoundException{
		connectionHandler = new ConnectionHandler();
	}

	@Override
	public void createSupplier( String supplierName, String address, String city ) {

		Connection connection = null;
		PreparedStatement query = null;

		try {
			connection = connectionHandler.getConnection();
			query = connection.prepareStatement( " INSERT INTO Supplier ( supplierName, address, city ) VALUES ( ?, ?, ? )");
			query.setString(1, supplierName);
			query.setString(2, address);
			query.setString(3, city);
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
	public List<Supplier> readSupplier() {
		List<Supplier> suppliers = new ArrayList<Supplier>();

		Connection connection  = null;
		Statement  query = null;
		ResultSet  results = null;


		try {

			connection = connectionHandler.getConnection();

			query = connection.createStatement();
			results = query.executeQuery(" SELECT * FROM Supplier ORDER BY supplierId");

			while ( results.next() ) {
				suppliers.add( new Supplier( results.getInt("supplierId"),
						results.getString("supplierName"),results.getString("address"), results.getString("city") ));

			}

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
		} finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}


		return suppliers;
	}


	@Override
	public List<Supplier> readSupplierByCity( String supplierCity ) {
		
		List<Supplier> suppliers = new ArrayList<Supplier>();

		Connection connection  = null;
		PreparedStatement  query = null;
		ResultSet  results = null;


		try {

			connection = connectionHandler.getConnection();

			
			query = connection.prepareStatement( " SELECT * FROM Supplier WHERE city = ? " );
			query.setString(1, supplierCity);
			results = query.executeQuery();
			
			
			while ( results.next() ) {
				suppliers.add( new Supplier( results.getInt("supplierId"),
						results.getString("supplierName"),results.getString("address"), results.getString("city") ));

			}

		} catch (SQLException ex) {
			System.out.println("errore: " + ex.getMessage());
			
			
		} finally {
			try {
				connectionHandler.closeConnection();
			}
			catch(Exception e) {}
		}


		return suppliers;
	}

	@Override
	public void updateSupplier( String supplierName, String address, String city, int supplierId) {

		Connection connection = null;
		PreparedStatement query = null;
		ResultSet  results = null;
		try {

			connection = connectionHandler.getConnection();

			query = connection.prepareStatement("UPDATE Supplier SET supplierName = ?, address = ?, city = ? WHERE supplierId = ?");
			query.setString(1, supplierName ); 
			query.setString(2, address ); 
			query.setString(3, city ); 
			query.setInt(4, supplierId);
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
	public void deleteSupplier( int supplierId ) {

		Connection connection = null;
		PreparedStatement query = null;



		try {
			connection = connectionHandler.getConnection();

			query = connection.prepareStatement("DELETE FROM Supplier WHERE supplierId = ?");
			query.setInt(1, supplierId);
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
