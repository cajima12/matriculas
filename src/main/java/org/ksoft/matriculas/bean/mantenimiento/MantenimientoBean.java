package org.ksoft.matriculas.bean.mantenimiento;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mantenimiento")
@ViewScoped
public class MantenimientoBean implements Serializable{
    
    private static final long serialVersionUID = 8384327163266339070L;
    
    private MantenimientoGenericoBean<?, ?> bean;

    public MantenimientoGenericoBean<?, ?> getBean() {
        return bean;
    }

    public void setBean(MantenimientoGenericoBean<?, ?> bean) {
        this.bean = bean;
    }
}
