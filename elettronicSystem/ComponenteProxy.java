
public class ComponenteProxy implements InterfacciaComponente{

	Componente componente = new Componente();
	@Override
	
	public void metodo() {
		componente.metodo();
	}

}
