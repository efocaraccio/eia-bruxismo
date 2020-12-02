package utils;

import model.AlineacionDeDientes;
import model.Contexto;
import model.Depresion;
import model.Diagnostico;
import model.DiagnosticoFinal;
import model.Estres;
import model.Insomnio;
import model.Persona;
import model.Postura;
import model.Sintomas;

public class TestCaseUtils {

	////////////////TEST CASES UTILS ////////////////

	public static void print(String title) {
		System.out.println(title);
	}

	public static void print() {
		print("");
	}

	public static void print(Diagnostico diagnostico) {

		Persona persona = diagnostico.getPersona();
		Sintomas sintomas = persona.getSintomas();
		Contexto contexto = persona.getContexto();

		print();
		print("Diagnostico Bruxismo");
		print("Persona: " + persona);
		print("Sintomas: " + sintomas);
		print("Contexto: " + contexto);
		print();
	}

	public static void assertResults(Diagnostico diagnostico, DiagnosticoFinal valorEsperado) {
		
		DiagnosticoFinal diagnosticoFinal = diagnostico.getDiagnosticoFinal();

		printResults(diagnosticoFinal.name(), valorEsperado.name());

		assert(diagnosticoFinal.equals(valorEsperado));
	}

	private static void printResults(String result,String expected) {
		print("Resultados");
		print("Esperaba: " + expected);
		print("Recibi: " + result);
		Boolean isOk = result.equals(expected);
		String condition = isOk ? "Ok" : "Fallo";
		print("Caso de prueba: "+ condition);
	}


	public static Sintomas sintomasFactory(Boolean isPositive) {
		Sintomas sintomas = new Sintomas();
		sintomas.setPresentaDolorDeCabeza(isPositive);
		sintomas.setPresentaDolorDeOido(isPositive);
		sintomas.setPresentaDolorFacial(isPositive);
		sintomas.setPresentaInflamaciónDeMandibula(isPositive);
		sintomas.setPresentaDesgasteDental(isPositive);
		return sintomas;
	}
	
	public static Contexto contextoFactory(Boolean isPositive) {
		Contexto contexto = new Contexto();
		contexto.setDepresion(isPositive ? Depresion.SI : Depresion.NO);
		contexto.setEstres(isPositive ? Estres.SI: Estres.NO);
		contexto.setInsomnio(isPositive ? Insomnio.SI : Insomnio.NO);
		return contexto;
	}

	public static Persona personaFactory(Boolean isPositive, Contexto contexto, Sintomas sintomas) {
		Persona persona = new Persona();
		persona.setNombre("any name");
		persona.setContexto(contexto);
		persona.setSintomas(sintomas);
		persona.setAlineacionDeDientes(isPositive ? AlineacionDeDientes.MAL : AlineacionDeDientes.BIEN);
		persona.setHabitoDeApretarLosDientes(isPositive);
		persona.setPostura(isPositive ? Postura.MAL : Postura.BIEN);
		return persona;
	}
	
}
