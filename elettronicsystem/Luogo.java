import java.util.List;

public class Luogo {

	private List<Posizione> posizioni;

	List<Posizione> getPosizioni() {
		return posizioni;
	}

	void setPosizioni(List<Posizione> posizioni) {
		this.posizioni = posizioni;
	}

	@Override
	public String toString() {
		return "Luogo [posizioni=" + posizioni + "]";
	}

	
	
}
