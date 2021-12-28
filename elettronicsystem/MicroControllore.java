//ogni microcontrollore osserva il comportamento di una sonda
public class MicroControllore implements Controllore {

	private QuadranteMappa quadranteMicroControllore; 
	//quadrante in cui è posizionato il Controllore 
	//è lo stesso della sonda a cui è associato
	
	
	@Override
	public void notificaLivelloFumoSonda(int datoSonda) {
		System.out.println("il livello di fumo rilevato dalla Sonda è: " + datoSonda);
		
	}

}
