package org.ksoft.matriculas.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidatorString implements Validator {

    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        if (!(arg2 instanceof String)) {
            throw new ValidatorException(new FacesMessage("El campo  debe ser de tipo carácter."));
        }

        String valor = (String) arg2;

        if ( valor.length() == 0 ) {
            throw new ValidatorException(new FacesMessage(
                    "Hay al menos un campo requerido sin valor. Debe introducir algún valor"));
        }
    }
    
}