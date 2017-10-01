package modelo.dominio.exception;

public class Reflection {
	
	//Validar o nome da Classe Recebido.
	public static String verificaNomeClasse(String nomeClasse) {
		
		nomeClasse = nomeClasse.substring(0,1).toUpperCase().concat(nomeClasse.substring(1));
		return nomeClasse;
	}

}
