package progetto1.catalogElements;

public enum Periodicity {

	WEEKLY("settimanale"), MONTHLY("mensile"), HALF_YEARLY("semestrale");
	
	//attribute of the enumerator
	private final String traduction;

	//constructor of the enumerator
	private Periodicity(String traduction) {
		this.traduction = traduction;
	}

	//getter
	public String getTraduction() {
		return traduction;
	}


	
	
	
	
}
