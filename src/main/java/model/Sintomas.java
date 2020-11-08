package model;

public class Sintomas {

	Boolean presentaDolorFacial;
	Boolean presentaDolorDeCabeza;
	Boolean presentaDolorDeOido;
	Boolean presentaTrastornoAlimenticio;
	Boolean presentaInflamaciónDeMandibula;
	
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
	public Boolean getPresentaTrastornoAlimenticio() {
		return presentaTrastornoAlimenticio;
	}
	public void setPresentaTrastornoAlimenticio(Boolean presentaTrastornoAlimenticio) {
		this.presentaTrastornoAlimenticio = presentaTrastornoAlimenticio;
	}
	public Boolean getPresentaInflamaciónDeMandibula() {
		return presentaInflamaciónDeMandibula;
	}
	public void setPresentaInflamaciónDeMandibula(Boolean presentaInflamaciónDeMandibula) {
		this.presentaInflamaciónDeMandibula = presentaInflamaciónDeMandibula;
	}

	public Sintomas() {
		super();
		this.presentaDolorFacial = false;
		this.presentaDolorDeCabeza = false;
		this.presentaDolorDeOido = false;
		this.presentaTrastornoAlimenticio = false;
		this.presentaInflamaciónDeMandibula = false;
	}
	@Override
	public String toString() {
		return "Sintomas [presentaDolorFacial=" + presentaDolorFacial + ", presentaDolorDeCabeza="
				+ presentaDolorDeCabeza + ", presentaDolorDeOido=" + presentaDolorDeOido
				+ ", presentaTrastornoAlimenticio=" + presentaTrastornoAlimenticio + ", presentaInflamaciónDeMandibula="
				+ presentaInflamaciónDeMandibula + "]";
	}
	
}
