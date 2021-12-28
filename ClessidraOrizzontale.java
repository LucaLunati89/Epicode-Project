package package1;

import java.util.Scanner;

public class ClessidraOrizzontale {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
				
		System.out.print("Inserisci una parola: ");
		String parolaIn = in.nextLine();
		String parolaOut = "";
		

		int j = parolaIn.length();//LUNGHEZZA DELLA PAROLA
		String g = "";
		String w = " ";
		int k = j ; //CONTATORE CHE PARTE DA UN VALORE UGUALE A QUELLO DELLA LUNGHEZZA DELLA PAROLA
		int z = 0;  //CONTATORE PER CREARE STRINGA VUOTA DELLA LUNGHEZZA DELLA PAROLA
		int i = 0;  //CONTATORE PRINCIPALE
		
		//CICLO PER CREARE UNA STRINGA DI SPAZI PARI ALLA LUNGHEZZA DELLA PAROLA
		while ( z < j) {
			g = g + " ";
			z++;
		}
		
		//CICLO PER CREARE LA PRIMA PARTE 
		while ( i < j || k > 1) {
			parolaOut = parolaOut + parolaIn.charAt(i);
			System.out.print(parolaOut);
			System.out.print(g.substring(0,k) + g.substring(0,k));
			System.out.println(parolaOut);
			
			k--;
			i++;
		}
		    
		    i--;
		 
		//CICLO PER CREARE LA SECONDA PARTE
		while ( i < j ) {
			System.out.print(parolaOut.substring(0,i));
			w = w + " ";
			System.out.print(w + w);
			System.out.println(parolaOut.substring(0,i));
			if(i == 1 )
				break;
		 i--;
		}
		
		in.close();

	}

}
