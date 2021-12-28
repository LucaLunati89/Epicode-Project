package it.epicode.be05.ees.model.util;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

//COMPONENTE CHE GESTISCE I DATI A SECONDA DELL'OGGETTO CHE SI VUOLE FILTRARE E DELLA TIPOLOGIA DI FILTRO
@Component
public class Finder {

	private Pageable pageable;
	private Object finded;
	private Switcher switcher;
	
	public Pageable getPageable() {
		return pageable;
	}
	public Finder setPageable(Pageable pageable) {
		this.pageable = pageable;
		return this;
	}
	public Object getFinded() {
		return finded;
	}
	public Finder setFinded(Object finded) {
		this.finded = finded;
		return this;
	}
	public Switcher getSwitcher() {
		return switcher;
	}
	public Finder setSwitcher(Switcher switcher) {
		this.switcher = switcher;
		return this;
	}
	
	public static Finder build() {
		return new Finder();
	}
	
	public Switcher switching(String switching) {
		
		var switched = switching.toUpperCase();
		switch(switched){
		case "AFTER" : return Switcher.AFTER;
		case "BEFORE": return Switcher.BEFORE;
		case "BETWEEN": return Switcher.IN_BETWEEN;
		default: return Switcher.AFTER;
		}
	
	}
}
