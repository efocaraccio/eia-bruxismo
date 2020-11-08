package model;

public class Contexto {
	Estres estres;
	Depresion depresion;
	Insomnio insomnio;
	public Estres getEstres() {
		return estres;
	}
	public void setEstres(Estres estres) {
		this.estres = estres;
	}
	public Depresion getDepresion() {
		return depresion;
	}
	public void setDepresion(Depresion depresion) {
		this.depresion = depresion;
	}
	public Insomnio getInsomnio() {
		return insomnio;
	}
	public void setInsomnio(Insomnio insomnio) {
		this.insomnio = insomnio;
	}

	public Contexto() {
		super();
		this.estres = Estres.NO_DETERMINADO;
		this.depresion = Depresion.NO_DETERMINADO;
		this.insomnio = Insomnio.NO_DETERMINADO;
	}
	@Override
	public String toString() {
		return "Contexto [estres=" + estres + ", depresion=" + depresion + ", insomnio=" + insomnio + "]";
	}

}
