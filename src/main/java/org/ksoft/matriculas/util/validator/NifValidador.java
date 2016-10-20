package org.ksoft.matriculas.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang.StringUtils;
import org.ayuncordoba.utilidades.UtilidadesNIF;
import org.ayuncordoba.utilidades.UtilidadesNIF.ExcepcionValidacionNIF;
import org.ayuncordoba.utilidades.UtilidadesNIF.InfoNIF;

@FacesValidator("nifValidador")
public class NifValidador implements Validator {

	@SuppressWarnings("unused")
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// Si el valor es null, lo transformamos en un valor vacío
    	String valor = StringUtils.defaultString((String)value);
		String result = null;
		
    	try {
    		UtilidadesNIF.InfoNIF infoNIF = UtilidadesNIF.validaNIF(valor.toUpperCase());
    		
    		if(infoNIF.getTipoNIF().equals(InfoNIF.TIPO_PERSONA_JURIDICA))
    			result = "CIF";
    		else if(infoNIF.getTipoNIF().equals(InfoNIF.TIPO_PERSONA_FISICA) &&
    				(infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_DNI) ||
    				infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_K) || 
    				infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_L) || 
    				infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_M)))
    			result = "NIF";
    		else if(infoNIF.getTipoNIF().equals(InfoNIF.TIPO_PERSONA_FISICA) &&
    				(infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_X) || 
    				infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_Y) || 
    				infoNIF.getSubTipoNIF().equals(InfoNIF.SUBTIPO_PERSONA_FISICA_Z)))
    			result = "NIE";
    		
		} catch (ExcepcionValidacionNIF e) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validación", "El valor " + valor + " no es un documento válido"));                  
		}
             
    }

}
