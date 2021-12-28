import java.util.ArrayList;
import java.util.List;

public class Sonda {

	private QuadranteMappa quadranteInstallazione; //quadrante in cui è posizionata la sonda
	private List<QuadranteMappa> areaDiCaptazione; //l'area che la sonda riesce a percepire -> 1 riga della mappa
	private int quantitaDiFumoCaptata; 
	private	int[] rilevatoreDiFumo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //"termometro" del fumo
	
	private List<MicroControllore> microControllore = new ArrayList<>() ; 
	
	public void aggiungiControllore(MicroControllore microControllore) {
		this.microControllore.add(microControllore);
	}
	
	public void rimuoviControllore(MicroControllore microControllore) {
		this.microControllore.remove(microControllore);
	}
	
	public void rilevaFumo() {
		
	}
}
