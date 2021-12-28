package progetto1.catalogElements;

import progetto1.catalog.Catalog;

public class Book extends Catalog {

	
	//personal attributes of class
	private String author;
	private String type;
	
	
	//constructor of Book Class 
	public Book(int isbnCode, String title, int yearOfPublication, int numberOfPages, String author, String type) {
		super(isbnCode, title, yearOfPublication, numberOfPages);
		this.author = author;
		this.type = type;
		
	}
	
	public Book() {
		
	}

	//getter and setter of Catalog Class 
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return "Book: AUTORE_" + author + "  GENERE_" + type + "  CODICE ISBN_" + isbnCode + "   TITOLO_" + title
				+ "  ANNO DI PUBBLICAZIONE_" + yearOfPublication + "  NUMERO PAGINE_" + numberOfPages + ";";
	}



	
	
	
	
}
