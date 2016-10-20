package org.ksoft.matriculas.util;

import java.io.Serializable;
import java.util.List;

public class Error implements Serializable {

	private static final long serialVersionUID = -2520242654786833094L;

	private int linea;
	private List<String> mensajes;

	public Error(int linea, List<String> mensajes) {
		super();
		this.linea = linea;
		this.setMensajes(mensajes);
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}


}
