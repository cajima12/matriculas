package org.ksoft.matriculas.util;

import java.util.List;

public class TransformacionException extends RuntimeException{

	private static final long serialVersionUID = 8637470112791167700L;
	
	private List<String> errores;
	
	public TransformacionException(List<String> errores) {
		this.errores = errores;
	}
	
	public List<String> getErrores() {
		return errores;
	}

}
