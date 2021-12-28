import java.util.List;

public class Adattatore {
	
	private Posizione posizione;
	private List<QuadranteMappa> rigaQuadrante;
	
	Posizione getPosizione() {
		return posizione;
	}
	void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}
	List<QuadranteMappa> getRigaQuadrante() {
		return rigaQuadrante;
	}
	void setRigaQuadrante(List<QuadranteMappa> rigaQuadrante) {
		this.rigaQuadrante = rigaQuadrante;
	}
	
	
}
