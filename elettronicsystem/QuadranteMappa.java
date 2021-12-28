
public class QuadranteMappa {

	private static  final int K = 1;
	private int numeroQuadrante;
	private int asseX;
	private int asseY;
	
	int getNumeroQuadrante() {
		return numeroQuadrante;
	}

	QuadranteMappa setNumeroQuadrante(int numeroQuadrante) {
		this.numeroQuadrante = numeroQuadrante;
		return this;
	}
	
	public QuadranteMappa() {
		QuadranteMappa.getK();
	}
	
	int getLongX() {
		return asseX;
	}
	QuadranteMappa setLongX(int longX) {
		this.asseX = longX;
		return this;
	}
	int getLatY() {
		return asseY;
	}
	QuadranteMappa setLatY(int latY) {
		this.asseY = latY;
		return this;
	}

	static int getK() {
		return K;
	}

	@Override
	public String toString() {
		return "QuadranteMappa [NumeroQuadrante=" + numeroQuadrante + ", asseY=" + asseY
				+ ", asseX=" + asseX + "]";
	}

	
	
	

	



	
	
	
	
}
