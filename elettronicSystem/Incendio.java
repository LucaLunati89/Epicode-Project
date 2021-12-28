import java.util.ArrayList;
import java.util.List;

public class Incendio {
	
	private QuadranteMappa puntodiAccensione;
	private int tempoDiAccensione;
	private List<Posizione> estensione;
	private int quantitaDiFumo; 
	
	QuadranteMappa getPuntodiAccensione() {
		return puntodiAccensione;
	}
	void setPuntodiAccensione(QuadranteMappa puntodiAccensione) {
		this.puntodiAccensione = puntodiAccensione;
	}
	int getQuantitaDiFumo() {
		return quantitaDiFumo;
	}
	void setQuantitaDiFumo(int quantitaDiFumo) {
		this.quantitaDiFumo = quantitaDiFumo;
	}
	List<Posizione> getEstensione() {
		return estensione;
	}
	int getTempoDiAccensione() {
		return tempoDiAccensione;
	}
	void setTempoDiAccensione(int tempoDiAccensione) {
		this.tempoDiAccensione = tempoDiAccensione;
	}
	void setEstensione(List<Posizione> estensione) {
		this.estensione = estensione;
	}
	@Override
	public String toString() {
		return "Incendio [puntodiAccensione=" + puntodiAccensione + ", quantitaDiFumo=" + quantitaDiFumo + "]";
	}

	public void bruciaPosizioni(Incendio incendio, int tempoAccensione) {
		
		final int  t1 = 100;
		final int  t2 = t1 * 1;
		final int  t3 = t1 * 2;
		final int  t4 = t1 * 3;
		final int  minuto5 = t1 * 4;
		
		switch(tempoAccensione) {
		case t1: incendio.setEstensione(incendio.getEstensione().add(incendio.));
		}
		
	}
	
	
	
	/*
	public static  List<QuadranteMappa> bruciaQuadranti(Incendio incendio){
		 List<QuadranteMappa> quadranti = new ArrayList<>();
		switch(incendio.tempodiAccensione) {
		case 10 : 
			incendio.setQuantitaDiFumo(0);
			break;
		case 20 : 
			incendio.setQuantitaDiFumo(1);
			quadranti.add(incendio.getPuntodiAccensione());
			quadranti.add(new QuadranteMappa()
					.setLongX(incendio.getPuntodiAccensione().getLongX())
					.setLatY(incendio.getPuntodiAccensione().getLatY()+1)
					.setNumeroQuadrante(incendio.getPuntodiAccensione()
					.getNumeroQuadrante()+1));
			break;
		case 30 : 
			incendio.setQuantitaDiFumo(2);
			quadranti.add(incendio.getPuntodiAccensione());
			quadranti.add(new QuadranteMappa()
					.setLongX(incendio.getPuntodiAccensione().getLongX())
					.setLatY(incendio.getPuntodiAccensione().getLatY()+1)
					.setNumeroQuadrante(incendio.getPuntodiAccensione()
					.getNumeroQuadrante()+1));
			quadranti.add(new QuadranteMappa()
					.setLongX(incendio.getPuntodiAccensione().getLongX())
					.setLatY(incendio.getPuntodiAccensione().getLatY()+2)
					.setNumeroQuadrante(incendio.getPuntodiAccensione()
					.getNumeroQuadrante()+2));
			break;
		}
		
		return quadranti;
	}
	
	}*/
	
	
	
	
	
	
}
