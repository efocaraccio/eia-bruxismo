package model;

public class Persona {

	String nombre;
	AlineacionDeDientes alineacionDeDientes;
	Postura postura;
	Boolean habitoDeApretarLosDientes;
	Boolean presentaSintomas;
	public Sintomas sintomas;
	public Contexto contexto;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AlineacionDeDientes getAlineacionDeDientes() {
		return alineacionDeDientes;
	}
	
	public void setAlineacionDeDientes(AlineacionDeDientes alineacionDeDientes) {
		this.alineacionDeDientes = alineacionDeDientes;
	}
	
	public Postura getPostura() {
		return postura;
	}
	
	public void setPostura(Postura postura) {
		this.postura = postura;
	}
	
	public Boolean getHabitoDeApretarLosDientes() {
		return habitoDeApretarLosDientes;
	}
	
	public void setHabitoDeApretarLosDientes(Boolean habitoDeApretarLosDientes) {
		this.habitoDeApretarLosDientes = habitoDeApretarLosDientes;
	}
	
	public Boolean getPresentaSintomas() {
		return presentaSintomas;
	}
	
	public void setPresentaSintomas(Boolean presentaSintomas) {
		this.presentaSintomas = presentaSintomas;
	}

	public Sintomas getSintomas() {
		return sintomas;
	}

	public void setSintomas(Sintomas sintomas) {
		this.sintomas = sintomas;
	}

	public Contexto getContexto() {
		return contexto;
	}

	public void setContexto(Contexto contexto) {
		this.contexto = contexto;
	}

	public Persona(Boolean habitoDeApretarLosDientes,
			Boolean presentaSintomas) {
		super();
		this.alineacionDeDientes = AlineacionDeDientes.ND;
		this.postura = Postura.ND;
		this.habitoDeApretarLosDientes = habitoDeApretarLosDientes;
		this.presentaSintomas = presentaSintomas;
		this.sintomas = new Sintomas();
		this.contexto = new Contexto();
	}
	
	public Persona() {
		super();
		this.alineacionDeDientes = AlineacionDeDientes.ND;
		this.postura = Postura.ND;
		this.presentaSintomas = false;
		this.sintomas = new Sintomas();
		this.contexto = new Contexto();
	}

	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", alineacionDeDientes=" + alineacionDeDientes + ", postura=" + postura
				+ ", habitoDeApretarLosDientes=" + habitoDeApretarLosDientes + "]";
	}
	
}
