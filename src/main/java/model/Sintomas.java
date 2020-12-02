package model;

public class Sintomas {

	Boolean presentaDolorFacial;
	Boolean presentaDolorDeCabeza;
	Boolean presentaDolorDeOido;
	Boolean presentaDesgasteDental;
	Boolean presentaInflamaci�nDeMandibula;
	
	public Boolean getPresentaDolorFacial() {
		return presentaDolorFacial;
	}
	public void setPresentaDolorFacial(Boolean presentaDolorFacial) {
		this.presentaDolorFacial = presentaDolorFacial;
	}
	public Boolean getPresentaDolorDeCabeza() {
		return presentaDolorDeCabeza;
	}
	public void setPresentaDolorDeCabeza(Boolean presentaDolorDeCabeza) {
		this.presentaDolorDeCabeza = presentaDolorDeCabeza;
	}
	public Boolean getPresentaDolorDeOido() {
		return presentaDolorDeOido;
	}
	public void setPresentaDolorDeOido(Boolean presentaDolorDeOido) {
		this.presentaDolorDeOido = presentaDolorDeOido;
	}
	public Boolean getPresentaDesgasteDental() {
		return presentaDesgasteDental;
	}
	public void setPresentaDesgasteDental(Boolean presentaDesgasteDental) {
		this.presentaDesgasteDental = presentaDesgasteDental;
	}
	public Boolean getPresentaInflamaci�nDeMandibula() {
		return presentaInflamaci�nDeMandibula;
	}
	public void setPresentaInflamaci�nDeMandibula(Boolean presentaInflamaci�nDeMandibula) {
		this.presentaInflamaci�nDeMandibula = presentaInflamaci�nDeMandibula;
	}

	public Sintomas() {
		super();
		this.presentaDolorFacial = false;
		this.presentaDolorDeCabeza = false;
		this.presentaDolorDeOido = false;
		this.presentaDesgasteDental = false;
		this.presentaInflamaci�nDeMandibula = false;
	}
	@Override
	public String toString() {
		return "Sintomas [presentaDolorFacial=" + presentaDolorFacial + ", presentaDolorDeCabeza="
				+ presentaDolorDeCabeza + ", presentaDolorDeOido=" + presentaDolorDeOido
				+ ", presentaDesgasteDental=" + presentaDesgasteDental + ", presentaInflamaci�nDeMandibula="
				+ presentaInflamaci�nDeMandibula + "]";
	}
	
}
