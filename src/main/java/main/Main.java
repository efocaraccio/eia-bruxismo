package main;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import model.Persona;
import model.Postura;
import model.Diagnostico;
import model.Estres;
import model.Insomnio;
import model.Sintomas;
import model.AlineacionDeDientes;
import model.Contexto;
import model.Depresion;
import utils.KnowledgeSessionHelper;

public class Main {

	public static void main(String[] args) {
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
		String sessionName = "ksession-bruxismo-rules";
		KieSession session = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, sessionName);
		session.addEventListener(buildEventListener());

		Contexto contexto = createAndBuildContexto();
		Sintomas sintomas = createAndBuildSintomas();
		Persona persona = createAndBuildPersona(contexto, sintomas);
		persona.setNombre("Carlos Tevez");
		Diagnostico diagnostico = createAndBuildDiagnostico(persona);
		
		session.insert(diagnostico);
		session.fireAllRules();
		
		System.out.println(diagnostico);
	}

	private static RuleRuntimeEventListener buildEventListener() {
		return new RuleRuntimeEventListener() {
			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {

				System.out.println("Object updated \n" + event.getObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n" + event.getObject().toString());
			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted \n" + event.getOldObject().toString());
			}

		};
	}

	private static Sintomas createAndBuildSintomas() {
		Sintomas sintomas = new Sintomas();
		sintomas.setPresentaDolorDeCabeza(true);
		sintomas.setPresentaDolorDeOido(true);
		sintomas.setPresentaDolorFacial(false);
		sintomas.setPresentaInflamaciónDeMandibula(true);
		sintomas.setPresentaDesgasteDental(false);
		
		return sintomas;
	}

	private static Contexto createAndBuildContexto() {
		Contexto contexto = new Contexto();
		contexto.setDepresion(Depresion.SI);
		contexto.setEstres(Estres.NO);
		contexto.setInsomnio(Insomnio.SI);
		return contexto;
	}
	
	private static Persona createAndBuildPersona(Contexto contexto, Sintomas sintomas) {
		Persona persona = new Persona();
		persona.setContexto(contexto);
		persona.setSintomas(sintomas);
		persona.setAlineacionDeDientes(AlineacionDeDientes.MAL);
		persona.setHabitoDeApretarLosDientes(false);
		persona.setPostura(Postura.MAL);
		return persona;
	}
	
	private static Diagnostico createAndBuildDiagnostico(Persona persona) {
		Diagnostico diagnostico = new Diagnostico();
		diagnostico.setPersona(persona);
		return diagnostico;
	}
	
}
