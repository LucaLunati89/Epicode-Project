import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		//attraverso il metodo getIstanza creo un unico oggetto di tipo Mappatore
		Mappatore mappatore = Mappatore.getIstanza();
				
		//metri quadri superficie mappata (1 metro per 1 metro)
		int superficie = 36; 
		int quad = (int) Math.sqrt(superficie);
		int numeroSonde = quad;
		int numeroLuoghi = 3 ; 
		//mappatura lineare superficie 
		List<Mappa> righeMappa =mappatore.mappaInQuadranti(superficie); 
		System.out.println(righeMappa);
		
		List<Posizione> posizioni = mappatore.creaCoordinate(superficie);
		System.out.println(posizioni);
		
		//posiziono le sonde nei primi quadranti di ogni riga -> le coordinate reali sono solo quelle 
		//dei quadranti e non degli incendi. Considera i quadranti successivi come l'intensità che 
		//acquisisce l'incendio al passare dei secondi -> aumento quantità di fumo
		List<Sonda> sonde = new ArrayList<>();
		//l'ultimo quadrante di ogni riga corrisponde all'inizio di captazione della quantità di fumo,
		//da parte della sonda
		
		//appicco incendi che partono dall'ultimo quadrante 
		List<Incendio> incendi = new ArrayList<>();
		Incendio incendio = new Incendio();
		for (int i = 0; i < quad; i ++) {
			// il punto di partenza del fuoco è l'ultimo quadrante di ogni riga
			incendio.setPuntodiAccensione(righeMappa.get(i).getQuadranti().get(quad - 1));
			//la quantità iniziale di fumo
			incendio.setQuantitaDiFumo(0); 
			incendi.add(incendio);
			incendio = new Incendio();
		}
		
		System.out.println(incendi);
		
		//numero di secondi di cui necessita il fuoco per aumentare di intensità -> aumento livello di fumo
		int secondi = 100; 
		//tempo massimo considerando la partenza dall'ultimo quadrante della riga
		int tempo = quad * secondi;
		/*
		for(int i = 0; i < tempo; i++) {
			System.out.println(i + "secondi");
			if( i == 100) {
				
			}
		}*/
		//(capta quantità di fumo)sonda ->->->->->5<-<-<-<-<-incendio(aumenta quantità di fumo)
		
													
		/*Incendio incendio = new Incendio();
		incendio.setPuntodiAccensione(righeMappa.get(5).getQuadranti().get(0));
		incendio.setTempodiAccensione(20);
		
		Incendio incendio2 = new Incendio();
		incendio2.setPuntodiAccensione(righeMappa.get(1).getQuadranti().get(0));
		incendio2.setTempodiAccensione(20);
		
		System.out.println(incendio);
		System.out.println(incendio2);
		System.out.println(Incendio.bruciaQuadranti(incendio));
		System.out.println(	Incendio.bruciaQuadranti(incendio2));
		System.out.println(incendio);
		System.out.println(incendio2);
		ComponenteProxy cproxy = new ComponenteProxy();
		cproxy.metodo();*/
	}

}
