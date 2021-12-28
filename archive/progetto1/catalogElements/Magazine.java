package progetto1.catalogElements;

import progetto1.catalog.Catalog;

public class Magazine extends Catalog{

	//personal attributes of Class Magazine
	private String periodicity;
	
	//constructor of Magazine Class 
	public Magazine(int isbnCode, String title, int yearOfPublication, int numberOfPages, Periodicity periodicity) {
		super(isbnCode, title, yearOfPublication, numberOfPages);
		this.periodicity = periodicity.getTraduction();
	}

	//setter and getter
	public String getPeriodicity() {
		return periodicity;
	}

	//method override
	@Override
	public String toString() {
		return "Rivista: USCITA_" + periodicity + "  CODICE ISBN_" + isbnCode + "  TITOLO_" + title
				+ "  ANNO DI PUBBLICAZIONE_" + yearOfPublication + "  NUMERO DI PAGINE_" + numberOfPages + ";";
	}



	
	
	
	
}
