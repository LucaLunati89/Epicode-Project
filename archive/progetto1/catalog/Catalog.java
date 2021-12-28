package progetto1.catalog;





public class Catalog  {

	//properties of Catalog Class
	protected int isbnCode;
	protected String title;
	protected int yearOfPublication;
	protected int numberOfPages;
	
	
	//constructor of Catalog Class 
	public Catalog(int isbnCode, String title, int yearOfPublication, int numberOfPages) {
		
		this.isbnCode = isbnCode;
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.numberOfPages = numberOfPages;
		
	}
	
	public Catalog() {
		
	}
	
	

	//getter and setter of Catalog Class 
	public int getIsbnCode() {
		return isbnCode;
	}


	protected void setIsbnCode(int isbnCode) {
		this.isbnCode = isbnCode;
	}


	protected String getTitle() {
		return title;
	}


	protected void setTitle(String title) {
		this.title = title;
	}


	public int getYearOfPublication() {
		return yearOfPublication;
	}


	protected void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}


	public int getNumberOfPages() {
		return numberOfPages;
	}


	protected void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	


	
	
	
	
	
	
}
