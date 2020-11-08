package model;

public class Diagnostico {
	Boolean contextoDesfavorable;
	Boolean tendenciaABruxismo;
	DiagnosticoFinal diagnosticoFinal;
	public Persona persona;
	
	
	public Diagnostico() {
		super();
		this.contextoDesfavorable = false;
		this.tendenciaABruxismo = false;
		this.diagnosticoFinal = DiagnosticoFinal.NO_DETERMINADO;
	}
	public Boolean getContextoDesfavorable() {
		return contextoDesfavorable;
	}
	public void setContextoDesfavorable(Boolean contextoDesfavorable) {
		this.contextoDesfavorable = contextoDesfavorable;
	}
	public Boolean getTendenciaABruxismo() {
		return tendenciaABruxismo;
	}
	public void setTendenciaABruxismo(Boolean tendenciaABruxismo) {
		this.tendenciaABruxismo = tendenciaABruxismo;
	}
	public DiagnosticoFinal getDiagnosticoFinal() {
		return diagnosticoFinal;
	}
	public void setDiagnosticoFinal(DiagnosticoFinal diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Diagnostico de " + persona.nombre + ": [contextoDesfavorable=" + contextoDesfavorable + ", tendenciaABruxismo="
				+ tendenciaABruxismo + ", presentaSintomas=" + persona.presentaSintomas + ", diagnosticoFinal=" + diagnosticoFinal + "]";
	}
}
