import java.util.ArrayList;
import java.util.List;

final class Mappatore {

	private static Mappatore m_istanza = new Mappatore();
	public static Mappatore getIstanza() {
		return m_istanza;
	}
	
	//devo esplicitare costruttore e settarlo a privato altrimenti il compilatore genererebbe uno di default
	private Mappatore() {}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	
	//dato in input una superficie di mq da mappare, suddivido la superficie in quadranti
	//di valore 1 con coppia di latidune, longitudine variabili 
	public List<Mappa> mappaInQuadranti(int superficie) {

		int quad = (int) Math.sqrt(superficie);
		List<QuadranteMappa> quadranti = new ArrayList<>();
		int contatoreQuadranti = 1;
		QuadranteMappa quadranteUnitario = new QuadranteMappa();
		for(int i = 0; i < quad; i++) {
			for (int j = 0; j < quad; j++) {
				quadranteUnitario.setLatY(i);
				quadranteUnitario.setLongX(j);
				quadranteUnitario.setNumeroQuadrante(contatoreQuadranti);
				quadranti.add(quadranteUnitario);
				System.out.println(quadranteUnitario);
				quadranteUnitario = new QuadranteMappa();
				contatoreQuadranti++;
			}

		}

		System.out.println(quadranti);

		List<Mappa> righeMappa = new ArrayList();
		int contatoreRighe = 1;
		List<QuadranteMappa> posizioniQuadrante = new ArrayList<>();
		Mappa l = new Mappa();
		QuadranteMappa quadranteUnitario2 = new QuadranteMappa();

		for(int i = 0; i < quad; i++) {
			for(int j = 0; j < quad; j++) {
				quadranteUnitario2 = quadranti.remove(0);
				posizioniQuadrante.add(quadranteUnitario2);
			}

			l.setQuadranti(posizioniQuadrante);
			l.setRigaMappa(contatoreRighe);
			righeMappa.add(l);
			l = new Mappa();
			contatoreRighe++;
			posizioniQuadrante = new ArrayList<>();
			
		}

		System.out.println(righeMappa);
		System.out.println(quadranti);

		return righeMappa;
	}

	public List<Posizione> creaCoordinate(int quad){
		
		List<Posizione> posizioni = new ArrayList<>();
		Posizione posizione = new Posizione();
		for (int i = 0; i < quad; i++) {
			for (int j = 0; j < quad; j++) {
				posizione.setLatitudineY(i);
				posizione.setLongitudineX(j);
				posizioni.add(posizione);
				posizione = new Posizione();
			}
		}
		return posizioni;
	}

}

