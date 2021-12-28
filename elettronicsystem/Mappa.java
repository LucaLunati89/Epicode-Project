import java.util.List;

public class Mappa {
	
	private int numeroRigaMappa;
	private List<QuadranteMappa> quadranti;

	List<QuadranteMappa> getQuadranti() {
		return quadranti;
	}

	Mappa setQuadranti(List<QuadranteMappa> posizioni) {
		this.quadranti = posizioni;
		return this;
	}
	
	int getRigaMappa() {
		return numeroRigaMappa;
	}

	void setRigaMappa(int rigaMappa) {
		numeroRigaMappa = rigaMappa;
	}

	@Override
	public String toString() {
		return "Mappa [numeroRigaMappa=" + numeroRigaMappa + ", Quadranti=" + quadranti + "]";
	}

	
	
	
	
	
}
