package org.ksoft.matriculas.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import net.sf.jooreports.templates.DocumentTemplateException;

import org.ksoft.matriculas.servicio.OdtService;

import fr.opensagres.xdocreport.core.XDocReportException;


@ManagedBean
@RequestScoped
public class GeneradorDocumentos implements Serializable  {

	private static final long serialVersionUID = 4442689233581462410L;
	
	@ManagedProperty("#{msgs['rutaPlantillasOdt']}")
	private String rutaPlantillasOdt;

	@ManagedProperty("#{msgs['rutaDocumentosOdt']}")
	private String rutaDocumentosOdt;

	@ManagedProperty("#{odtService}")
	private OdtService odtServicio;
	
	public void generarPlantilla() throws Exception {
		odtServicio.generarPlantilla(rutaPlantillasOdt);
	}
	

	public void montarPlantilla () throws IOException, DocumentTemplateException {
		odtServicio.montarPlantilla(rutaDocumentosOdt, rutaPlantillasOdt);
	}

	public void generarPlantillaxDoc() throws Exception {
		odtServicio.generarPlantilla(rutaPlantillasOdt);
	}
	

	public void montarPlantillaxDoc () throws IOException, DocumentTemplateException {
		try {
			odtServicio.montarPlantillaxDox(rutaDocumentosOdt, rutaPlantillasOdt);
		} catch (XDocReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getRutaPlantillasOdt() {
		return rutaPlantillasOdt;
	}

	public void setRutaPlantillasOdt(String rutaPlantillasOdt) {
		this.rutaPlantillasOdt = rutaPlantillasOdt;
	}

	public String getRutaDocumentosOdt() {
		return rutaDocumentosOdt;
	}

	public void setRutaDocumentosOdt(String rutaDocumentosOdt) {
		this.rutaDocumentosOdt = rutaDocumentosOdt;
	}


	public void setOdtServicio(OdtService odtServicio) {
		this.odtServicio = odtServicio;
	}
	
}
