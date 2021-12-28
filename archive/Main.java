import java.io.IOException;
import java.util.*;
import progetto1.archive.Archive;
import progetto1.archiveException.ArchiveException;
import progetto1.catalog.Catalog;
import progetto1.catalogElements.*;



public class Main {

	public static void main(String[] args) {

		//Scanner in = new Scanner(System.in);

		//create object from Catalog
		Catalog c1 = new Book( 1111, "Fiesta", 1950, 200, "Ernest Hemingway", "Narrativa" );
		Catalog c2 = new Book( 1234, "Il Capitale", 1870, 700, "Karl Marx", "Saggistica" );
		Catalog c3 = new Book( 1235, "L'uomo e il mare ", 1940, 90, "Ernest Hemingway", "Narrativa" );
		Catalog c4 = new Magazine( 2993, "Focus Storia", 2019, 45, Periodicity.MONTHLY );
		Catalog c5 = new Magazine( 1020, "Fab Legno", 1940, 45, Periodicity.MONTHLY );
		Catalog c6 = new Magazine( 2304, "Focus", 2020, 70, Periodicity.WEEKLY );

		//String catalogType1 = "libro";
		//String catalogType2 = "rivista";
		//Boolean t = true;
		//Boolean t2 = true;


		Archive.setCatalogToArchive(c1);
		Archive.setCatalogToArchive(c2);
		Archive.setCatalogToArchive(c3);
		Archive.setCatalogToArchive(c4);
		Archive.setCatalogToArchive(c5);
		Archive.setCatalogToArchive(c6);
		 
		Archive.setAllArchive();
		
		try {
			Archive.checkIsbn(c1.getIsbnCode());
		} catch (ArchiveException exc){
			System.out.println("Il codice ISBN è già presente in archivio.");
			System.out.println();
		}

		
		Archive.getAllArchive();
		System.out.println();

		Archive.searchByYear(170);
		System.out.println();

		Archive.searchByYear(1940);
		System.out.println();

		Archive.searchByAuthor("Ernest Hemingway");
		System.out.println();

		Archive.searchByAuthor("Ernest Hemis*****py");
		System.out.println();

		Archive.searchByIsbn(1111);
		System.out.println();

		Archive.removeCatalogFromArchiveByIsbn(1020);
		System.out.println();
		
		Archive.getAllArchive();
		System.out.println();

		try {
			Archive.writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Archive.readFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
		/*
		boolean goOn = true;
		
		System.out.println("Cosa vuoi registrare? inserisci 1 per LIBRO 2 per RIVISTA");
		while( goOn ) {
		try {
			String input1 = in.nextLine();
			if (input1.equalsIgnoreCase("libro")) {
				throw new ArchiveException();
			}
			goOn = false;
		}
		catch( ArchiveException exc ) {
			System.out.println("hai inserito un valore non valido");
		}
		
		}*/
		
	//in.close();	
		

	}
	
	
}


