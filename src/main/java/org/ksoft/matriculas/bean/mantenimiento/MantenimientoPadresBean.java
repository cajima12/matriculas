package org.ksoft.matriculas.bean.mantenimiento;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.ksoft.matriculas.modelo.Direccion;
import org.ksoft.matriculas.modelo.Localidades;
import org.ksoft.matriculas.modelo.Persona;
import org.ksoft.matriculas.modelo.Persona.TipoPersona;
import org.ksoft.matriculas.modelo.Provincias;
import org.ksoft.matriculas.modelo.TipoVia;
import org.ksoft.matriculas.modelo.dto.DireccionDto;
import org.ksoft.matriculas.repositorio.PersonaRepositorio;
import org.ksoft.matriculas.servicio.DireccionServicio;
import org.ksoft.matriculas.util.Funciones;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class MantenimientoPadresBean extends MantenimientoGenericoBean<Persona, Long> {

	private static final long serialVersionUID = -2604562030610160837L;

	private static final Logger log = Logger.getLogger(MantenimientoPadresBean.class);

	private TipoPersona tipoPersona;
	
	@ManagedProperty("#{personaRepositorio}")
	private PersonaRepositorio personaRepo;

	@ManagedProperty("#{direccionServicio}")
	private DireccionServicio direccionServicio;
	
	private List<Direccion> lstDirecciones = new ArrayList<Direccion>();
	private DireccionDto direccion;
	
	private List<TipoVia> lstTipoVia = new ArrayList<TipoVia>();
	private TipoVia tipoViaSelect = new TipoVia();

	private List<Provincias> lstProvincias = new ArrayList<Provincias>();
	private Provincias provinciaSelect = new Provincias();

	private List<Localidades> lstLocalidades = new ArrayList<Localidades>();
	private Localidades localidadesSelect = new Localidades();

	public MantenimientoPadresBean() {
	}
	
	@Override
	public void cargarListado( List<Persona> listado ) {
		log.debug("Cargando listado personas del usuario " + Funciones.getUsuarioLogado().getUsuario() );
		listado.addAll(personaRepo.findAllByUsuario(Funciones.getUsuarioLogado().getUsuario()));
	}
	
	@Override
	public void guardar() {
		getInstancia().setUsuario(Funciones.getUsuarioLogado().getUsuario());
		super.guardar();
	}
	
	@Override
	public void setInstancia( Persona persona ) {
		lstDirecciones = new ArrayList<Direccion>();
		lstDirecciones.addAll(direccionServicio.getDireccionesPersona(persona));
		super.setInstancia(persona);
	}

	public void crearDireccion() {
		direccion = new DireccionDto();
		tipoViaSelect = new TipoVia();
		abrirModal("dialogoDirecciones");
	}
	
	public void cancelarDireccion() {
		direccion=null;
		tipoViaSelect=null;
		cerrarModal("dialogoDirecciones");
	}
	
    public List<TipoVia> metodoAutocompletarTipoVia(String query) {
    	lstTipoVia = new ArrayList<TipoVia>();
    	lstTipoVia = direccionServicio.filtrarTiposViasAutocompletar(query);
        return lstTipoVia;
    }
    
    public void guardarDireccion() {
    	direccion.setLocalidad(localidadesSelect);
    	direccion.setTipoVia(tipoViaSelect);
    	System.out.println("guardando direccion => " + direccion.getDireccion());
    }
    
	public void abrirModal(String id) {
		RequestContext.getCurrentInstance().execute("PF('" + id + "').show();");
	}
	
	public void cerrarModal(String id) {
		RequestContext.getCurrentInstance().execute("PF('" + id + "').hide();");
	}
	
	public void actualizar(String id) {
		RequestContext.getCurrentInstance().update(id);
	}
	
	public void setPersonaRepo(PersonaRepositorio personaRepo) {
		this.personaRepo = personaRepo;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public void setDireccionServicio(DireccionServicio direccionServicio) {
		this.direccionServicio = direccionServicio;
	}

	public List<Direccion> getLstDirecciones() {
		return lstDirecciones;
	}

	public void setLstDirecciones(List<Direccion> lstDirecciones) {
		this.lstDirecciones = lstDirecciones;
	}

	public DireccionDto getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDto direccion) {
		this.direccion = direccion;
	}

	public TipoVia getTipoViaSelect() {
		return tipoViaSelect;
	}

	public void setTipoViaSelect(TipoVia tipoViaSelect) {
		this.tipoViaSelect = tipoViaSelect;
	}

	public List<TipoVia> getLstTipoVia() {
		lstTipoVia = direccionServicio.getTiposVia();
		return lstTipoVia;
	}

	public void setLstTipoVia(List<TipoVia> lstTipoVia) {
		this.lstTipoVia = lstTipoVia;
	}

	public List<Provincias> getLstProvincias() {
		lstProvincias = direccionServicio.getProvincias();
		return lstProvincias;
	}

	public void setLstProvincias(List<Provincias> lstProvincias) {
		this.lstProvincias = lstProvincias;
	}

	public Provincias getProvinciaSelect() {
		return provinciaSelect;
	}
	
	public void setProvinciaSelect(Provincias provinciaSelect) {
		this.provinciaSelect = provinciaSelect;
	}
	
	public List<Localidades> getLstLocalidades() {
		if ( provinciaSelect != null && provinciaSelect.getId() != null )
			try {
				lstLocalidades = direccionServicio.getLocalidadesProvincia(provinciaSelect);
			} catch (Exception e) {
				lstLocalidades = new ArrayList<Localidades>();
			}
		else
			lstLocalidades = new ArrayList<Localidades>();
		return lstLocalidades;
	}

	public void setLstLocalidades(List<Localidades> lstLocalidades) {
		this.lstLocalidades = lstLocalidades;
	}

	public Localidades getLocalidadesSelect() {
		return localidadesSelect;
	}

	public void setLocalidadesSelect(Localidades localidadesSelect) {
		this.localidadesSelect = localidadesSelect;
	}
	
}
