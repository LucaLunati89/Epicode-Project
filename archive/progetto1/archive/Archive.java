package progetto1.archive;

import java.io.File;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.*;

import org.apache.commons.io.FileUtils;

import progetto1.archiveException.ArchiveException;
import progetto1.catalog.Catalog;
import progetto1.catalogElements.*;

public class Archive  {

	//properties initialized of Archive Class
	private static Set<Book> booksArchive = new HashSet<>();
	private static Set<Magazine> magazinesArchive = new HashSet<>();
	private static Set<Catalog> allArchive = new HashSet<>();
	


	//getter of Archive
	public static void getBooksArchive() {
		
		for ( Book catalogated : booksArchive ) {
			System.out.println(catalogated);			
		}
		
	}

	public static void getMagazinesArchive() {
		
		for ( Magazine catalogated : magazinesArchive) {
			System.out.println(catalogated);			
		}
	}

	public static void getAllArchive(){
		
		
		for ( Catalog catalogated : allArchive) {
			System.out.println(catalogated);			
		}
	}



	//setter of Class Archive
	public  static void setCatalogToArchive( Catalog elementToArchive ) {

		if ( elementToArchive instanceof Book ) {
			booksArchive.add((Book) elementToArchive);
		}
		else {
			magazinesArchive.add((Magazine) elementToArchive);
		}

	}

	public static void setAllArchive(){

		allArchive.addAll(booksArchive);
		allArchive.addAll(magazinesArchive);

	}
	
	//method of removal of Class Archive
	public static void removeCatalogFromArchiveByIsbn ( int isbnCode) {
		
		int allArchiveBeforeRemoval = allArchive.size();
		
		for ( Catalog catalogated : allArchive ) {
			if ( catalogated.getIsbnCode() == isbnCode ) {
				allArchive.remove(catalogated);
			}
		}
		
		int allArchiveAfterRemoval = allArchive.size();
		
		if  ( allArchiveBeforeRemoval == allArchiveAfterRemoval ) {
			isbnInvalid();
		
		}else {
			catalogatedRemoved();
			System.out.println("" + isbnCode);
		
		}
				
	}

	//method of research of Class Archive 
	public static void searchByYear( int yearOfPublication ) {
		
		ArrayList <Catalog> findedByYear = new ArrayList<>();
		
		for ( Catalog catalogated : allArchive ) {

			if ( catalogated.getYearOfPublication() == yearOfPublication ) {
				findedByYear.add(catalogated);
			}

		}
		
		if ( findedByYear.size() == 0 ) {
			researchFailed();
		}else {
			researchSuccessed();
			System.out.println( "Anno: " + yearOfPublication);
			for( Catalog finded : findedByYear) {
				System.out.println(finded);
			}
						
		}
		
	}
	
	public static void searchByAuthor ( String author ) {
		
		ArrayList <Book> findedByAuthor = new ArrayList<>();
		
		for ( Book catalogated : booksArchive ) {
			
			if ( catalogated.getAuthor() == author ) {
				findedByAuthor.add(catalogated);
			}
			
		}
		
		if ( findedByAuthor.size() == 0 ) {
			researchFailed();
		}else {
			researchSuccessed();
			System.out.println("Autore: " + author);
			for ( Book finded : findedByAuthor) {
				System.out.println(finded);
			}
		}
		
	}
	
	
	public static void searchByIsbn ( int isbnCode) {
		
		ArrayList <Catalog> findedByIsbn = new ArrayList<>();
		
		for ( Catalog catalogated : allArchive ) {
			
			if ( catalogated.getIsbnCode() == isbnCode ) {
				findedByIsbn.add(catalogated);
			}
		}
		
		if ( findedByIsbn.size() == 0 ) {
			isbnInvalid();
		}else {
			researchSuccessed();
			System.out.println("ISBN: " + isbnCode);
			for( Catalog finded: findedByIsbn ) {
				System.out.println(finded);
			}
		}
		
	}
	
	
	//method of checkIsbn
	public static void checkIsbn ( int isbnCode ) throws ArchiveException {
		
		for ( Catalog catalogated : allArchive ) {
			if ( catalogated.getIsbnCode() == isbnCode ) {
				throw new ArchiveException();
			}
		}
	}
	

	
	// private method for internal uses
	private static void researchFailed() {
		System.out.println( "La ricerca non ha prodotto risultati" );
	}
	
	private static void researchSuccessed() {
		System.out.println( "La ricerca ha prodotto i seguenti risultati: " );
	}
	
	private static void isbnInvalid() {
		System.out.println( "Codice Isbn non valido");
	}
	
	private static void catalogatedRemoved() {
		System.out.println( "Hai rimosso dall'archivio l'elemento con il codice ISBN: ");
	}

	
	//registerCatalog method from Apache
	
	public static void writeFile() throws IOException {
		String allArchivetext = allArchive.toString();;
		
		File archiveFile = new File("archivefile/catalogs.txt");
		FileUtils.writeStringToFile( archiveFile, allArchivetext, "UTF-8");
	}


	public static void readFile() throws IOException {
		
		File file = new File( "archivefile/catalogs.txt" );
		String readString = FileUtils.readFileToString( file, "UTF-8" );
		String[] a = readString.split(",");
		for (String catalog : a) {
			System.out.println(catalog);
		}
		
	}

}
