package forward;

import static utils.TestCaseUtils.assertResults;
import static utils.TestCaseUtils.print;
import static utils.TestCaseUtils.contextoFactory;
import static utils.TestCaseUtils.sintomasFactory;
import static utils.TestCaseUtils.personaFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

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
import utils.KnowledgeSessionHelper;

public class BruxismoTestCases {

	String K_SESSION_NAME = "ksession-bruxismo-rules";

	KieSession sessionStatefull;
	static KieContainer kieContainer;
		
	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		
		
		//sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, K_SESSION_NAME);
		// OutputDisplay outputDisplay = new OutputDisplay();
		//sessionStatefull.addEventListener(buildEventListener());
	}
	
	@Before
	public void setUp() {
		print("----------Start----------");
		print();
		this.prepareKnowledgeSession(); // Inicializa una nueva base de hechos
	}

	@After
	public void tearDown() {
		print();
		print("----------End----------");
		print();
	}
	
	
	@Test
	public void compatibleBruxismo() {
		print("Caso de prueba: Compatible Bruxismo - S�ntomas, contexto y tendencia a bruxismo verdaderas");
		
		Contexto contexto = contextoFactory(true);
		
		Sintomas sintomas = sintomasFactory(true);
		
		Persona persona = personaFactory(true, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.COMPATIBLE_BRUXISMO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void incompatibleBruxismoPorFaltaDeTendencia() {
		print("Caso de prueba: Incompatible Bruxismo - Tendencia a padecer bruxismo falso");
		
		Contexto contexto = contextoFactory(true);
		
		Sintomas sintomas = sintomasFactory(true);
		
		Persona persona = personaFactory(false, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.NO_DETERMINADO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void incompatibleBruxismoPorFaltaDeSintomas() {
		print("Caso de prueba: Incompatible Bruxismo - Presenta s�ntomas falso");
		
		Contexto contexto = contextoFactory(true);
		
		Sintomas sintomas = sintomasFactory(false);
		
		Persona persona = personaFactory(true, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.NO_DETERMINADO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void incompatibleBruxismoPorFaltaDeContexto() {
		print("Caso de prueba: Incompatible Bruxismo - Posee contexto desfavorable falso");
		
		Contexto contexto = contextoFactory(false);
		
		Sintomas sintomas = sintomasFactory(true);
		
		Persona persona = personaFactory(true, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.NO_DETERMINADO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void compatibleBruxismoPorEstresPositivo() {
		print("Caso de prueba: Compatible Bruxismo - Contexto: insomnio y depresi�n negativo pero estr�s positivo");
		
		Contexto contexto = contextoFactory(false);
		contexto.setEstres(Estres.SI);
		
		Sintomas sintomas = sintomasFactory(true);
		
		Persona persona = personaFactory(true, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.COMPATIBLE_BRUXISMO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void incompatibleBruxismoPorFaltaDeDatos() {
		print("Caso de prueba: Incompatible Bruxismo - Valores por default");
	
		Persona persona = new Persona();
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.NO_DETERMINADO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void compatibleBruxismoPorHabitoDeApretarDientes() {
		print("Caso de prueba: Compatible Bruxismo - Tendencia a bruxismo: H�bito de apretar los dientes verdadero");
	
		Contexto contexto = contextoFactory(true);
		
		Sintomas sintomas = sintomasFactory(true);
		
		Persona persona = personaFactory(false, contexto, sintomas);
		persona.setHabitoDeApretarLosDientes(true);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.COMPATIBLE_BRUXISMO;
		
		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void compatibleBruxismoPorAlMenosUnSintomaPresente() {
		print("Caso de prueba: Compatible Bruxismo - Al menos un s�ntoma est� presente");
	
		Contexto contexto = contextoFactory(true);
		
		Sintomas sintomas = sintomasFactory(false);
		sintomas.setPresentaTrastornoAlimenticio(true);
		
		Persona persona = personaFactory(true, contexto, sintomas);
		
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		
		print(diagnostico);

		sessionStatefull.insert(diagnostico);
		sessionStatefull.fireAllRules();
		
		DiagnosticoFinal valorEsperado = DiagnosticoFinal.COMPATIBLE_BRUXISMO;
		
		assertResults(diagnostico, valorEsperado);
	}
}
