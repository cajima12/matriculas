package org.ksoft.matriculas.util;

import java.util.ArrayList;
import java.util.List;

public class ResultadoInsercion {
	private int numRegistros;
	private List<Error> errores = new ArrayList<Error>();
	private boolean commit;

	public ResultadoInsercion() {

	}

	public ResultadoInsercion(int numRegistros, List<Error> errores, boolean commit) {
		super();
		this.numRegistros = numRegistros;
		this.errores = errores;
		this.commit = commit;
	}

	public int getNumRegistros() {
		return numRegistros;
	}

	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}

	public List<Error> getErrores() {
		return errores;
	}

	public void setErrores(List<Error> errores) {
		this.errores = errores;
	}

	public boolean isCommit() {
		return commit;
	}

	public void setCommit(boolean commit) {
		this.commit = commit;
	}
}
