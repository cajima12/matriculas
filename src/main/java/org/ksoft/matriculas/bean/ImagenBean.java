package org.ksoft.matriculas.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.ksoft.matriculas.util.Funciones;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class ImagenBean implements Serializable{
	
	private static final long serialVersionUID = 7768388015338073457L;
	private StreamedContent imagen;
	private StreamedContent pdf;
	
	public StreamedContent getImagen() {
		return imagen;
	}
	
	public void setImagen(File ficheroImagen) throws IOException {
		imagen = Funciones.toStreamedContent(ficheroImagen);
	}
	
	public void setImagen(byte[] bytes) throws IOException {
		imagen = Funciones.toStreamedContent(bytes);
	}
	
	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}

	public StreamedContent getPdf() {
		return pdf;
	}

	public void setPdf(StreamedContent pdf) {
		this.pdf = pdf;
	}
	
	public void setPdf(byte[] bytes) throws IOException {
		this.pdf = Funciones.toStreamedContent(bytes, "application/pdf");
	}
	
}
